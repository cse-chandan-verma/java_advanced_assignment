package com.app.order.dto;


public class RestaurantDto {
	private Long id;
	private String name;
	private String location;
	private String cuisineType;
	private Boolean available;

	
	public RestaurantDto() {
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	
}
