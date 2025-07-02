//package com.inditex.pricing.usecase;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//
//import com.inditex.pricing.domain.model.BrandPrice;
//import com.inditex.pricing.domain.model.BrandPriceSearchCriteria;
//import com.inditex.pricing.domain.repository.BrandPriceRepositoryPort;
//import com.inditex.pricing.providers.BrandPriceProvider;
//
//public class BrandPriceInteractorImplTest {
//
//    BrandPriceRepositoryPort brandPriceRepository;
//
//    @BeforeEach
//    void setUp() {
//    	brandPriceRepository = mock(BrandPriceRepositoryPort.class);
//    }
//    
//    @ParameterizedTest
//    @ArgumentsSource(BrandPriceProvider.class)
//    void getProductById_test(BrandPriceSearchCriteria repositoryMockedBrandPrice) {
//
//        // given
//        BrandPriceInteractorImpl brandPriceInteractorImpl = new BrandPriceInteractorImpl(brandPriceRepository);
//
//        BrandPrice brandPrice = new BrandPrice(2, LocalDateTime.now(), null, null, 1, null, null, null);
//        
//        when(brandPriceRepository.findBrandPriceByCriteria(repositoryMockedBrandPrice))
//                .thenReturn(brandPrice);
//
//
//        BrandPriceSearchCriteria criteria = new BrandPriceSearchCriteria(repositoryMockedBrandPrice.getApplicationDate(), repositoryMockedBrandPrice.getProductId(), repositoryMockedBrandPrice.getBrandId());
//        // when
//        BrandPrice bp = brandPriceInteractorImpl.findBrandPriceByCriteria(criteria);
//       
//        // then
//        verify(brandPriceRepository, times(1)).findBrandPriceByCriteria(criteria);
//        assertEquals(bp, brandPrice);
//    }
//
//
//	
//}
