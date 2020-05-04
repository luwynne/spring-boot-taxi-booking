package com.codeworld.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.service.CustomerService;
import com.codeworld.app.service.TaxiBookingService;

@RestController
@RequestMapping(value="/")
public class CustomerController {
	
	@Autowired // this creates a dependency bean for the TaxiBookingService class
	CustomerService customerService;
	
	@GetMapping(value="/customer")
	public List<Customer> getCustomers() {
		return customerService.getAllCustomers();
	}

}
