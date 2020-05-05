package com.codeworld.app.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.entity.Taxi;
import com.codeworld.app.entity.TaxiProvider;

@Repository
public interface TaxiProviderDAO  extends CrudRepository<TaxiProvider, Integer>{
	
	TaxiProvider findById(int id);

}
