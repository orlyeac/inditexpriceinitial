package com.tuxpoli.inditexpriceselection.brand.infrastructure.mapper;

import com.tuxpoli.inditexpriceselection.brand.domain.entity.Brand;
import com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence.BrandEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BrandToBrandEntityMapper implements Function<Brand, BrandEntity> {

    @Override
    public BrandEntity apply(Brand brand) {
        return new BrandEntity(
                brand.getName()
        );
    }
}
