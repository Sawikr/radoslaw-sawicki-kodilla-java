package com.kodilla.good.pattern.challengeFlights;

public class RouteNotFoundException extends Exception{

    public RouteNotFoundException(String message) {
        super(message);
    }
}