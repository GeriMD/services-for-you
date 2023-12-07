package com.example.servicesforyou.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UsernameTakenException extends RuntimeException {
    private String username;

    public UsernameTakenException(String message, String username){
        super(message);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
