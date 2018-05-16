package com.sura.polizas.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="poliza")
public class Poliza {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idPoliza;
	
	private int tipoPoliza;
	
	private String empresa;
	
	private BigDecimal valorPoliza;
	
	public Poliza() {
		super();
	}
	
	public Poliza(int tipoPoliza, String empresa, BigDecimal valorPoliza) {
		super();
		this.tipoPoliza=tipoPoliza;
		this.empresa=empresa;
		this.valorPoliza=valorPoliza;
		
	}
	
	public Long getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(Long idPoliza) {
		this.idPoliza = idPoliza;
	}
	public int getTipoPoliza() {
		return tipoPoliza;
	}
	public void setTipoPoliza(int tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public BigDecimal getValorPoliza() {
		return valorPoliza;
	}
	public void setValorPoliza(BigDecimal valorPoliza) {
		this.valorPoliza = valorPoliza;
	}
	
	//Devuelve boolean si es asegurable
	public void validaPedido(String idPoliza, String tipoDocumento, String numeroDocumento, String placa) {
		
		//Se obtiene la poliza con el idPoliza --> POLIZA
			//No se encuentra devuelve --> false
		
		//Se obtiene el asegurado --> llama REST /api/asegurado/{tipo_numero_doc}  --> ASEGURADO
			//No se encuentra devuelve --> false
		
		//Se obtiene vehiculo --> llama REST /api/vehiculo/{placa} --> VEHICULO
			//No se encuentra devuelve --> false
		
		//if(POLIZA.tipo==COLECTIVA)
			// se valida ASEGURADO pertenece EMPRESA  --> /api/asegurado/valida
				//No es valido --> false
		
		//else //INDIVIDUAL
			// se valida VEHICULO zon circulacion  --> /api/vehiculo/valida
				//No es valido --> false
		
		// devuelve --> true
		
	}
	
	
	
}
