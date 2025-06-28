package com.example.RentVideoAdvanced.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RentalLimitExceededException extends RuntimeException{
    
    public RentalLimitExceededException(String message){
        super(message);
    }
}
