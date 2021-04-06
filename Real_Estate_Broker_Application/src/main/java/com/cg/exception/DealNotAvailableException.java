package com.cg.exception;

/*************************************************************************************
 * @author                 SANJAY DAS
 * Description             It is a exception class that handles the exception occuring at 
 *                         service level when a deal is not available.
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

@SuppressWarnings("serial")
public class DealNotAvailableException extends Exception {

	public DealNotAvailableException() {

	}

	public DealNotAvailableException(String message) {
		super(message);
	}
}
