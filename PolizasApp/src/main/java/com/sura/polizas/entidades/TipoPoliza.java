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
	
	private int codigo ;
	private String descripcion ;
	
	TipoPoliza(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
