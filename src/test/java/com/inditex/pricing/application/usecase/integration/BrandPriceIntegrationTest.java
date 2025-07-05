package com.inditex.pricing.application.usecase.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.pricing.application.usecase.BrandPriceInteractorImpl;
import com.inditex.pricing.domain.exception.BrandPriceNotFoundException;
import com.inditex.pricing.domain.model.BrandPrice;

@SpringBootTest
public class BrandPriceIntegrationTest {
	
    @Autowired
    private BrandPriceInteractorImpl brandPriceInteractor;

    @Test
    @DisplayName("Debe devolver el precio correcto cuando existen datos válidos")
    void givenValidCriteriaWhenFindThenReturnsPrice() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
        BrandPrice result = brandPriceInteractor.findBrandPriceByCriteria(date, 35455, 1);

        assertNotNull(result);
        assertEquals(1, result.getBrandId());
        assertEquals(35455, result.getProductId());
        assertEquals(new BigDecimal("35.50"), result.getPrice());
    }
    
    @Test
    @DisplayName("Debe lanzar BrandPriceNotFoundException si no hay coincidencias")
    void givenInvalidCriteriaWhenFindThenThrowsException() {
        LocalDateTime date = LocalDateTime.parse("2022-01-01T00:00:00");

        assertThrows(
            BrandPriceNotFoundException.class,
            () -> brandPriceInteractor.findBrandPriceByCriteria(date, 9999, 999)
        );
    }
}
