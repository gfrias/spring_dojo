package com.assignment.spring.dao;

import com.assignment.spring.openweather.response.WeatherResponse;
import com.assignment.spring.openweather.response.weatherresponse.Main;
import com.assignment.spring.openweather.response.weatherresponse.Sys;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherEntityTest {

    @Test
    public void testSuccessfulParse() {
        var weatherResponse = buildWeatherResponse();
        var weatherEntity = new WeatherEntity(weatherResponse);

        assertThat(weatherEntity.getCity()).isEqualTo("Amsterdam");
        assertThat(weatherEntity.getCountry()).isEqualTo("NL");
        assertThat(weatherEntity.getTemperature()).isEqualTo(290.1);

    }

    @Test
    public void testFailParse() {
        var weatherResponse = new WeatherResponse();

        try {
            new WeatherEntity(weatherResponse);
            fail("Should not reach here");
        } catch(Exception e) {
            assert(true);
        }

    }

    private WeatherResponse buildWeatherResponse() {
        var weatherResponse = new WeatherResponse();

        weatherResponse.setName("Amsterdam");
        var sys = new Sys();

        sys.setCountry("NL");
        weatherResponse.setSys(sys);

        var main = new Main();
        main.setTemp(290.1);
        weatherResponse.setMain(main);

        return weatherResponse;
    }
}
