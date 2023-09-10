package com.tuxpoli.inditexpriceselection.common.infrastructure.exception;

import org.springframework.http.HttpStatus;

public record ApplicationException(
        String message,
        HttpStatus httpStatus
) {
}
