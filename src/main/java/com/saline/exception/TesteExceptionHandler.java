package com.saline.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TesteExceptionHandler extends ResponseEntityExceptionHandler {
	
  @Override
protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
		HttpStatus status, WebRequest request) {
	// TODO Auto-generated method stub
	return super.handleExceptionInternal(ex, body, headers, status, request);
}
	
	

}
