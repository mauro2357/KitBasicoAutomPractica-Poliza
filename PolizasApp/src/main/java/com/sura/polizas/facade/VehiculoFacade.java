package com.sura.polizas.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VehiculoFacade implements IVehiculoFacade {

	@Override
	public String obtenerZona(String placa) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> rpta = restTemplate.getForEntity("http://172.16.0.123:8585/api/vehiculo/zona/"+placa, String.class);
		return rpta.getBody();
	}

}
