package com.tuxpoli.priceselection.price.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    void createPrice(Price price);

    List<Price> findPricesByApplicationDateAndProduct(LocalDateTime applicationDate, Long productId, Long brandId);
}
