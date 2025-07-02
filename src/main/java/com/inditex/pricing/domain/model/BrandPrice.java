package com.inditex.pricing.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandPrice {
	
	private Integer brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceList;
	private Integer productId;
	private Integer priority;
	private BigDecimal price;
	private String currency;
	
}
