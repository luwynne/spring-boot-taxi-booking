package com.codeworld.app.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.codeworld.app.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@ManyToOne
    @JoinColumn(name ="CustomerId")
	private Customer customer;
	
	@Column(name="is_departed")
	private boolean is_departed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean is_departed() {
		return is_departed;
	}

	public void setIs_depated(boolean is_departed) {
		this.is_departed = is_departed;
	}

	@Override
	public String toString() {
		return "Taxi [id=" + id + ", passenger_name=" + passenger_name + ", passenger_number=" + passenger_number
				+ ", passenger_email=" + passenger_email + ", customer=" + customer + ", is_departed=" + is_departed
				+ "]";
	}

}
