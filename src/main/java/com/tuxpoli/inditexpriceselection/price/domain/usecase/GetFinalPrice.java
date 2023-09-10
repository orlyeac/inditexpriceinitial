package com.tuxpoli.inditexpriceselection.price.domain.usecase;

import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;

import java.time.LocalDateTime;

public interface GetFinalPrice {

    Price getSpecificPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
