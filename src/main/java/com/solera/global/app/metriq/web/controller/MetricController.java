package com.solera.global.app.metriq.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solera.global.app.metriq.mongo.repository.ApplicationRepository;

@Controller
@RequestMapping("/metric")
public class MetricController {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@RequestMapping("/list")
	public String listMetrics(Model model) {
        
		model.addAttribute("appList", applicationRepository.findAll());
		model.addAttribute("name", "arturo");
		
        return "metric-list";
    }

}
