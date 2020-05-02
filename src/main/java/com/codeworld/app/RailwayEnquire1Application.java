package com.codeworld.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.codeworld.app.DAO.UserRepositoryDAO;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepositoryDAO.class)
public class RailwayEnquire1Application {

	public static void main(String[] args) {
		SpringApplication.run(RailwayEnquire1Application.class, args);
	}

}
