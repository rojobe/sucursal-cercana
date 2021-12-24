package com.fravega.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SucursalNotFoundException extends RuntimeException{

    public SucursalNotFoundException(String message) {
        super(message);
    }

}
