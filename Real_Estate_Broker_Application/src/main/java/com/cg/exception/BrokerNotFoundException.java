package com.cg.exception;


/*************************************************************************************
 * @author                 SANJAY DAS
 * Description             It is a exception class that handles the exception occurring at 
 *                         service level when a broker is not found.
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

@SuppressWarnings("serial")
public class BrokerNotFoundException extends Exception {

	public BrokerNotFoundException() {

	}

	public BrokerNotFoundException(String message) {
		super(message);
	}
}
