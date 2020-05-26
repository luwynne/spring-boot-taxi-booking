package com.codeworld.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeworld.app.entity.Newsletter;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String home(Map<String, Object> model) {
        return "index";
    }
	
	@GetMapping("/about")
    public String next(Map<String, Object> model) {
        return "about";
    }

}
