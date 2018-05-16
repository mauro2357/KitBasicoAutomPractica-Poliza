package com.sura.polizas.facade;

import com.sura.polizas.bean.RespuestaValidaBean;
import com.sura.polizas.entidades.Poliza;

public interface IPolizaFacade {
	
	public Poliza findById(long id);
	
	public RespuestaValidaBean validaPedido(long id, String tipoDocumento, String numeroDocumento, String placa) ;

}
