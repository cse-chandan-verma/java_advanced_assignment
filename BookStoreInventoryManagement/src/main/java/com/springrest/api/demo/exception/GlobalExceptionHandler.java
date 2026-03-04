package com.springrest.api.demo.exception;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleBookNotFound(ResourceNotFoundException ex){
		return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Map<String, Object>> handleMissingParam(MissingServletRequestParameterException ex){
		String message = "Required Parameter: "+ex.getParameterName()+"' is missing!!!";
		return buildError(HttpStatus.BAD_REQUEST, message);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handleMissingParam(MethodArgumentTypeMismatchException ex){
		String message = "Parameter "+ ex.getName() +"' has invalid value "+ex.getValue()+".";
		return buildError(HttpStatus.BAD_REQUEST, message);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex){
		return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected Error occurred.");
	}
	
	private ResponseEntity<Map<String, Object>> buildError(HttpStatus status, String message){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now().toString());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", message);
		
		return new ResponseEntity<>(body, status);
	}
}
