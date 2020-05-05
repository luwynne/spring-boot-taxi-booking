package com.codeworld.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;
import com.codeworld.app.entity.TaxiProvider;

//writing, fetching and other details. Business logic

@Service
public class TaxiBookingService {

	@Autowired
	TaxiBookingDAO taxiBookingDao;
	
	@Autowired 
	TaxiProviderService taxiProviderService;
	
	public Taxi createBooking(Taxi taxi) {
		return taxiBookingDao.save(taxi);
	}

	public Optional<Taxi> getBookingDetailById(int id) {
		return taxiBookingDao.findById(id);
	}

	public List<Taxi> getAllBookings() {
		return (List<Taxi>) taxiBookingDao.findAll();
	}

	public void deleteById(int id) {
		taxiBookingDao.deleteById(id);
	}

	public Taxi updateTaxiBooking(Taxi taxi) {
		return taxiBookingDao.save(taxi);
	}

	public Taxi updateTaxiBookingById(Taxi booking_object) {
		return taxiBookingDao.save(booking_object);
	}

	public List<Taxi> getCustomerNotDepartedBookings(int id) {
		return taxiBookingDao.getCustomerNotDepartedBookings(id);
	}

	public Taxi addProvider(int id, int provider_id) {
		
		Taxi booking = taxiBookingDao.findById(id).get();
		
		if(booking != null) {
			TaxiProvider provider = taxiProviderService.findProviderById(provider_id);
			booking.getProviders().add(provider);
			return taxiBookingDao.save(booking);
		}
		return null;
	}

}
