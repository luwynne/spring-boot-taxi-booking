package com.codeworld.app.models;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeworld.app.DAO.CustomerDAO;
import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;

public class TaxiBookingDetails {
	
	private int id;
	private String passenger_name;
	private int passenger_number;
	private String passenger_email;
	private int customer_id;
	private Optional<Customer> customer;
	CustomerDAO customerDao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassenger_name() {
		return passenger_name;
	}
	
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	
	public int getPassenger_number() {
		return passenger_number;
	}
	
	public void setPassenger_number(int passenger_number) {
		this.passenger_number = passenger_number;
	}
	
	public String getPassenger_email() {
		return passenger_email;
	}
	
	public void setPassenger_email(String passenger_email) {
		this.passenger_email = passenger_email;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public Optional<Customer> getCustomer() {
		return customerDao.findById(customer_id);
	}
	
	public void setCustomer(Optional<Customer> customer) {
		this.customer = customer;
	}
	
	public CustomerDAO getCustomerDao() {
		return customerDao;
	}
	
	public void setCustomerDao(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	
}
