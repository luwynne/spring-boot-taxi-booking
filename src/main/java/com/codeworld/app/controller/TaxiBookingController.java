package com.codeworld.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworld.app.entity.Taxi;
import com.codeworld.app.service.TaxiBookingService;

//requests comming from the api
@RestController
@RequestMapping(value="/api")
public class TaxiBookingController {
	
	@Autowired // this creates a dependency bean for the TaxiBookingService class
	TaxiBookingService taxiBookingService;
	
	// PUBLIC API'S
	
	@GetMapping(value="")
	public List<Taxi> getAllBookings() {
		return taxiBookingService.getAllBookings();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Taxi> getBookingDetailById(@PathVariable("id") int id) {
		return taxiBookingService.getBookingDetailById(id);
	}
	
	
	// PRIVATE API'S
	@PostMapping(value="/")
	public Taxi createBooking(@RequestBody Taxi taxi) {
		return taxiBookingService.createBooking(taxi);
	}
	
	
	@DeleteMapping(value="/{id}")
	public String deleteBookingById(@PathVariable("id") int id) {
		Optional<Taxi> booking = taxiBookingService.getBookingDetailById(id);
		Taxi booking_object = booking.get();
		String name = booking_object.getPassenger_name();
		taxiBookingService.deleteById(id);
		return "The booking from "+name+" has been delete";
	}
	
	@PutMapping(value="/put")
	public Taxi updateBooking(@RequestBody Taxi taxi) {
		return taxiBookingService.updateTaxiBooking(taxi);
		
	}
	
	@PatchMapping(value="/{id}")
	public Taxi updateBooking(@PathVariable("id") int id, @RequestBody Taxi taxi) {
		Optional<Taxi> booking = taxiBookingService.getBookingDetailById(id);
		Taxi booking_object = booking.get();
		
		booking_object.setPassenger_name(taxi.getPassenger_name());
		booking_object.setPassenger_number(taxi.getPassenger_number());
		booking_object.setPassenger_email(taxi.getPassenger_email());
		
		return taxiBookingService.updateTaxiBookingById(booking_object);
		
	}

}
