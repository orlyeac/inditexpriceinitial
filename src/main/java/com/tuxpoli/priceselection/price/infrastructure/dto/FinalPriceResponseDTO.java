package com.tuxpoli.priceselection.price.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinalPriceResponseDTO(
        Long productId,
        Long brandId,
        Long priceList,
        @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
        LocalDateTime startDate,
        @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
        LocalDateTime endDate,
        BigDecimal price,
        String currency
) {
}
