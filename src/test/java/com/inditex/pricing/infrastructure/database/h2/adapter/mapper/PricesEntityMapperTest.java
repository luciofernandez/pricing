package com.inditex.pricing.infrastructure.database.h2.adapter.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.database.h2.entity.PricesEntity;
import com.inditex.pricing.infrastructure.database.h2.mapper.PricesEntityMapper;

public class PricesEntityMapperTest {

    @Test
    void fromEntityToBrandPrice_shouldMapCorrectly() {
        // Given
        PricesEntity entity = new PricesEntity(1L, 1, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59), 2, 35455, 1, new BigDecimal("35.50"), "EUR");

        // When
        BrandPrice result = PricesEntityMapper.fromEntityToBrandPrice(entity);

        // Then
        assertNotNull(result);
        assertEquals(entity.getBrandId(), result.getBrandId());
        assertEquals(entity.getStartDate(), result.getStartDate());
        assertEquals(entity.getEndDate(), result.getEndDate());
        assertEquals(entity.getPriceList(), result.getPriceList());
        assertEquals(entity.getProductId(), result.getProductId());
        assertEquals(entity.getPriority(), result.getPriority());
        assertEquals(entity.getPrice(), result.getPrice());
        assertEquals(entity.getCurrency(), result.getCurrency());
    }
	
}
