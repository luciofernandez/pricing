package com.inditex.pricing.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inditex.pricing.domain.exception.BrandPriceNotFoundException;
import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.domain.repository.BrandPriceRepositoryPort;

public class BrandPriceInteractorImplTest {

    BrandPriceRepositoryPort brandPriceRepositoryPort;
    BrandPriceInteractorImpl brandPriceInteractor;

    @BeforeEach
    void setUp() {
    	brandPriceRepositoryPort = mock(BrandPriceRepositoryPort.class);
        brandPriceInteractor = new BrandPriceInteractorImpl(brandPriceRepositoryPort);

    }
    
    @Test
    void shouldReturnBrandPriceWhenExists() {
        // Given
        LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;
        BrandPrice expected = new BrandPrice(); 

        when(brandPriceRepositoryPort.findBrandPriceByCriteria(appDate, productId, brandId))
                .thenReturn(Optional.of(expected));

        // When
        BrandPrice result = brandPriceInteractor.findBrandPriceByCriteria(appDate, productId, brandId);

        // Then
        assertEquals(expected, result);
        verify(brandPriceRepositoryPort).findBrandPriceByCriteria(appDate, productId, brandId);
    }

    @Test
    void shouldThrowExceptionWhenBrandPriceNotFound() {
        // Given
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;

        when(brandPriceRepositoryPort.findBrandPriceByCriteria(date, productId, brandId))
                .thenReturn(Optional.empty());

        // When & Then
        BrandPriceNotFoundException ex = assertThrows(
                BrandPriceNotFoundException.class,
                () -> brandPriceInteractor.findBrandPriceByCriteria(date, productId, brandId)
        );

        assertTrue(ex.getMessage().contains("No price found for the given criteria"));
    }
	
}
