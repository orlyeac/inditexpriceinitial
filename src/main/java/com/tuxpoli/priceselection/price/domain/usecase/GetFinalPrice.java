package com.tuxpoli.priceselection.price.domain.usecase;

import com.tuxpoli.priceselection.price.domain.entity.Price;

import java.time.LocalDateTime;

public interface GetFinalPrice {

    Price getSpecificPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
