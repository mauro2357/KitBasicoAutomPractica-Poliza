package com.sura.polizas.facade;

import com.sura.polizas.bean.Asegurado;
import com.sura.polizas.bean.RespuestaValidaBean;

public interface IAseguradoFacade {

	public RespuestaValidaBean valida(Asegurado asegurado) ;
	
}
