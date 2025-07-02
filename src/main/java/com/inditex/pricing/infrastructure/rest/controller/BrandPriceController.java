package com.inditex.pricing.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.pricing.api.PricesApi;
import com.inditex.pricing.infrastructure.rest.mapper.PriceResponseMapper;
import com.inditex.pricing.infrastructure.rest.util.DateUtils;
import com.inditex.pricing.model.PriceResponse;
import com.inditex.pricing.usecase.IBrandPriceInteractor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/inditex/prices")
@RestController
public class BrandPriceController implements PricesApi{
	
	private final IBrandPriceInteractor brandPriceInteractor;

	
	@Override
	@GetMapping
	public ResponseEntity<PriceResponse> pricesGet(String applicationDate,  Integer productId,
		 Integer brandId) {
		PriceResponse response = PriceResponseMapper.fromBrandPriceToResponse(brandPriceInteractor.findBrandPriceByCriteria(DateUtils.getFormatDate(applicationDate), productId, brandId));
		return ResponseEntity.ok(response);
	}
	


}
