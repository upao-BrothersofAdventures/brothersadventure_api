package com.example.brothersofadventure.itinerary.domain.exception;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class PublicacionNotFoundException extends RuntimeException {
    public PublicacionNotFoundException(String message) {
        super(message);
    }
}



