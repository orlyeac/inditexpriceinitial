package com.tuxpoli.inditexpriceselection.brand.domain.repository;

import com.tuxpoli.inditexpriceselection.brand.domain.entity.Brand;
import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface BrandRepository {
    Brand createBrand(Brand brand);

    void deleteBrandById(Long id);
}
