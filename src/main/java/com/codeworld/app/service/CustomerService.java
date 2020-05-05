package com.codeworld.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.CustomerDAO;
import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDao;
	
	@Autowired
	TaxiBookingDAO taxiBookingDao;
	
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
			taxiBookingDao.save(new_taxi);
			return customer;
		}
		
		return null;
	}

	public Customer registerCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	//Todo delete all customers and its bookings

}
