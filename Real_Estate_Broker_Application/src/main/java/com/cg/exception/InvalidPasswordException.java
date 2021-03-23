package com.cg.exception;

@SuppressWarnings("serial")
public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String msg) {
		super(msg);
	}
}