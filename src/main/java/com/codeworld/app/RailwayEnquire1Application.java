package com.codeworld.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;



@SpringBootApplication
@EnableAsync
public class RailwayEnquire1Application {

	public static void main(String[] args) {
		SpringApplication.run(RailwayEnquire1Application.class, args);
	}

}
