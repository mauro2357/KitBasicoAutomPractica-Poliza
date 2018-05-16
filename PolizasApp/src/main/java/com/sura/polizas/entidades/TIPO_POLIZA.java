/**
 * 
 */
package com.sura.polizas.entidades;

/**
 * @author 
 *
 */
public enum TIPO_POLIZA {
	
	INDIVIDUAL(1,"Poliza individual") , 
	COLECTIVO (2,"Poliza Colectiva");
	
	public int codigo ;
	public String descripcion ;
	
	TIPO_POLIZA(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;		
	}

}
