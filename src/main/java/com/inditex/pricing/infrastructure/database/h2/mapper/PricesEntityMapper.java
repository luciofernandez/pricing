package com.inditex.pricing.infrastructure.database.h2.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.database.h2.entity.PricesEntity;
import com.inditex.pricing.infrastructure.rest.controller.BrandPriceController;

public class PricesEntityMapper {

    private static final Logger logger = LoggerFactory.getLogger(PricesEntityMapper.class);

	
    public static BrandPrice fromEntityToBrandPrice(PricesEntity pricesEntity) {
    	logger.debug("Mapeo de PricesEntity " + pricesEntity);
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
