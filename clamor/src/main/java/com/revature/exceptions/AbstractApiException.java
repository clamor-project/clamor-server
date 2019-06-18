package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractApiException extends RuntimeException {

	HttpStatus status;
	String message;
	
	public AbstractApiException(HttpStatus status) {
		super();
		this.status = status;
	}
	
	public AbstractApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public AbstractApiException() {
		super();
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
