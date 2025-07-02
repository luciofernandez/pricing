package com.inditex.pricing.infrastructure.database.h2.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.pricing.infrastructure.database.h2.entity.PricesEntity;

public interface PricesJpaRepository extends JpaRepository<PricesEntity, UUID>{
	@Query("SELECT p FROM PricesEntity p WHERE brandId = :brandId and productId = :productId and :appDate "
			+ "BETWEEN p.startDate and p.endDate ORDER BY p.priority DESC LIMIT 1")
	Optional<PricesEntity> findPricesByBrandPriceCriteria(@Param("appDate") LocalDateTime applicationDate,@Param("productId") Integer productId,
			@Param("brandId") Integer brandId);

}
