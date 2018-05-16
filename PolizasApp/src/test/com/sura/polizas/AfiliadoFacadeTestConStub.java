package com.sura.polizas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sura.polizas.configuration.ApplicationTestConfiguration;
import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.facade.IPolizaFacade;
import com.sura.polizas.facade.PolizaFacade;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {ApplicationTestConfiguration.class, PolizaFacade.class})
public class AfiliadoFacadeTestConStub {
	
	@Autowired
	IPolizaFacade polizaFacade;
	
	@Autowired
	PolizasRepository polizasRepository;
	
	@Test
	public void validarPoliza() {
		
	}
	
	
	
}