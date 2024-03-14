package com.details.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(InvalidInputDetailsException.class)
	public ResponseEntity<InvalidInputDetailsException> handleInputException(InvalidInputDetailsException e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);

	}

	

}
