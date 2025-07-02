package com.inditex.pricing.infrastructure.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.pricing.domain.exception.BrandPriceNotFoundException;
import com.inditex.pricing.infrastructure.rest.mapper.ErrorResponseMapper;
import com.inditex.pricing.model.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
		ErrorResponse e1 = new ErrorResponse();
		e1.setError("");
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BrandPriceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(BrandPriceNotFoundException ex) {
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DateFomatException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(DateFomatException ex) {
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(ConstraintViolationException ex) {
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
