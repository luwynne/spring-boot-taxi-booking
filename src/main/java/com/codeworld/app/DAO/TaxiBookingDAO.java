package com.codeworld.app.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.entity.Taxi;

// class dedicated to database sections

@Repository
public interface TaxiBookingDAO extends CrudRepository<Taxi, Integer>{
	
	

}
