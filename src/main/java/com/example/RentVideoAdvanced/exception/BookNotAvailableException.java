package com.example.RentVideoAdvanced.exception;

public class BookNotAvailableException extends RuntimeException{
    
    public BookNotAvailableException(String message){
        super(message);
    }
    
}
