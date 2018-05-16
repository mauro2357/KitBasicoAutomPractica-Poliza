/**
 * 
 */
package com.sura.polizas.entidades;

/**
 * @author 
 *
 */
public class Asegurado {

	private String tipoIdentificacion ;
	private String numeroIdentificacion ;
	private String idPoliza ;
	
	public Asegurado() {
		
	}
	public Asegurado(String tipoIdentificacion, String numeroIdentificacion, String idPoliza) {
		super();
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.idPoliza = idPoliza;
	}	
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(String idPoliza) {
		this.idPoliza = idPoliza;
	}
	
}
