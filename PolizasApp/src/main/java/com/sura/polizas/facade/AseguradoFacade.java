package com.sura.polizas.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sura.polizas.bean.Asegurado;
import com.sura.polizas.bean.RespuestaValidaBean;

@Component
public class AseguradoFacade implements IAseguradoFacade {

	@Override
	public RespuestaValidaBean valida(Asegurado asegurado) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RespuestaValidaBean> rpta = restTemplate.postForEntity("http://172.16.0.123:6666/api/asegurado/valida", asegurado, RespuestaValidaBean.class);
		return rpta.getBody();
	}

}
