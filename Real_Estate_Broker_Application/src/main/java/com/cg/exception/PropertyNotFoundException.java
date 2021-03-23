package com.cg.exception;

@SuppressWarnings("serial")
public class PropertyNotFoundException extends Exception {

	public PropertyNotFoundException() {

	}

	public PropertyNotFoundException(String message) {
		super(message);
	}
}
