package com.assignment.spring.openweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OpenWeatherServiceClientErrorException extends RuntimeException {
    public OpenWeatherServiceClientErrorException() {
        super();
    }
    public OpenWeatherServiceClientErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    public OpenWeatherServiceClientErrorException(String message) {
        super(message);
    }
    public OpenWeatherServiceClientErrorException(Throwable cause) {
        super(cause);
    }
}
