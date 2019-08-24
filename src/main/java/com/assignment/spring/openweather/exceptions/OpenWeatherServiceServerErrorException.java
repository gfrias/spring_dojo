package com.assignment.spring.openweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class OpenWeatherServiceServerErrorException extends RuntimeException{
    public OpenWeatherServiceServerErrorException() {
        super();
    }
    public OpenWeatherServiceServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    public OpenWeatherServiceServerErrorException(String message) {
        super(message);
    }
    public OpenWeatherServiceServerErrorException(Throwable cause) {
        super(cause);
    }
}
