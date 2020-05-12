package com.codeworld.app.entity;

import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotEmpty(message = "Please provide a passenger name")
	private String passenger_name;
	
	@Column(name="passenger_number")
	@NotNull
	private Integer passenger_number;
	
	@Column(name="passenger_email")
	@NotEmpty(message = "Please provide a passenger email")
	private String passenger_email;
	
	@ManyToOne
    @JoinColumn(name ="CustomerId")
	private Customer customer;
	
	@Column(name="is_departed")
	@NotNull
	private boolean is_departed;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			  name = "booking_provider", 
			  joinColumns = @JoinColumn(name = "taxi_booking_id"), 
			  inverseJoinColumns = @JoinColumn(name = "provider_id"))
    Set<TaxiProvider> providers;

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

	public Set<TaxiProvider> getProviders() {
		return providers;
	}

	public void setProviders(Set<TaxiProvider> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Taxi [id=" + id + ", passenger_name=" + passenger_name + ", passenger_number=" + passenger_number
				+ ", passenger_email=" + passenger_email + ", customer=" + customer + ", is_departed=" + is_departed
				+ ", providers=" + providers + "]";
	}


}
