package com.app.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String location;
	private String cuisineType;
	private Boolean available;
	
	public Restaurant() {
	}

	public Restaurant(Long id, String name, String location, String cuisineType, Boolean available) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.cuisineType = cuisineType;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public Boolean getAvailable() {
		return available;
	}
	
	
}
