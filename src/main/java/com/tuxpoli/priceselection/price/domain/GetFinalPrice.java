package com.tuxpoli.priceselection.price.domain;

import java.time.LocalDateTime;

public interface GetFinalPrice {

    Price getSpecificPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
