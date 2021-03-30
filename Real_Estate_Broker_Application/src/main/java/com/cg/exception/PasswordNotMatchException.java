package com.cg.exception;
/**************************************************************************
 * @author                 P.saiteja reddy
 * Description             It is a exception class that handles the exception occurs at 
 *                         service level
 * version                 1.0
 * created date            24-03-2021
 *
 ************************************************************************************/

public class PasswordNotMatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException(String msg) {
		super(msg);
	}

}
