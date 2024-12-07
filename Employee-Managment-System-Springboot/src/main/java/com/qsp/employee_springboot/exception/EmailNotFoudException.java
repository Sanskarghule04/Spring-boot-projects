package com.qsp.employee_springboot.exception;

public class EmailNotFoudException extends RuntimeException{

	private String message;
	
	public EmailNotFoudException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}