package com.codeworld.app.event;

import org.springframework.context.ApplicationEvent;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;

public class TaxiBookingEvent extends ApplicationEvent{

	private Customer customer;
	private Taxi taxi;

	public TaxiBookingEvent(Object source, Customer customer, Taxi taxi) {
		super(source);
		this.customer = customer;
		this.taxi = taxi;
	}
	
	public Customer getCustomer() {
        return customer;
    }
	
	public String getMessage() {
		return "A new nooking has been made "+this.customer.getDetails().getName()
				+"<br>ID: "+this.taxi.getId()
				+"<br>Customer number: "+this.taxi.getPassenger_number();
	}

}
