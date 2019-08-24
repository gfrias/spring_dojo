    package com.assignment.spring.openweather.resttemplate;

    import com.assignment.spring.openweather.exceptions.OpenWeatherServiceCityNotFoundException;
    import com.assignment.spring.openweather.exceptions.OpenWeatherServiceClientErrorException;
    import com.assignment.spring.openweather.exceptions.OpenWeatherServiceServerErrorException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.client.ClientHttpResponse;
    import org.springframework.web.client.ResponseErrorHandler;

    import java.io.IOException;

    import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
    import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

    public class OpenWeatherRestTemplateErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse httpResponse)
                throws IOException {

            return (
                    httpResponse.getStatusCode().series() == CLIENT_ERROR
                            || httpResponse.getStatusCode().series() == SERVER_ERROR);
        }

        @Override
        public void handleError(ClientHttpResponse httpResponse)
                throws IOException {

            if (httpResponse.getStatusCode()
                    .series() == SERVER_ERROR) {
                throw new OpenWeatherServiceServerErrorException("external service server error");
            } else if (httpResponse.getStatusCode()
                    .series() == CLIENT_ERROR) {
                // handle CLIENT_ERROR
                if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new OpenWeatherServiceCityNotFoundException("city not found, check city");
                } else {
                    throw new OpenWeatherServiceClientErrorException("bad request, check city");
                }
            }
        }

    }
