package com.springcore.demo;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class Car {
	private Engine engine;
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
		System.out.println("Car has been created by Spring");
	}
	
	public void drive() {
		System.out.println("Driving car using " + engine.getEngine());
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Car bean initialized");
	}
	
}
