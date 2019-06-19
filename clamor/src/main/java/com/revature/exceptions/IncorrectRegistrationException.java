package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectRegistrationException extends AbstractApiException {
	
	public IncorrectRegistrationException() {
		super();
		this.status = HttpStatus.BAD_REQUEST;
		this.message = "A user by this username or email already exists";
	}
	
	public IncorrectRegistrationException(HttpStatus status) {
		super(status);
		this.status = status;
		this.message = "A user by this username or email already exists";
	}

	public IncorrectRegistrationException(HttpStatus status, String message) {
		super(status, message);
	}

}
