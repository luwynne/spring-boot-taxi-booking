package com.codeworld.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//entity model

@Entity
@Table(name="taxi_booking")
public class Taxi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // AUTO INCREMENT FIELD
	@Column(name="id")
	private Integer id;
	
	@Column(name="passenger_name")
	private String passenger_name;
	
	@Column(name="passenger_number")
	private Integer passenger_number;
	
	@Column(name="passenger_email")
	private String passenger_email;

	//getters and setters
	public Integer getId() {
		return id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public Integer getPassenger_number() {
		return passenger_number;
	}

	public void setPassenger_number(Integer passenger_number) {
		this.passenger_number = passenger_number;
	}

	public String getPassenger_email() {
		return passenger_email;
	}

	public void setPassenger_email(String passenger_email) {
		this.passenger_email = passenger_email;
	}

	@Override
	public String toString() {
		return "Taxi [id=" + id + ", passenger_name=" + passenger_name + ", passenger_number=" + passenger_number
				+ ", passenger_email=" + passenger_email + "]";
	}
	
	
	
	

}
