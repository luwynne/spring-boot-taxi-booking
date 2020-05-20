package com.codeworld.app.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.codeworld.app.event.TaxiBookingEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaxiBookingListener implements ApplicationListener<TaxiBookingEvent>{
	
	@Override
    public void onApplicationEvent(TaxiBookingEvent event) {
        System.out.println("Received spring custom event - " + event.getClass().getName());
    }

}
