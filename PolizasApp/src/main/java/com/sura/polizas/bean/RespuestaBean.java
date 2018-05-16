package com.sura.polizas.bean;

import java.math.BigDecimal;

public class RespuestaBean {

	private boolean financiado;
	private BigDecimal valorPoliza;

	public boolean isFinanciado() {
		return financiado;
	}
	public void setFinanciado(boolean financiado) {
		this.financiado = financiado;
	}
	public BigDecimal getValorPoliza() {
		return valorPoliza;
	}
	public void setValorPoliza(BigDecimal valorPoliza) {
		this.valorPoliza = valorPoliza;
	}
	
}
