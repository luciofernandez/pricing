package com.inditex.pricing.domain.exception;

public class BrandPriceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 6542681320722798004L;

	public BrandPriceNotFoundException(String message) {
        super(message);
    }
    
}