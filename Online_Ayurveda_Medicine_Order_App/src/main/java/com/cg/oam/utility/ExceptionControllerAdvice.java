package com.cg.oam.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oam.exception.InvalidDataException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	Environment environment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception e){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorInfo> invalidDataExceptionHandler(InvalidDataException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());

		
		String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(", "));

		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
