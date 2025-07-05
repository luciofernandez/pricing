package com.inditex.pricing.infrastructure.rest.mapper;

import com.inditex.pricing.domain.model.BrandPrice;
import com.inditex.pricing.infrastructure.rest.formatter.PriceFormatter;
import com.inditex.pricing.infrastructure.rest.util.DateUtils;
import com.inditex.pricing.model.PriceResponse;

public class PriceResponseMapper {
	
	
    public static PriceResponse fromBrandPriceToResponse(BrandPrice brandPrice) {
    	PriceResponse response = new PriceResponse();
    	response.setBrandId(brandPrice.getBrandId());
    	response.setProductId(brandPrice.getProductId());
    	response.setStartDate(DateUtils.ISO_FORMAT.format(brandPrice.getStartDate()));
    	response.setPriceList(brandPrice.getPriceList());
    	response.setEndDate(DateUtils.ISO_FORMAT.format(brandPrice.getEndDate()));
    	response.setPrice(PriceFormatter.formatPrice(brandPrice.getPrice(), brandPrice.getCurrency()));
    	return response;

    }


}
