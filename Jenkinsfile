// This shows a simple build wrapper example, using the AnsiColor plugin.

	pipeline {
		agent any
		triggers { pollSCM('* * * * *') }

		stages{


			stage('Probar unitariamente') { 
				steps { 
					bat "test.bat"
				}
			}

			stage('Analisis de código') { 
				steps { 
					withSonarQubeEnv('SonarQubeLocal') {
						bat 'anali_code.bat'
					}
					
				}
			}
			
			stage('Verificar calidad técnica') { 
				steps { 
					script{					
					timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
						def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
						if (qg.status != 'OK') {
						  error "Pipeline aborted due to quality gate failure: ${qg.status}"
						}
					}
					}
				}
			}

			stage('Generar desplegable') {
				steps {
					powershell 'wget http://localhost:6969/shutdown'
					powershell 'wget http://localhost:9696/shutdown'
					bat "build.bat"

				}
			}

			stage('Desplegar Integraci�n') {
				steps {
					bat "deploy-bd-dev.bat"
					bat "deploy-app.bat"
				}
			}


			stage('Versionar'){
				steps {
					script{
						// Obtain an Artifactory server instance, defined in Jenkins --> Manage:
						def server = Artifactory.server 'Jenkins-Local'

						def uploadSpec = """{
						  "files": [
							{
							  "pattern": "*.jar",
							  "target": "kit-basico-repository"
							}
						 ]
						}"""
						def buildInfo2=server.upload(uploadSpec)
						
						server.publishBuildInfo buildInfo2
		
					}
				}
			}


			stage('Desplegar Pruebas') { 
				steps { 
				
					script{	
					
					input "Desea desplegar a pruebas?"
					
						checkout([$class: 'GitSCM', 
						branches: [[name: '*/master']], 
						doGenerateSubmoduleConfigurations: false, 
						extensions: [[$class: 'RelativeTargetDirectory', 
							relativeTargetDir: 'KitBasicoAutomPractica-Poliza-Ops']], 
						submoduleCfg: [], 
						userRemoteConfigs: [[url: 'https://github.com/mauro2357/KitBasicoAutomPractica-Poliza-Ops.git']]])     
			      }
					bat 'mkdir "PolizasApp/build/libs/config"'
					bat 'xcopy "KitBasicoAutomPractica-Poliza-Ops/config" "PolizasApp/build/libs/config"'
					bat "deploy-bd-pru.bat"
					bat "deploy-app.bat"
				}
			}


		}
		

		post {
			failure {
				mail to: 'csanchez@eknowit.com',
					subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
					body: "Something is wrong with ${env.BUILD_URL}"
			}
		}

	}
