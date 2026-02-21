package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		BeanFactory factory = SpringApplication.run(DemoAppApplication.class, args);
		Vehicle vehicle = factory.getBean(Vehicle.class);
		vehicle.run();
	}

}
