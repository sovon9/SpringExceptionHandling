package com.RestExceptionHandling.handleExcep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.RestExceptionHandling.handleExcep.exception.StudentErrorResponse;
import com.RestExceptionHandling.handleExcep.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleErrorResponse(StudentNotFoundException exception)
	{
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleErrorResponse(MethodArgumentNotValidException exception)
	{
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		/* returning field error not the error.getMessage cause we want our declared
		*  message to show on the screen
		*/
		errorResponse.setMessage(exception.getFieldError().getDefaultMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
