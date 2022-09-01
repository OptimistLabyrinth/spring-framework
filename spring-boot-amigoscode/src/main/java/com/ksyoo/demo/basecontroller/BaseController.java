package com.ksyoo.demo.basecontroller;

import com.ksyoo.demo.exception.DuplicateEntity;
import com.ksyoo.demo.exception.EntityNotFound;
import com.ksyoo.demo.exception.RequestBodyIncomplete;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

public class BaseController {

    @ExceptionHandler({DuplicateEntity.class, EntityNotFound.class, RequestBodyIncomplete.class})
    public void exceptionHandler(RuntimeException e) {
        System.err.println("Error: " + e.getMessage());
        Arrays.stream(e.getStackTrace()).forEach(el -> System.err.println("    " + el));
        throw e;
    }

}
