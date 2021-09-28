package br.com.vivo.desafio.exceptions;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {
		
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, Object> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach(error -> {
	        String errorMessage = error.getDefaultMessage();
	        errors.put("status_code", HttpStatus.BAD_REQUEST.value());
	        errors.put("message", errorMessage);
	        
	    });
	    return errors;
	}
}
