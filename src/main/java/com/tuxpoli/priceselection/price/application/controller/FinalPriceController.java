package com.tuxpoli.priceselection.price.application.controller;

import com.tuxpoli.priceselection.price.domain.usecase.GetFinalPrice;
import com.tuxpoli.priceselection.price.infrastructure.dto.FinalPriceResponseDTO;
import com.tuxpoli.priceselection.price.infrastructure.mapper.PriceToFinalPriceResponseDTOMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/v1/prices")
public class FinalPriceController {

    private final GetFinalPrice getFinalPrice;
    private final PriceToFinalPriceResponseDTOMapper priceToFinalPriceResponseDTOMapper;

    public FinalPriceController(GetFinalPrice getFinalPrice,
                                PriceToFinalPriceResponseDTOMapper priceToFinalPriceResponseDTOMapper) {
        this.getFinalPrice = getFinalPrice;
        this.priceToFinalPriceResponseDTOMapper = priceToFinalPriceResponseDTOMapper;
    }
    @GetMapping("final")
    public FinalPriceResponseDTO getSpecificPrice(@RequestParam(required = true)
                                                  @DateTimeFormat(
                                                          pattern = "yyyy-MM-dd-HH.mm.ss"
                                                  )
                                                  LocalDateTime applicationDate,
                                                  @RequestParam(required = true) Long productId,
                                                  @RequestParam(required = true) Long brandId) {
        return this.priceToFinalPriceResponseDTOMapper.apply(
                this.getFinalPrice.getSpecificPrice(applicationDate, productId, brandId)
        );
    }
}
