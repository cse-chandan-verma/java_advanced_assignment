package com.springrest.api.demo.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InspectionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            InspectionNotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
            new ErrorResponse(LocalDateTime.now(), 404,
                ex.getMessage(), request.getRequestURI()),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidFileException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFile(
            InvalidFileException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
            new ErrorResponse(LocalDateTime.now(), 400,
                ex.getMessage(), request.getRequestURI()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxSize(
            MaxUploadSizeExceededException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
            new ErrorResponse(LocalDateTime.now(), 413,
                "File size exceeds maximum limit of 5MB",
                request.getRequestURI()),
            HttpStatus.valueOf(413)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        String messages = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .collect(Collectors.joining(", "));
        return new ResponseEntity<>(
            new ErrorResponse(LocalDateTime.now(), 400,
                messages, request.getRequestURI()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex, HttpServletRequest request) {
        return new ResponseEntity<>(
            new ErrorResponse(LocalDateTime.now(), 500,
                ex.getMessage(), request.getRequestURI()),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
