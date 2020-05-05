package com.codeworld.app.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.DAO.TaxiProviderDAO;
import com.codeworld.app.entity.TaxiProvider;

@Service
public class TaxiProviderService {
	
	@Autowired
	TaxiProviderDAO taxiProviderDao;
	
	public TaxiProvider findProviderById(int id) {
		return taxiProviderDao.findById(id);
	}

}
