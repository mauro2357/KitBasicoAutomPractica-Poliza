package com.sura.polizas.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sura.polizas.bean.Asegurado;
import com.sura.polizas.bean.RespuestaValidaBean;
import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;
import com.sura.polizas.entidades.TipoPoliza;

@Component
public class PolizaFacade implements IPolizaFacade {

	@Autowired
	PolizasRepository polizasRepository;

	public Poliza findById(long id) {
		return polizasRepository.findById(id).orElse(new Poliza());
	}

	public RespuestaValidaBean validaPedido(long id, String tipoDocumento, String numeroDocumento, String placa) {
		Poliza poliza = findById(id);
		if (poliza == null)
			return RespuestaValidaBean.buildNoFinanciado("No existe la poliza con el id " + id);

		RestTemplate restTemplate = new RestTemplate();
		if (poliza.getTipoPoliza() == TipoPoliza.COLECTIVO.codigo) {
			Asegurado asegurado = new Asegurado(tipoDocumento, numeroDocumento, new Long(id).toString());
			ResponseEntity<RespuestaValidaBean> rpta = restTemplate.postForEntity(
					"http://172.16.0.123:6666/api/asegurado/valida", asegurado, RespuestaValidaBean.class);
			RespuestaValidaBean respuesta = rpta.getBody();
			if (!respuesta.isAsegurable())
				return RespuestaValidaBean.buildNoFinanciado("El duenio del vehiculo no es empleado de la empresa");

		} else if (poliza.getTipoPoliza() == TipoPoliza.INDIVIDUAL.codigo) {
			ResponseEntity<String> rpta = restTemplate
					.getForEntity("http://172.16.0.123:8585/api/vehiculo/zona/" + placa, String.class);
			String respuesta = "";
			respuesta = rpta.getBody();
			if (respuesta.equals("") || !respuesta.equals(poliza.getZona()))
				return RespuestaValidaBean.buildNoFinanciado("La zona del vehiculo no aplica para la poliza");

		} else {
			return RespuestaValidaBean.buildNoFinanciado("La poliza es de un tipo no conocido ");

		}

		return RespuestaValidaBean.buildFinanciado();
	}

}
