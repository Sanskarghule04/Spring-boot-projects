package com.qsp.employee_springboot.exception;

public class PhoneNotFoundException extends RuntimeException{

	private String message;
	
	public PhoneNotFoundException(String message) {
			this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
