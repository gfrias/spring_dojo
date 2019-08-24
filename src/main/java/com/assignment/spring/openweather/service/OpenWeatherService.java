package com.assignment.spring.openweather.service;

import com.assignment.spring.openweather.exceptions.OpenWeatherServiceCityNoContentException;
import com.assignment.spring.openweather.exceptions.OpenWeatherServiceNotAvailableException;
import com.assignment.spring.openweather.response.WeatherResponse;
import com.assignment.spring.openweather.resttemplate.OpenWeatherRestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


@Service
public class OpenWeatherService {
    @Value("${openWeather.appId}")
    private String appId;

    @Value("${openWeather.url}")
    private String weatherUrl;

    @Autowired
    protected RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String url = buildUrl(city);

        try {
            restTemplate.setErrorHandler(errorHandler());
            var response = restTemplate.getForEntity(url, WeatherResponse.class);
            var body = response.getBody();

            if (body != null) {
                return body;
            }
            throw new OpenWeatherServiceCityNoContentException("there's no data available for the given city");
        } catch (ResourceAccessException e) {
            throw new OpenWeatherServiceNotAvailableException("external service not available");
        }

    }

    protected ResponseErrorHandler errorHandler() {
        return new OpenWeatherRestTemplateErrorHandler();
    }

    protected String buildUrl(String city) {
        return weatherUrl.replace("{city}", city).replace("{appId}", appId);
    }
}
