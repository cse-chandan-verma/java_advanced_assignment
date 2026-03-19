package com.app.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.restaurant.model.Restaurant;
import com.app.restaurant.repository.RestaurantRepository;


@Service
public class RestaurantService {
	
	private RestaurantRepository repository;
	
	
	public RestaurantService(RestaurantRepository repository) {
		this.repository = repository;
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		return repository.save(restaurant);
	}
	
	public List<Restaurant> getAllRestaurants(){
		return repository.findAll();
	}
	
	public Restaurant getRestaurantById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found with id: "+id));
	}
	
	
}
