package com.codeworld.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.entity.Taxi;

//writing, fetching and other details. Business logic

@Service
public class TaxiBookingService {

	@Autowired
	TaxiBookingDAO taxiBookingDao;
	
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

}
