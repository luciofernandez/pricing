package com.inditex.pricing.infrastructure.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.rest.formatter.PriceFormatter;
import com.inditex.pricing.infrastructure.rest.util.DateUtils;
import com.inditex.pricing.model.PriceResponse;

public class PriceResponseMapperTest {

    @Test
    void fromBrandPriceToResponse_shouldMapAllFieldsCorrectly() {
        // Arrange
        BrandPrice brandPrice = new BrandPrice(
            1, // brandId
            LocalDateTime.of(2023, 7, 1, 10, 0, 0), // startDate
            LocalDateTime.of(2023, 7, 31, 23, 59, 59), // endDate
            100, // priceList
            35455, // productId
            1, // priority
            new BigDecimal("99.99"), // price
            "EUR" // currency
        );

        PriceResponse response = PriceResponseMapper.fromBrandPriceToResponse(brandPrice);

        assertThat(response.getBrandId()).isEqualTo(brandPrice.getBrandId());
        assertThat(response.getProductId()).isEqualTo(brandPrice.getProductId());
        assertThat(response.getPriceList()).isEqualTo(brandPrice.getPriceList());

        // fechas formateadas
        String expectedStartDate = brandPrice.getStartDate().format(DateUtils.FORMATTER);
        String expectedEndDate = brandPrice.getEndDate().format(DateUtils.FORMATTER);
        assertThat(response.getStartDate()).isEqualTo(expectedStartDate);
        assertThat(response.getEndDate()).isEqualTo(expectedEndDate);

        // precio formateado
        String expectedPrice = PriceFormatter.formatPrice(brandPrice.getPrice(), brandPrice.getCurrency());
        assertThat(response.getPrice()).isEqualTo(expectedPrice);
    }
}