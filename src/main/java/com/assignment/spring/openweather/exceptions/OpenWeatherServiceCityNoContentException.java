package com.assignment.spring.openweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class OpenWeatherServiceCityNoContentException extends RuntimeException{
    public OpenWeatherServiceCityNoContentException() {
        super();
    }
    public OpenWeatherServiceCityNoContentException(String message, Throwable cause) {
        super(message, cause);
    }
    public OpenWeatherServiceCityNoContentException(String message) {
        super(message);
    }
    public OpenWeatherServiceCityNoContentException(Throwable cause) {
        super(cause);
    }
}
