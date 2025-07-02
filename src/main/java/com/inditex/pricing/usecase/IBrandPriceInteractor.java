package com.inditex.pricing.usecase;

import java.time.LocalDateTime;

import com.inditex.pricing.domain.model.BrandPrice;

public interface IBrandPriceInteractor {

	BrandPrice findBrandPriceByCriteria(LocalDateTime applicationDate, Integer productId,
			Integer brandId);
	
}
