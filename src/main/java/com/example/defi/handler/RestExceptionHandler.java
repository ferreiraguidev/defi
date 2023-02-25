package com.example.defi.handler;


import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ExceptionFilters exceptionFilters(final NoSuchElementException ex, HttpRequest request) {
        return ExceptionFilters.builder()
                .title("Não pode encontrar registro relacionado ao id.")
                .details(ex.getMessage() + request.getURI())
                .status(BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
