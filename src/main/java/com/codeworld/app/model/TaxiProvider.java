package com.codeworld.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="taxi_providers")
public class TaxiProvider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "providers")
    Set<Taxi> bookings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore
	public Set<Taxi> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Taxi> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "TaxiProvider [id=" + id + ", name=" + name + ", type=" + type + ", bookings=" + bookings + "]";
	}
	

}
