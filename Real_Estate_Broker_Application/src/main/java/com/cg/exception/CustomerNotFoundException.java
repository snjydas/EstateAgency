package com.cg.exception;

/*************************************************************************************
 * @author                 Sanjay Das
 * Description             It is a exception class that handles the exception occuring at 
 *                         service level when a customer is not found.
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
