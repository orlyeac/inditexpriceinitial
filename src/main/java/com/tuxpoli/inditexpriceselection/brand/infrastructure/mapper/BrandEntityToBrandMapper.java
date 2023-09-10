package com.tuxpoli.inditexpriceselection.brand.infrastructure.mapper;

import com.tuxpoli.inditexpriceselection.brand.domain.entity.Brand;
import com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence.BrandEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BrandEntityToBrandMapper implements Function<BrandEntity, Brand> {

    @Override
    public Brand apply(BrandEntity brandEntity) {
        return new Brand(
                brandEntity.getId(),
                brandEntity.getName()
        );
    }
}
