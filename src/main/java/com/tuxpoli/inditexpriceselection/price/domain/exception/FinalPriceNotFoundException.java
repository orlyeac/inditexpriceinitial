package com.tuxpoli.inditexpriceselection.price.domain.exception;

import com.tuxpoli.inditexpriceselection.common.domain.NotFoundException;

public class FinalPriceNotFoundException extends NotFoundException {

    public FinalPriceNotFoundException(String message) {
        super(message);
    }
}
