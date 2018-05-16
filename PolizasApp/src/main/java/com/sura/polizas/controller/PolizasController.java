package com.sura.polizas.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sura.polizas.bean.RespuestaBean;
import com.sura.polizas.bean.RespuestaValidaBean;
import com.sura.polizas.entidades.Poliza;
import com.sura.polizas.facade.IPolizaFacade;

@RestController
@RequestMapping("/api/poliza")
public class PolizasController {

	@Autowired
	IPolizaFacade iPolizaFacade;

	@GetMapping("/{idPoliza}")
	public RespuestaBean getPoliza(@PathVariable(value = "idPoliza") Long id) {

		RespuestaBean respuestaBean = new RespuestaBean();

		Poliza poliza = iPolizaFacade.findById(id);
		if (poliza != null) {
			respuestaBean.setFinanciado(poliza.getFinanciada().equals("S") ? true : false);
			respuestaBean.setValorPoliza(poliza.getValorPoliza());
		}
		else {
			respuestaBean.setFinanciado(false);
			respuestaBean.setValorPoliza(new BigDecimal("0"));
		}
		return respuestaBean;
	}

	// @GetMapping("/polizas")
	// public List<Poliza> getPolizas() {
	//
	// return polizasRepository.findAll();
	// }

	@PostMapping("/valida")
	public RespuestaValidaBean validaPoliza(@RequestParam("idPoliza") String idPoliza,
			@RequestParam("tipoNumeroAsegurado") String tipoNumeroAsegurado, @RequestParam("placa") String placa) {

		RespuestaValidaBean respuestaValidaBean = new RespuestaValidaBean();
		respuestaValidaBean.setAsegurable(true);
		respuestaValidaBean.setMensaje("OK");
		return respuestaValidaBean;

	}
}
