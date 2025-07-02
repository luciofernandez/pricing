package com.inditex.pricing.infrastructure.database.h2.mapper;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.database.h2.entity.PricesEntity;

public class PricesEntityMapper {

    public static BrandPrice fromEntityToBrandPrice(PricesEntity pricesEntity) {
        return new BrandPrice(pricesEntity.getBrandId(),
        				   pricesEntity.getStartDate(),
                           pricesEntity.getEndDate(),
                           pricesEntity.getPriceList(),
                           pricesEntity.getProductId(),
                           pricesEntity.getPriority(),
                           pricesEntity.getPrice(),
                           pricesEntity.getCurrency()

        );
    }

	
}
