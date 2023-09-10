package com.tuxpoli.inditexpriceselection.price.domain.repository;

import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    Price createPrice(Price price);

    List<Price> findPricesByApplicationDateAndProduct(LocalDateTime applicationDate, Long productId, Long brandId);
}
