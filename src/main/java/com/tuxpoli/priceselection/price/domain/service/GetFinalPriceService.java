package com.tuxpoli.priceselection.price.domain.service;

import com.tuxpoli.priceselection.price.domain.usecase.GetFinalPrice;
import com.tuxpoli.priceselection.price.domain.repository.PriceRepository;
import com.tuxpoli.priceselection.price.domain.entity.Price;
import com.tuxpoli.priceselection.price.domain.exception.FinalPriceNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class GetFinalPriceService implements GetFinalPrice {

    private final PriceRepository priceRepository;

    public GetFinalPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price getSpecificPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        List<Price> applicablePrices = this.priceRepository.findPricesByApplicationDateAndProduct(
                applicationDate,
                productId,
                brandId
        );
        return applicablePrices
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new FinalPriceNotFoundException("No price for that date and product"));
    }
}
