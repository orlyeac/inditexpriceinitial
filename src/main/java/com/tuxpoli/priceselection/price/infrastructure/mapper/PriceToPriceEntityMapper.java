package com.tuxpoli.priceselection.price.infrastructure.mapper;

import com.tuxpoli.priceselection.price.domain.entity.Price;
import com.tuxpoli.priceselection.price.infrastructure.persistence.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PriceToPriceEntityMapper implements Function<Price, PriceEntity> {

    @Override
    public PriceEntity apply(Price price) {
        return new PriceEntity(
                price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriceList(),
                price.getProductId(),
                price.getPriority(),
                price.getPrice(),
                price.getCurrency()
        );
    }
}
