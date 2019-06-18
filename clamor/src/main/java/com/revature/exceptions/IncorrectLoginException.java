package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectLoginException extends AbstractApiException {

	public IncorrectLoginException() {
		this.status = HttpStatus.BAD_REQUEST;
		this.message = "your username or password is incorrect";
	}
	
	public IncorrectLoginException(HttpStatus status) {
		super(status);
	}

	public IncorrectLoginException(HttpStatus status, String message) {
		super(status, message);
	}
}
