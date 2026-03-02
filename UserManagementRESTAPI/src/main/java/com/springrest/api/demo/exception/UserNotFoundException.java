package com.springrest.api.demo.exception;


public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Long id) {
		super("User with "+id+ " is not found!!!");
	}
}
