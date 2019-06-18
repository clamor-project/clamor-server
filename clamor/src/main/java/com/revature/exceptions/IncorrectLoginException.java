package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectLoginException extends AbstractApiException {

	public IncorrectLoginException(HttpStatus status) {
		super(status);
	}

	public IncorrectLoginException(HttpStatus status, String message) {
		super(status, message);
	}
}
