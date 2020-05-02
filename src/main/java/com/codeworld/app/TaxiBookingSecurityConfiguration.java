package com.codeworld.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class TaxiBookingSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	// AUTHENTICATION
	@Autowired
	//DataSource dataSource;
	UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//using spring security default with user and authority tables (as per default documentation)
		//auth.jdbcAuthentication()
			//.dataSource(dataSource);
		
		//using jpa
		auth.userDetailsService(userDetailsService);
	}
	
	// AUTHORIZATION
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//using spring security default with user and authority tables (as per default documentation)
		//http.authorizeRequests()
		//	.antMatchers("/admin").hasRole("ADMIN")
		//	.antMatchers("/user").hasAnyRole("ADMIN", "USER")
		//	.antMatchers("/").permitAll()
		//	.and().formLogin();
		
		//using jpa
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMIN", "USER")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}