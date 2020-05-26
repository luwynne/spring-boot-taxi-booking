package com.codeworld.app.DAO;

import org.springframework.data.repository.CrudRepository;

import com.codeworld.app.entity.Customer;
import com.codeworld.app.entity.Newsletter;

public interface NewsletterDAO extends CrudRepository<Newsletter, Integer>{

}
