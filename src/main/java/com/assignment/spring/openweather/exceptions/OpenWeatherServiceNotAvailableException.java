package com.assignment.spring.openweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class OpenWeatherServiceNotAvailableException extends RuntimeException {
    public OpenWeatherServiceNotAvailableException() {
        super();
    }
    public OpenWeatherServiceNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
    public OpenWeatherServiceNotAvailableException(String message) {
        super(message);
    }
    public OpenWeatherServiceNotAvailableException(Throwable cause) {
        super(cause);
    }
}
