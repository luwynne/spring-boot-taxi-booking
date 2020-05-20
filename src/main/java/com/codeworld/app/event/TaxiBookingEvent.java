package com.codeworld.app.event;

import org.springframework.context.ApplicationEvent;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;

public class TaxiBookingEvent extends ApplicationEvent{

	private Customer customer;

	public TaxiBookingEvent(Object source, Customer customer) {
		super(source);
		this.customer = customer;
	}
	
	public Customer getMessage() {
        return customer;
    }

}
