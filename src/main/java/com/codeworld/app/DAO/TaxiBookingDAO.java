package com.codeworld.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.entity.Taxi;

// class dedicated to database sections

@Repository
public interface TaxiBookingDAO extends CrudRepository<Taxi, Integer>{
	
	@Query(value = "SELECT * FROM taxi_booking where customer_id = :id AND is_departed = false", nativeQuery = true)
	 List<Taxi> getCustomerNotDepartedBookings(int id);

}
