package com.kodilla.testing.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Better used Mock!!!
 * Stub not recommended!!!
 */

public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();//getting stub: TemperaturesStub()!!!
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}
