package com.sura.polizas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polizas")
public class PolizasController {

	 @GetMapping("/validar")
	 public String validar() {
	     return "OK";
	 }
}
