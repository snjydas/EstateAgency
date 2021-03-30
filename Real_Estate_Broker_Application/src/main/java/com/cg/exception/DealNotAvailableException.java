package com.cg.exception;

@SuppressWarnings("serial")
public class DealNotAvailableException extends Exception {

	public DealNotAvailableException() {

	}

	public DealNotAvailableException(String message) {
		super(message);
	}
}
