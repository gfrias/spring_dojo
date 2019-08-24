package com.assignment.spring.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiInternalServerError extends RuntimeException{
    public ApiInternalServerError() {
        super();
    }
    public ApiInternalServerError(String message, Throwable cause) {
        super(message, cause);
    }
    public ApiInternalServerError(String message) {
        super(message);
    }
    public ApiInternalServerError(Throwable cause) {
        super(cause);
    }
}
