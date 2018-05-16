package com.sura.polizas.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;

public class PolizaFacade implements IPolizaFacade{

	@Autowired
	PolizasRepository polizasRepository;
	
	public Poliza findById(long id) {
		return polizasRepository.findById(id)
        .orElse(new Poliza());
	}
}
