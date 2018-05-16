package com.sura.polizas.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.sura.polizas.datos.PolizasRepository;

@Profile("test")
@Configuration
public class ApplicationTestConfiguration {
	
	@Bean
    @Primary
    public PolizasRepository polizasRepository() {
        return Mockito.mock(PolizasRepository.class);
    }

}
