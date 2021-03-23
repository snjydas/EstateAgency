package com.cg.exception;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String msg) {
		super(msg);
	}

}