package com.revature.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.exceptions.IncorrectLoginException;
import com.revature.exceptions.IncorrectRegistrationException;
import com.revature.exceptions.ProtectedRouteException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value= {IncorrectLoginException.class})
	public ResponseEntity<Object> incorrectLogin(IncorrectLoginException e){
		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
	
	@ExceptionHandler(value= {ProtectedRouteException.class})
	public ResponseEntity<Object> protectedRoute(ProtectedRouteException e){
		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
	
	@ExceptionHandler(value= {IncorrectRegistrationException.class})
	public ResponseEntity<Object> incorrectRegistration(IncorrectRegistrationException e){
		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}

	@ExceptionHandler(value= {Throwable.class})
	public ResponseEntity<Object> defaultError(Throwable e){
		System.out.println(e);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
