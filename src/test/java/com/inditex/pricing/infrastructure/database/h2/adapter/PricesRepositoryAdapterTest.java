package com.inditex.pricing.infrastructure.database.h2.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.database.h2.entity.PricesEntity;
import com.inditex.pricing.infrastructure.database.h2.mapper.PricesEntityMapper;
import com.inditex.pricing.infrastructure.database.h2.repository.PricesJpaRepository;

public class PricesRepositoryAdapterTest {

    private PricesJpaRepository pricesJpaRepository;
    private PricesRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        pricesJpaRepository = mock(PricesJpaRepository.class);
        adapter = new PricesRepositoryAdapter(pricesJpaRepository);
    }
	
    @Test
    void shouldReturnBrandPriceWhenEntityFound() {
        // Given
        LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        int productId = 35455;
        int brandId = 1;

        PricesEntity entity = new PricesEntity(1L, brandId, startDate, endDate, 1, productId, 1, new BigDecimal("10.50"), "EUR"); 
        BrandPrice expected = new BrandPrice(brandId, startDate, endDate, 1, productId, 1, new BigDecimal("10.50"), "EUR");

        when(pricesJpaRepository.findPricesByBrandPriceCriteria(appDate, productId, brandId))
                .thenReturn(Optional.of(entity));

        try (MockedStatic<PricesEntityMapper> mapperMock = mockStatic(PricesEntityMapper.class)) {
            mapperMock.when(() -> PricesEntityMapper.fromEntityToBrandPrice(entity))
                    .thenReturn(expected);

            // When
            Optional<BrandPrice> result = adapter.findBrandPriceByCriteria(appDate, productId, brandId);

            // Then
            assertTrue(result.isPresent());
            assertEquals(expected, result.get());
        }
    }
    
    @Test
    void shouldReturnEmptyWhenNoEntityFound() {
        // Given
        LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 21, 0);
        int productId = 35455;
        int brandId = 1;

        when(pricesJpaRepository.findPricesByBrandPriceCriteria(appDate, productId, brandId))
                .thenReturn(Optional.empty());

        // When
        Optional<BrandPrice> result = adapter.findBrandPriceByCriteria(appDate, productId, brandId);

        // Then
        assertTrue(result.isEmpty());
    }
}
