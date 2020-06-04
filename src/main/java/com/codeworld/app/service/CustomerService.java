package com.codeworld.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.CustomerDAO;
import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;
import com.codeworld.app.event.TaxiBookingEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	private final ApplicationEventPublisher publisher;
	
	@Autowired
	CustomerDAO customerDao;
	
	@Autowired
	TaxiBookingService taxiBookingService;
	
	@Autowired
	public CustomerService(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public List<Customer> getAllCustomers(){
		return (List<Customer>) customerDao.findAll();
	}
	
	public Optional<Customer> getCustomer(int id) {
		return customerDao.findById(id);
	}
	
	public Customer createCustomer(Customer customer) {
		return customerDao.save(customer);
		
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	public Customer createCustomerTaxiBooking(int id, Taxi taxi) {
		
		Customer customer = customerDao.findById(id).get();
		
		if(customer != null) {
			Taxi new_taxi = new Taxi();
			new_taxi.setPassenger_email(taxi.getPassenger_email());
			new_taxi.setPassenger_name(taxi.getPassenger_name());
			new_taxi.setPassenger_number(taxi.getPassenger_number());
			new_taxi.setCustomer(customer);
			new_taxi.setIs_depated(false);
			taxiBookingService.createBooking(new_taxi);
			
			// creating an event out of the new customerBooking
			TaxiBookingEvent event  = new TaxiBookingEvent(this, customer, new_taxi);
			publisher.publishEvent(event);
			
			return customer;
		}
		
		return null;
	}
	
	// Firing event when some Booking is created
	@EventListener
	public void onCreateCustomerTaxiBooking(TaxiBookingEvent event) {
		// Sending email function
		System.out.println("Sending email to customer...");
		
	}

	public Customer registerCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	
	public List<Taxi> getCustomerNotDepartedBookings(int id) {
		return taxiBookingService.getCustomerNotDepartedBookings(id);
	}
	
	

}
