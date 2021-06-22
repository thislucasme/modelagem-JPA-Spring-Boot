package com.thislucasme.services.exceptions;

public class ObjectNotFoundExceptionAPI extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExceptionAPI(String msg) {
		super(msg);
	}
	public ObjectNotFoundExceptionAPI(String msg, Throwable cause) {
		super(msg, cause);
	}

}
