package com.assignment.spring.api;

import com.assignment.spring.api.exceptions.ApiInternalServerError;
import com.assignment.spring.dao.WeatherEntity;
import com.assignment.spring.dao.WeatherRepository;
import com.assignment.spring.openweather.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private OpenWeatherService openWeatherService;

    @RequestMapping("/weather")
    public WeatherEntity weather(HttpServletRequest request) {
        String city = request.getParameter("city");
        var response = openWeatherService.getWeather(city);

        try {
            var weatherEntity = new WeatherEntity(response);
            weatherRepository.save(weatherEntity);
            return weatherEntity;

        } catch (Exception e) {
            throw new ApiInternalServerError("error while saving weather data");
        }
    }
}
