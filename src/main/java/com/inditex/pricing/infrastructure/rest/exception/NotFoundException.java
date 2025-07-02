package com.inditex.pricing.infrastructure.rest.exception;


public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8671109287770062581L;

	public NotFoundException(String message) {
        super(message);
    }
}	
