package com.codeworld.app.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.codeworld.app.event.TaxiBookingEvent;
import com.codeworld.app.miscelaneous.EmailService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaxiBookingListener implements ApplicationListener<TaxiBookingEvent>{
	
	@Autowired
    private EmailService emailService;
	
	@Override
    public void onApplicationEvent(TaxiBookingEvent event) {
        System.out.println("Received spring custom event - " + event.getClass().getName());
        emailService.sendMail(event.getCustomer().getDetails().getEmail(), event.getClass().getSimpleName(), event.getMessage());
    }

}
