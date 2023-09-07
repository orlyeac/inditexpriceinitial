package com.tuxpoli.priceselection.price.domain.repository;

import com.tuxpoli.priceselection.price.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    void createPrice(Price price);

    List<Price> findPricesByApplicationDateAndProduct(LocalDateTime applicationDate, Long productId, Long brandId);
}
