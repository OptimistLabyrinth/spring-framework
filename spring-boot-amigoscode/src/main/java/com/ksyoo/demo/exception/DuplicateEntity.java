package com.ksyoo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateEntity extends RuntimeException {

    public DuplicateEntity(String message) {
        super(message);
    }

}
