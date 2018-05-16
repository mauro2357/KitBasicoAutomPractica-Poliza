package com.sura.polizas.bean;

public class RespuestaValidaBean {

	private boolean asegurable;
	private String mensaje;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isAsegurable() {
		return asegurable;
	}
	public void setAsegurable(boolean asegurable) {
		this.asegurable = asegurable;
	}
	
	public static RespuestaValidaBean buildNoFinanciado(String mensaje) {
		RespuestaValidaBean respuesta = new RespuestaValidaBean();
		respuesta.asegurable = false ;
		respuesta.mensaje = mensaje ;
		return respuesta;
	}

	public static RespuestaValidaBean buildFinanciado() {
		RespuestaValidaBean respuesta = new RespuestaValidaBean();
		respuesta.asegurable = true ;
		return respuesta;
	}
	
	
}
