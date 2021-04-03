package com.cg.exception;
/*************************************************************************************
 * @author                 Sidda Reddy Partha Saradhi
 * Description             It is a exception class that handles the exception occurs at 
 *                         service level
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

public class PasswordNotMatchException extends Exception {


	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException(String msg) {
		super(msg);
	}

}
