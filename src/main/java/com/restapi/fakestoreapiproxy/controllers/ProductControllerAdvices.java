package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.dtos.ErrorResponseDto;
import com.restapi.fakestoreapiproxy.exceptions.NoProductFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ProductControllerAdvices {
    @ExceptionHandler(NoProductFoundException.class)
    private ResponseEntity<ErrorResponseDto> exceptionHandlerForNoProductFound(NoProductFoundException exception)
    {
        ErrorResponseDto entity =new ErrorResponseDto();
        entity.setMessage(exception.getMessage());

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}