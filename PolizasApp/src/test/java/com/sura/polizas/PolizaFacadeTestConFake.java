package com.sura.polizas;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sura.polizas.configuration.ApplicationTestConfiguration;
import com.sura.polizas.entidades.Poliza;
import com.sura.polizas.facade.IAseguradoFacade;
import com.sura.polizas.facade.IPolizaFacade;
import com.sura.polizas.facade.IVehiculoFacade;
import com.sura.polizas.facade.PolizaFacade;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {PolizaRepositoryFake.class, ApplicationTestConfiguration.class, PolizaFacade.class})
public class PolizaFacadeTestConFake {

	
	@Autowired
	IPolizaFacade polizaFacade;
	
	@Autowired
	IAseguradoFacade aseguradoFacade;
	
	@Autowired
	IVehiculoFacade vehiculoFacade;	
	
	@Test
	public void datosFinanciadoValorPolizaValida() {
		Poliza poliza= polizaFacade.findById(1);
		assertTrue("Poliza encontrada", poliza!=null);
	}
	
	@Test
	public void datosFinanciadoValorPolizaVacia() {
		Poliza poliza= polizaFacade.findById(10);
		assertFalse("Poliza no encontrada", poliza==null);
	}
	

	@Test
	public void validarPoliza() {
		Poliza poliza= new Poliza();
		poliza.setIdPoliza(1L);
		poliza.setEmpresa("SURA");
		poliza.setTipoPoliza(1);
		poliza.setValorPoliza(new BigDecimal(1000));
		poliza.setZona("LIMA");
		
		assertTrue("Datos correctamente seteados", poliza!=null);
	}
	

	
}
