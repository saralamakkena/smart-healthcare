package com.smarthealthcare.userservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<Map<String,String>> handleIllegalArg(IllegalArgumentException e) {
	    return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
	  }

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex) {
	    Map<String,Object> body = new HashMap<>();
	    body.put("error", "Validation failed");
	    body.put("details", ex.getBindingResult().getFieldErrors().stream()
	        .map(fe -> Map.of("field", fe.getField(), "message", fe.getDefaultMessage())));
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
	  }

}
