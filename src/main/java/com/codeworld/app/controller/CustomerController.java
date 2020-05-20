package com.codeworld.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;
import com.codeworld.app.event.TaxiBookingEvent;
import com.codeworld.app.service.CustomerService;
import com.codeworld.app.service.TaxiBookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/")
public class CustomerController {
	
	
	@Autowired // this creates a dependency bean for the TaxiBookingService class
	CustomerService customerService;
	
	@GetMapping(value="/customer")
	public ResponseEntity getCustomers() {
		return new ResponseEntity <List>((List) customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping(value="/customer/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") int id) {
		return new ResponseEntity (customerService.getCustomer(id), HttpStatus.OK);
	}
	
	@PostMapping(value="/customer/register")
	public ResponseEntity registerCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity <Customer>(customerService.registerCustomer(customer), HttpStatus.OK);
	}
	
	@PostMapping(value="/customer/{id}")
	public ResponseEntity createCustomerTaxiBooking(@PathVariable("id") int id, @Valid @RequestBody Taxi taxi) {	
		return new ResponseEntity <Customer>(customerService.createCustomerTaxiBooking(id, taxi), HttpStatus.OK);
	}
	
	@GetMapping(value="/customer/{id}/bookings/not_departed")
	public ResponseEntity getCustomerNotDepartedBookings(@PathVariable("id") int id){
		return new ResponseEntity <List>((List) customerService.getCustomerNotDepartedBookings(id), HttpStatus.OK);
		
	}

}
