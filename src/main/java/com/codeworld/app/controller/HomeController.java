package com.codeworld.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Welcome to our application !!");
        return "index";
    }
	
	@RequestMapping("/about")
    public String next(Map<String, Object> model) {
        model.put("message", "This is the about page !!");
        return "about";
    }

}
