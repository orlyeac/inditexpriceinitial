package com.tuxpoli.inditexpriceselection.common.infrastructure.exception;

import com.tuxpoli.inditexpriceselection.common.domain.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleFinalPriceNotFoundException(
            NotFoundException notFoundException
    ) {
        return new ResponseEntity<>(
                new ApplicationException(notFoundException.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }
}
