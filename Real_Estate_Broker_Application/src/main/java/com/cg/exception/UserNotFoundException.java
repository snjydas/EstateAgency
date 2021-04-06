package com.cg.exception;

/*************************************************************************************
 * @author                 Sanjay Das
 * Description             It is a exception class that handles the exception occuring at 
 *                         service level when a user is not found.
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
