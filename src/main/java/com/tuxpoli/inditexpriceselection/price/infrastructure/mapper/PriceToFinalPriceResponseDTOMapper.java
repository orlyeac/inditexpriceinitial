package com.tuxpoli.inditexpriceselection.price.infrastructure.mapper;

import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;
import com.tuxpoli.inditexpriceselection.price.infrastructure.dto.FinalPriceResponseDTO;
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
