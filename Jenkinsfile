// This shows a simple build wrapper example, using the AnsiColor plugin.

	pipeline {
		agent any
		triggers { pollSCM('* * * * *') }

		stages{

			stage('Generar desplegable') {
				steps {
					powershell 'wget http://localhost:6969/shutdown'
					powershell 'wget http://localhost:9696/shutdown'
					bat "build.bat"

				}
			}

			stage('Desplegar Integraci�n') {
				steps {
					bat "deploy-app.bat"
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
					bat "deploy-bd.bat"
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
