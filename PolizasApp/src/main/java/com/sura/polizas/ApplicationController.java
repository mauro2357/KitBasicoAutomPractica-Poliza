package com.sura.polizas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {

	 @Autowired
	 ConfigurableApplicationContext applicationContext;
	 
	 @GetMapping("/shutdown")
	 public void shutdown() {		
		 applicationContext.close();
	 }
	
	
}
