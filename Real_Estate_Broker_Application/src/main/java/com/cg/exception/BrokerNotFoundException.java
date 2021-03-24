package com.cg.exception;

@SuppressWarnings("serial")
public class BrokerNotFoundException extends Exception {

	public BrokerNotFoundException() {

	}

	public BrokerNotFoundException(String message) {
		super(message);
	}
}
