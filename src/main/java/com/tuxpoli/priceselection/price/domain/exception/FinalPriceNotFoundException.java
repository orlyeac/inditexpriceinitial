package com.tuxpoli.priceselection.price.domain.exception;

public class FinalPriceNotFoundException extends RuntimeException {

    public FinalPriceNotFoundException(String message) {
        super(message);
    }
}
