package com.solera.global.app.metriq.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.global.app.metriq.mongo.entity.Application;
import com.solera.global.app.metriq.mongo.repository.ApplicationRepository;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@RequestMapping("/add-application")
	public String addApplication() {
		
		String result = null;
		String name = String.valueOf(System.currentTimeMillis());
		
		applicationRepository.save(new Application(name, "sn1"));
		
		result = printAll();
		
		
		return result;
	}

	private String printAll() {

		StringBuilder resultBuilder = new StringBuilder();
		
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Application application : applicationRepository.findAll()) {
			System.out.println(application);
			resultBuilder.append(application.getName() + "\n");
		}
		System.out.println();
		
		return resultBuilder.toString();
		
	}

}
