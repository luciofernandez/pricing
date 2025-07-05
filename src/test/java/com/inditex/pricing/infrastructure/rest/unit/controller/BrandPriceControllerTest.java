package com.inditex.pricing.infrastructure.rest.unit.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.pricing.application.usecase.IBrandPriceInteractor;
import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.rest.controller.BrandPriceController;
import com.inditex.pricing.model.PriceResponse;

class BrandPriceControllerTest {

    @Mock
    private IBrandPriceInteractor brandPriceInteractor;

    @InjectMocks
    private BrandPriceController brandPriceController;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnPriceResponseWhenValidRequest() throws Exception {
    	
        String applicationDate = "2020-06-14T10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;
    	
        BrandPrice mockBrandPrice = new BrandPrice(
                1, // brandId
                LocalDateTime.of(2020, 06, 14, 0, 0, 0), //startDate
                LocalDateTime.of(2020, 12, 31, 23, 59, 0), //endDate
                1, // priceList
                35455, // productId
                0, // priority
                new BigDecimal("35.50"),  // price
                "EUR"   // currency
        );

        when(brandPriceInteractor.findBrandPriceByCriteria(
                LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                productId,
                brandId)
        ).thenReturn(mockBrandPrice);

        var response = brandPriceController.pricesGet(applicationDate, productId, brandId);
        
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        PriceResponse body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getStartDate()).isEqualTo("2020-06-14T00:00:00");
        assertThat(body.getEndDate()).isEqualTo("2020-12-31T23:59:00");
        assertThat(body.getPrice()).isEqualTo("35.50 EUR");
        assertThat(body.getBrandId()).isEqualTo(1);
        assertThat(body.getProductId()).isEqualTo(35455);
    }
}
