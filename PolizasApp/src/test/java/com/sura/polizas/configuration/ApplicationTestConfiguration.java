package com.sura.polizas.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.facade.AseguradoFacade;
import com.sura.polizas.facade.VehiculoFacade;

@Profile("test")
@Configuration
public class ApplicationTestConfiguration {
	
	@Bean
    @Primary
    public PolizasRepository polizasRepository() {
        return Mockito.mock(PolizasRepository.class);
    }
	
	@Bean
    @Primary
	public VehiculoFacade vehiculoFacade() {
		return Mockito.mock(VehiculoFacade.class);
	}

	@Bean
    @Primary	
	public AseguradoFacade aseguradoFacade() {
		return Mockito.mock(AseguradoFacade.class);
	}

}
