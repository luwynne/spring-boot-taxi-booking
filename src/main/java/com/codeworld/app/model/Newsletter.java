package com.codeworld.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="newsletter")
public class Newsletter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // AUTO INCREMENT FIELD
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "Please provide a name")
	private String name;
	
	@Column(name="email")
	@NotEmpty(message = "Please provide an email")
	private String email;
	
	public Newsletter(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Newsletter [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

}
