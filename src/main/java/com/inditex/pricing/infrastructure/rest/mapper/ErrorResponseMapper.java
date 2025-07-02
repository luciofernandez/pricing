package com.inditex.pricing.infrastructure.rest.mapper;

import java.time.OffsetDateTime;

import com.inditex.pricing.model.ErrorResponse;

public class ErrorResponseMapper {
	
    public static ErrorResponse convertToErrorResponse(String error, String message) {
		ErrorResponse response = new ErrorResponse();
		response.setError(error);
		response.setMessage(message);
		response.setTimestamp(OffsetDateTime.now());
    	return response;

    }

}
