package com.inditex.pricing.infrastructure.rest.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class PriceFormatterTest {
	
    @Test
    void formatPrice_shouldReturnFormattedStringWithCurrency() {
        // Arrange
        BigDecimal price = new BigDecimal("35.50");
        String currency = "EUR";

        // Act
        String result = PriceFormatter.formatPrice(price, currency);

        // Assert
        assertThat(result).isEqualTo("35.50 EUR");
    }

    @Test
    void formatPrice_shouldWorkWithZero() {
        // Arrange
        BigDecimal price = BigDecimal.ZERO;
        String currency = "USD";

        // Act
        String result = PriceFormatter.formatPrice(price, currency);

        // Assert
        assertThat(result).isEqualTo("0 USD");
    }

}
