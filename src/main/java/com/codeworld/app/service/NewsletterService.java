package com.codeworld.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.NewsletterDAO;
import com.codeworld.app.DAO.TaxiBookingDAO;
import com.codeworld.app.entity.Newsletter;

@Service
public class NewsletterService {
	
	@Autowired
	NewsletterDAO newsletterDao;
	
	public boolean createNewsletter(String name, String email) {
		Newsletter newsletter = new Newsletter(name, email);
		newsletterDao.save(newsletter);
		return true;
	}

}
