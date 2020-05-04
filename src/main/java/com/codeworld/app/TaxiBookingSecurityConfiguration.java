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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		//using jpa
		auth.userDetailsService(userDetailsService);
	}
	
	// AUTHORIZATION
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//using jpa
		http.authorizeRequests()
			.antMatchers("/api/admin").hasRole("ADMIN")
			.antMatchers("/api/admin/{id}").hasRole("ADMIN")
			.antMatchers("/api/admin/put").hasRole("ADMIN")
			.antMatchers("/api/user").hasAnyRole("ADMIN", "USER")
			.antMatchers("/").permitAll()
			.antMatchers("/customer").permitAll()
			.and().formLogin();
	}     
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
