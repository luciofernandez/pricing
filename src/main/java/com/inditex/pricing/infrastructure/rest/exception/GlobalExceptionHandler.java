package com.inditex.pricing.infrastructure.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.inditex.pricing.domain.exception.BrandPriceNotFoundException;
import com.inditex.pricing.infrastructure.rest.controller.BrandPriceController;
import com.inditex.pricing.infrastructure.rest.mapper.ErrorResponseMapper;
import com.inditex.pricing.model.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BrandPriceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleValidationNotFoundStatus(BrandPriceNotFoundException ex) {
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({
		DateFomatException.class, MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class, 
		ConstraintViolationException.class
	})
	public ResponseEntity<ErrorResponse> handleValidationBadRequestStatus(Exception ex) {
		ErrorResponse error = ErrorResponseMapper.convertToErrorResponse(
				String.format("%s %s", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name()), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
