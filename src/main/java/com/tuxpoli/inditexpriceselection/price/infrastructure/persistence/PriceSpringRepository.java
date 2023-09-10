package com.tuxpoli.inditexpriceselection.price.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceSpringRepository extends JpaRepository<PriceEntity, Long> {

    @Query(
            "SELECT p" +
            " FROM PriceEntity p" +
            " WHERE" +
                    " p.endDate >= :applicationDate" +
                    " AND p.startDate <= :applicationDate" +
                    " AND p.productId = :productId" +
                    " AND p.brandId = :brandId"
    )
    List<PriceEntity> findPricesByApplicationDateAndProduct(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    );
}
