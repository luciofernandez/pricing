package com.inditex.pricing.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.inditex.pricing.domain.exception.BrandPriceNotFoundException;
import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.domain.repository.BrandPriceRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BrandPriceInteractorImpl implements IBrandPriceInteractor{

	private final BrandPriceRepositoryPort brandPriceRepositoryPort;
	
	@Override
	public BrandPrice findBrandPriceByCriteria(LocalDateTime applicationDate, Integer productId,
			Integer brandId) {
		return brandPriceRepositoryPort.findBrandPriceByCriteria(applicationDate, productId,
				brandId).orElseThrow(() -> new BrandPriceNotFoundException(
						String.format("No price found for the given criteria brandId: %s productId: %s applicationDate: %s", brandId, productId, applicationDate)));
	}

	
	
}
