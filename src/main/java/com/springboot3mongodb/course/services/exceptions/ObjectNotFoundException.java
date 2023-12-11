package com.springboot3mongodb.course.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String id) {
		super("Couldn't find object with id " + id);
	}
}
