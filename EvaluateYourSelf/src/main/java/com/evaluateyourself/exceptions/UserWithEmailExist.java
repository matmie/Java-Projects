package com.evaluateyourself.exceptions;

import javax.naming.directory.InvalidAttributesException;

public class UserWithEmailExist extends InvalidAttributesException {

	private static final long serialVersionUID = 1L;
	
    public UserWithEmailExist(String msg){
    	super(msg);
    }
}
