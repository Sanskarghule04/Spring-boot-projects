package com.qsp.employee_springboot.exception;

public class NoDataAvaliableException extends RuntimeException{

private String message;
	
	public NoDataAvaliableException(String message) {
			this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
