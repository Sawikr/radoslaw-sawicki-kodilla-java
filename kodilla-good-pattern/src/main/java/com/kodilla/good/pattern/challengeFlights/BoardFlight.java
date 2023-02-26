package com.kodilla.good.pattern.challengeFlights;

import java.util.HashMap;

public class BoardFlight {

    public static HashMap<Integer, Flight> boardFlight() {
        HashMap<Integer, Flight> boardFlight = new HashMap<>();
        boardFlight.put(1, new Flight(1, "London", "Warsaw", "Toronto"));
        boardFlight.put(2, new Flight(2, "Berlin", "Helsinki", "Prague"));
        boardFlight.put(3, new Flight(3, "Paris", "Poznan", "Krakow"));
        boardFlight.put(4, new Flight(4, "Madrid", "Gdansk", "Wroclaw"));
        boardFlight.put(5, new Flight(5, "Madrid", "Barcelona", "Wroclaw"));
        boardFlight.put(6, new Flight(6,"Madrid", "Rome", "Amsterdam"));
        boardFlight.put(7, new Flight(7, "Madrid", "Rome", "Helsinki"));

        return boardFlight;
    }
}
