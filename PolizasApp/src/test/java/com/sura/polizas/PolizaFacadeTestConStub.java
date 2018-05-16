package com.sura.polizas;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sura.polizas.configuration.ApplicationTestConfiguration;
import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;
import com.sura.polizas.facade.IAseguradoFacade;
import com.sura.polizas.facade.IPolizaFacade;
import com.sura.polizas.facade.IVehiculoFacade;
import com.sura.polizas.facade.PolizaFacade;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {ApplicationTestConfiguration.class, PolizaFacade.class})
public class PolizaFacadeTestConStub {
	
	@Autowired
	IPolizaFacade polizaFacade ;

	@Autowired
	PolizasRepository polizasRepository;	
	
	@Autowired
	IAseguradoFacade aseguradoFacade;
	
	@Autowired
	IVehiculoFacade vehiculoFacade;	

	@Test
	public void polizaTipoNoReconocido() {
		Poliza poliza = new Poliza();
		Mockito.when(polizasRepository.findById(1L)).thenReturn(Optional.of(poliza));
		assertEquals("El tipo de la poliza no es reconocida", "La poliza es de un tipo no conocido" , polizaFacade.validaPedido(1L, "tipoSocumento", "numeroDocumento", "placa").getMensaje());
	}	
	

}
