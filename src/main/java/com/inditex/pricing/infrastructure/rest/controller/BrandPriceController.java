package com.inditex.pricing.infrastructure.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.pricing.api.PricesApi;
import com.inditex.pricing.infrastructure.rest.mapper.PriceResponseMapper;
import com.inditex.pricing.infrastructure.rest.util.DateUtils;
import com.inditex.pricing.model.PriceResponse;
import com.inditex.pricing.usecase.IBrandPriceInteractor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/inditex/prices")
@RestController
public class BrandPriceController implements PricesApi{
	
	
    private static final Logger logger = LoggerFactory.getLogger(BrandPriceController.class);

	private final IBrandPriceInteractor brandPriceInteractor;
	
    @Operation(summary = "Get prices")
    @ApiResponse(responseCode = "200", description = "Succesfull")
	@Override
	@GetMapping
	public ResponseEntity<PriceResponse> pricesGet(String applicationDate,  Integer productId,
		 Integer brandId) {
    	
    	logger.debug(String.format("Consultando la api con los siguientes param: applicationDate %s, productId %s, brandId %s ", applicationDate, productId, brandId));
		
    	PriceResponse response = PriceResponseMapper.fromBrandPriceToResponse(brandPriceInteractor.findBrandPriceByCriteria(DateUtils.getFormatDate(applicationDate), productId, brandId));
		
    	return ResponseEntity.ok(response);
	}
	


}
