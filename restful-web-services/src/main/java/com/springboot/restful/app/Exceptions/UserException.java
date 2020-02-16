package com.springboot.restful.app.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestController
@ControllerAdvice
public class UserException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) throws Exception {
		String message = new StringBuilder().append(ex.getMessage()).append(", ").append("User not found").toString();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message, request.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	
	}
	@ExceptionHandler(NumberFormatException.class)
	public  ResponseEntity<Object> handleAllException(NumberFormatException ex, WebRequest request) throws Exception {
		String message = new StringBuilder().append(ex.getMessage()).append(", ").append("Please enter user id").toString();
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message, request.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	
	}

}
