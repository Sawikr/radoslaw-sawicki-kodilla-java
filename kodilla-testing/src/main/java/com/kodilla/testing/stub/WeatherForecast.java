package com.kodilla.testing.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    //Task 6.5

    public double averageForecast() {
        double averageSum = 0.0;//important: not null!
        double average;
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperatureTwo : temperatures.getTemperatures().entrySet()) {
            //resultMap.put(temperatureTwo.getKey(), temperatureTwo.getValue());//Mentor: no need!
            averageSum += temperatures.getTemperatures().get(temperatureTwo.getKey());
        }
        average = averageSum / temperatures.getTemperatures().size();
        System.out.println("Average is: " + average);
        return average;
    }

    public double medianForecast() {

        double addMedian = 0.0;//important: not null!
        double median;

        TreeSet<Double> resultMedian = new TreeSet<>();
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperatureTwo : temperatures.getTemperatures().entrySet()) {
            //resultMap.put(temperatureTwo.getKey(), temperatureTwo.getValue());//Mentor: no need!
            addMedian = temperatures.getTemperatures().get(temperatureTwo.getKey());
            resultMedian.add(addMedian);
        }

        List<Double> listNumbers = new ArrayList<>(resultMedian);
        int size = listNumbers.size();
        //correction!
        if(size % 2 == 1){
            median = listNumbers.get((size+1)/2-1);
        }
        else
            median = ((listNumbers.get((size/2-1))) + (listNumbers.get((size/2))))/2;

        System.out.println("Median is: " + median);
        return median;
    }
}