package com.inditex.pricing.infrastructure.database.h2.adapter;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.domain.repository.BrandPriceRepositoryPort;
import com.inditex.pricing.infrastructure.database.h2.mapper.PricesEntityMapper;
import com.inditex.pricing.infrastructure.database.h2.repository.PricesJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PricesRepositoryAdapter implements BrandPriceRepositoryPort {
	
	private final PricesJpaRepository pricesJpaRepository;

	@Override
	public Optional<BrandPrice> findBrandPriceByCriteria(LocalDateTime applicationDate, Integer productId,
			Integer brandId) {
		return pricesJpaRepository.findPricesByBrandPriceCriteria(applicationDate, productId,
				brandId)
				.map(PricesEntityMapper::fromEntityToBrandPrice);
	}

}
