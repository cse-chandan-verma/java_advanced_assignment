package com.springrest.api.demo.exception;

public class InvalidFileException extends RuntimeException {
	public InvalidFileException(String message) {
		super(message);
	}
}
