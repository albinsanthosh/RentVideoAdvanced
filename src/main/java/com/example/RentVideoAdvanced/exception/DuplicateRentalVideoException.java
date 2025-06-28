package com.example.RentVideoAdvanced.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateRentalVideoException extends RuntimeException{
    public DuplicateRentalVideoException(String message) {
        super(message);
    }
}
