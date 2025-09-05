package com.taskapi.taskapi.Exceptions;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleTaskNotFound(TaskNotFoundException e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "Task Not Found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errorResponse = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(n -> errorResponse.put(n.getField(), n.getDefaultMessage()));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "There is a syntax error in the JSON body sent");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
