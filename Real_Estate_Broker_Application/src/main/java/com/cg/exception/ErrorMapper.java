package com.cg.exception;

/*************************************************************************************
 * @author                 Sanjay Das
 * Description             It is a global error mapper class that returns error message for all the exceptions occuring at 
 *                         service level.
 * @version                1.0
 * @since           	   24-03-2021
 *
 ***************************************************************************************/

import java.util.Date;

public class ErrorMapper {
	private String url;
	private String message;
	private Date now;
	
	public ErrorMapper() {
		
	}
	public ErrorMapper(String url, String message, Date now) {
		super();
		this.url = url;
		this.message = message;
		this.now = now;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getNow() {
		return now;
	}
	public void setNow(Date now) {
		this.now = now;
	}
}
