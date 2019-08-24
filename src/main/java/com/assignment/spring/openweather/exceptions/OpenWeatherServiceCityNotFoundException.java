package com.assignment.spring.openweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OpenWeatherServiceCityNotFoundException extends RuntimeException {
    public OpenWeatherServiceCityNotFoundException() {
        super();
    }
    public OpenWeatherServiceCityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public OpenWeatherServiceCityNotFoundException(String message) {
        super(message);
    }
    public OpenWeatherServiceCityNotFoundException(Throwable cause) {
        super(cause);
    }
}
