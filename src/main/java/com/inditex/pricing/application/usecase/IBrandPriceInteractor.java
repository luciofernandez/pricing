package com.inditex.pricing.application.usecase;

import java.time.LocalDateTime;

import com.inditex.pricing.domain.model.BrandPrice;

public interface IBrandPriceInteractor {

	BrandPrice findBrandPriceByCriteria(LocalDateTime applicationDate, Integer productId,
			Integer brandId);
	
}
