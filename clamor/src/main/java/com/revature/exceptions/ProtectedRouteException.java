package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class ProtectedRouteException extends AbstractApiException {

	public ProtectedRouteException() {
		this.status = HttpStatus.FORBIDDEN;
		this.message = "you must be logged in to complete this action";
	}
	
	public ProtectedRouteException(HttpStatus status) {
		super(status);
	}

	public ProtectedRouteException(HttpStatus status, String message) {
		super(status, message);
	}

}
