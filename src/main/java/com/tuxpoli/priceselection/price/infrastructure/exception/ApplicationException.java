package com.tuxpoli.priceselection.price.infrastructure.exception;

import org.springframework.http.HttpStatus;

public record ApplicationException(
        String message,
        HttpStatus httpStatus
) {
}
