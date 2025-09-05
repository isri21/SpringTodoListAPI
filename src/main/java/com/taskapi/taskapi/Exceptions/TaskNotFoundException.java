package com.taskapi.taskapi.Exceptions;
public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException(String message) {
		super(message);
	}

	public TaskNotFoundException() {
		super();
	}
}
