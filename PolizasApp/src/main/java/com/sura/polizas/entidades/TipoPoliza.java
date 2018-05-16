/**
 * 
 */
package com.sura.polizas.entidades;

/**
 * @author 
 *
 */
public enum TipoPoliza {
	
	INDIVIDUAL(1,"Poliza individual") , 
	COLECTIVO (2,"Poliza Colectiva");
	
	public int codigo ;
	public String descripcion ;
	
	TipoPoliza(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;		
	}

}
