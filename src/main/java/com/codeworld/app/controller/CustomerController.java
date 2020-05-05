package com.codeworld.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;
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
	
	@GetMapping(value="/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") int id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping(value="/customer/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
		
	}
	
	@PostMapping(value="/customer/{id}")
	public Customer createCustomerTaxiBooking(@PathVariable("id") int id, @RequestBody Taxi taxi) {
		return customerService.createCustomerTaxiBooking(id, taxi);
		
	}
	
	@GetMapping(value="/customer/{id}/bookings/not_departed")
	public List<Taxi> getCustomerNotDepartedBookings(@PathVariable("id") int id){
		return customerService.getCustomerNotDepartedBookings(id);
		
	}

}
