package com.sura.polizas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sura.polizas.bean.RespuestaBean;
import com.sura.polizas.bean.RespuestaValidaBean;
import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;

@RestController
@RequestMapping("/api/poliza")
public class PolizasController {

	 @Autowired
	 PolizasRepository polizasRepository;
	
	
	 @GetMapping("/{idPoliza}")
	 public RespuestaBean getPoliza(@PathVariable(value = "idPoliza") Long id) {
		 
		 RespuestaBean respuestaBean = new RespuestaBean();
		 respuestaBean.setFinanciado(true);
		 respuestaBean.setValorPoliza(1000L);
	     return respuestaBean;
	 }
	 
	 @GetMapping("/polizas")
	 public List<Poliza> getPolizas() {
		 
		return polizasRepository.findAll();
	 }
	 
	 
	 @PostMapping("/valida")
	 public RespuestaValidaBean validaPoliza(
			 	@RequestParam("idPoliza") String idPoliza,
	    		@RequestParam("tipoNumeroAsegurado") String tipoNumeroAsegurado,
	    		@RequestParam("placa") String placa) {
		 
		 
		 
		 RespuestaValidaBean respuestaValidaBean = new RespuestaValidaBean();
		 respuestaValidaBean.setAsegurable(true);
		 respuestaValidaBean.setMensaje("OK");
	     return respuestaValidaBean;

	 }
}
