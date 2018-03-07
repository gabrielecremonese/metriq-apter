package com.solera.global.app.metriq.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	
	@RequestMapping("/")
	String home() {
		return "¡Hello World!!";
	}

}
