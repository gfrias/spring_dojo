package com.assignment.spring.openweather.service;

import com.assignment.spring.openweather.exceptions.OpenWeatherServiceCityNotFoundException;
import com.assignment.spring.openweather.exceptions.OpenWeatherServiceClientErrorException;
import com.assignment.spring.openweather.exceptions.OpenWeatherServiceNotAvailableException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherServiceTest {

    @Autowired
    private OpenWeatherService openWeatherService;

    @Test
    public void testSuccessfulCityDataFetch() {
        var cityName = "Amsterdam";

        var response = openWeatherService.getWeather(cityName);

        assertThat(response.getName()).isEqualTo(cityName);
        assertThat(response.getCod()).isEqualTo(200);

        assertThat(response.getSys().getCountry()).isEqualTo("NL");

        assertThat(response.getMain().getTemp()).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void testInvalidCityDataFetch() {
        String cityName = "abcdefghi";

        try {
            openWeatherService.getWeather(cityName);
        } catch (OpenWeatherServiceCityNotFoundException cityNotFoundEx) {
            assert(true);
        } catch (Exception e) {
            fail("Unexpected exception");
        }

    }

    @Test
    public void testServiceNotAvailable() {
        OpenWeatherService wrongEndpointService = new OpenWeatherService() {
            @Override
            protected String buildUrl(String city) {
                restTemplate = openWeatherService.restTemplate;
                return "https://thisservicedoesnotexist.com?{city}".replace("{city}", city);
            }
        };

        String cityName = "Amsterdam";

        try {
            wrongEndpointService.getWeather(cityName);
        } catch (OpenWeatherServiceNotAvailableException serviceNotAvailEx) {
            assert (true);
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }

    @Test
    public void testServiceClientError() {
        String cityName = "";

        try {
            openWeatherService.getWeather(cityName);
        } catch (OpenWeatherServiceClientErrorException openWeatherServiceClientErrorException) {
            assert(true);
        } catch (Exception e){
            fail("Unexpected exception");
        }

    }
}
