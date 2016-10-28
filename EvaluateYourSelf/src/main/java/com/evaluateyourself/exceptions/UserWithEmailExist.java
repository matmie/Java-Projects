package com.evaluateyourself.exceptions;

public class UserWithEmailExist extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public Integer code = 0;
	public UserWithEmailExist(String message){
		super(message);
	}
}
