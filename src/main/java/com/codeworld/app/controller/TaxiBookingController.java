package com.codeworld.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	@GetMapping(value="/user")
	public List<Taxi> getAllBookings() {
		return taxiBookingService.getAllBookings();
	}
	
	@GetMapping(value="/admin/{id}")
	public Optional<Taxi> getBookingDetailById(@PathVariable("id") int id) {
		return taxiBookingService.getBookingDetailById(id);
	}
	
	
	@DeleteMapping(value="/admin/{id}")
	public String deleteBookingById(@PathVariable("id") int id) {
		Optional<Taxi> booking = taxiBookingService.getBookingDetailById(id);
		Taxi booking_object = booking.get();
		String name = booking_object.getPassenger_name();
		taxiBookingService.deleteById(id);
		return "The booking from "+name+" has been delete";
	}
	
	@PutMapping(value="/admin/put")
	public Taxi updateBooking(@Valid @RequestBody Taxi taxi) {
		return taxiBookingService.updateTaxiBooking(taxi);
		
	}
	
	@PatchMapping(value="/admin/{id}")
	public Taxi updateBooking(@Valid @PathVariable("id") int id, @RequestBody Taxi taxi) {
		Optional<Taxi> booking = taxiBookingService.getBookingDetailById(id);
		Taxi booking_object = booking.get();
		
		booking_object.setPassenger_name(taxi.getPassenger_name());
		booking_object.setPassenger_number(taxi.getPassenger_number());
		booking_object.setPassenger_email(taxi.getPassenger_email());
		
		return taxiBookingService.updateTaxiBookingById(booking_object);
		
	}
	
	@PostMapping(value="/admin/{id}/provider/add/{provider_id}")
	public Taxi addProvider(@PathVariable("id") int id, @PathVariable("provider_id") int provider_id) {
		return taxiBookingService.addProvider(id, provider_id);
	}

}
