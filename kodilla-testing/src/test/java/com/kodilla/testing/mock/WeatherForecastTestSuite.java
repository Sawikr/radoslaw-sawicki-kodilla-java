package com.kodilla.testing.mock;

import com.kodilla.testing.stub.Temperatures;
import com.kodilla.testing.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)//expansion of class opportunities!
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!\n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\nTest WeatherForecastTestSuite" +
                "begin!");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test WeatherForecastTestSuite "
                + "end!\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @DisplayName("Name of test: testCalculateForecastWithMock")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);

        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);//important
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);//important

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    //Task 6.5
    @Nested
    @DisplayName("Name of test: Task 6.5 Adding two new methods!")
    class Task6_5 {

        @Mock
        private Temperatures temperaturesMock;

        @DisplayName("Name of test: testAverageForecastWithMock")
        @Test
        void testAverageForecastWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);

            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecastNow = new WeatherForecast(temperaturesMock);

            //When
            double quantityAverage = weatherForecastNow.averageForecast();

            //Then
            Assertions.assertEquals(25.56, quantityAverage);

        }

        @Mock
        private Temperatures temperaturesMockTwo;

        @DisplayName("Name of test: testMedianForecastWithMock")
        @Test
        void testMedianForecastWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);

            when(temperaturesMockTwo.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecastNow = new WeatherForecast(temperaturesMockTwo);

            //When
            double quantityMedian = weatherForecastNow.medianForecast();

            //Then
            Assertions.assertEquals(25.5, quantityMedian);

        }
    }
}
