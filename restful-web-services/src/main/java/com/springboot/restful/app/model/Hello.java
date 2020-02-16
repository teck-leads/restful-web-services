package com.springboot.restful.app.model;

public class Hello {
	private String message;
	

	public Hello(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Hello [message=" + message + "]";
	}
	
 
}
