package com.codeworld.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.codeworld.app.entity.Newsletter;
import com.codeworld.app.service.NewsletterService;

@Controller
public class NewsletterController {
	
	@Autowired
	NewsletterService newsletterService;
	
	@RequestMapping(value="/newsletter", method = RequestMethod.POST)
	 public String greetingSubmit(String name, String email, RedirectAttributes redirectAttrs) {
	    if(newsletterService.createNewsletter(name, email)) {
	    	redirectAttrs.addFlashAttribute("message", "Your newsletter has been registered!");
	    }else {
	    	redirectAttrs.addFlashAttribute("message", "Something went wrong!");
	    }
	    
	    return "redirect:/about";
	 }

}
