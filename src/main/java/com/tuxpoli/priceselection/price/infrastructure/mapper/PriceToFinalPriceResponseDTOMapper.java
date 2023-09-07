package com.tuxpoli.priceselection.price.infrastructure.mapper;

import com.tuxpoli.priceselection.price.domain.Price;
import com.tuxpoli.priceselection.price.infrastructure.dto.FinalPriceResponseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PriceToFinalPriceResponseDTOMapper implements Function<Price, FinalPriceResponseDTO> {

    @Override
    public FinalPriceResponseDTO apply(Price price) {
        return new FinalPriceResponseDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice(),
                price.getCurrency()
        );
    }
}
