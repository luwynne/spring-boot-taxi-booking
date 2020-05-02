package com.codeworld.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this application will be called by the main controller
@RestController
public class EnquireRestController {
	
	// this tell the SpringBoot app whenever i get this request, just send this request to this mapping
	@RequestMapping("/home") 
	public String HomePageEnquire() {
		return "Welcome to RailEnquire";
	}

}
