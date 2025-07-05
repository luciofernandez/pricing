package com.inditex.pricing.domain.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.inditex.pricing.domain.model.BrandPrice;

@Repository
public interface BrandPriceRepositoryPort {

	Optional<BrandPrice> findBrandPriceByCriteria(LocalDateTime applicationDate, Integer productId,
			Integer brandId);

}
