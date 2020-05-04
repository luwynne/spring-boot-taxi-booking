package com.codeworld.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.CustomerDAO;
import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDao;
	
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
	
	//Todo delete all customers and its bookings

}
