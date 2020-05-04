package com.codeworld.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.codeworld.app.entity.Taxi;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // AUTO INCREMENT FIELD
	@Column(name="id")
	private int id;
	
	@Column(name="social_number")
	private String social_number;
	
	@OneToMany(mappedBy="customer")
    private Set<Taxi> taxi_bookings;

	public int getId() {
		return id;
	}

	public String getSocial_number() {
		return social_number;
	}

	public void setSocial_number(String social_number) {
		this.social_number = social_number;
	}

	public Set<Taxi> getTaxi_bookings() {
		return taxi_bookings;
	}

	public void setTaxi_bookings(Set<Taxi> taxi_bookings) {
		this.taxi_bookings = taxi_bookings;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", social_number=" + social_number + ", taxi_bookings=" + taxi_bookings + "]";
	}
	
	
}
