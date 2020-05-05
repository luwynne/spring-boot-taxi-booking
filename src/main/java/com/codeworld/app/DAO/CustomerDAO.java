package com.codeworld.app.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Taxi;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{

	 void save(Optional<Customer> customer);

}
