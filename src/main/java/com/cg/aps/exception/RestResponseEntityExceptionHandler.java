package com.cg.aps.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.aps.entity.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handelException(DatabaseException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handelException(DuplicateRecordException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handelException(RecordNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handelException(ApplicationException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
