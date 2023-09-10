package com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandSpringRepository extends JpaRepository<BrandEntity, Long> {
}
