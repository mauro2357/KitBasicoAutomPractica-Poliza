package com.sura.polizas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sura.polizas.bean.RespuestaBean;

@RestController
@RequestMapping("/api/poliza")
public class PolizasController {

	
	
	
	 @GetMapping("/{idPoliza}")
	 public RespuestaBean getPoliza(@PathVariable(value = "idPoliza") Long id) {
		 
		 RespuestaBean respuestaBean = new RespuestaBean();
		 respuestaBean.setFinanciado(true);
		 respuestaBean.setValorPoliza(1000L);
	     return respuestaBean;
	 }
}
