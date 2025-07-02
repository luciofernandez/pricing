//package com.inditex.pricing.providers;
//
//import java.time.LocalDateTime;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//
//import com.inditex.pricing.domain.model.BrandPriceSearchCriteria;
//
//public class BrandPriceProvider implements ArgumentsProvider {
//	
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
//        return Stream.of(
//                Arguments.of(new BrandPriceSearchCriteria(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 1)),
//                Arguments.of(new BrandPriceSearchCriteria(LocalDateTime.of(2020, 6, 14, 16, 0, 0), 35455, 1)),
//                Arguments.of(new BrandPriceSearchCriteria(LocalDateTime.of(2020, 6, 14, 21, 0, 0), 35455, 1)),
//                Arguments.of(new BrandPriceSearchCriteria(LocalDateTime.of(2020, 6, 15, 10, 0, 0), 35455, 1)),
//                Arguments.of(new BrandPriceSearchCriteria(LocalDateTime.of(2020, 6, 16, 21, 0, 0), 35455, 1))
//            );
//    }
//
//
//}
