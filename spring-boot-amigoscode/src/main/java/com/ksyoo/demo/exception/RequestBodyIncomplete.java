package com.ksyoo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestBodyIncomplete extends RuntimeException {

    public RequestBodyIncomplete(String message) {
        super(message);
    }

}
