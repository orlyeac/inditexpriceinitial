package com.tuxpoli.inditexpriceselection.price.infrastructure.mapper;

import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;
import com.tuxpoli.inditexpriceselection.price.infrastructure.persistence.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PriceEntityToPriceMapper implements Function<PriceEntity, Price> {

    @Override
    public Price apply(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getId(),
                priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurrency()
        );
    }
}
