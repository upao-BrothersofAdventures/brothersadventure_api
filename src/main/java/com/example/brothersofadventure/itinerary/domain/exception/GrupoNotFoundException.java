package com.example.brothersofadventure.itinerary.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class GrupoNotFoundException extends RuntimeException {
    public GrupoNotFoundException(String message) {
        super(message);
    }
}
