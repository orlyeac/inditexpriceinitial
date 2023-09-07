package com.tuxpoli.priceselection.price.infrastructure.exception;

import com.tuxpoli.priceselection.price.domain.exception.FinalPriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = FinalPriceNotFoundException.class)
    public ResponseEntity<Object> handleFinalPriceNotFoundException(
            FinalPriceNotFoundException finalPriceNotFoundException
    ) {
        return new ResponseEntity<>(
                new ApplicationException(finalPriceNotFoundException.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }
}
