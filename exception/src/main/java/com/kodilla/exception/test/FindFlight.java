package com.kodilla.exception.test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindFlight {

    static Boolean result = null;

    public static void main(String[] args) throws RouteNotFoundException {
        //Return null!
        try {
            result = findFlight(new Flight("London", "Toronto"));
            System.out.println("Variable flightFound is: " + result + "!");
        } catch (NullPointerException e) {
            System.out.println("We caught an exception: " + Arrays.toString(e.getStackTrace()));
        } finally {
            System.out.println("Method findFlight() is finished at " + LocalTime.now());
        }
    }

    public static boolean findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> flightPossible = new HashMap<>();
        flightPossible.put("Poznan", true);
        flightPossible.put("Krakow", true);
        flightPossible.put("Madrid", true);
        flightPossible.put("Warsaw", true);

        for (Map.Entry<String, Boolean> entry : flightPossible.entrySet()) {
            if (flight.getArrivalAirport().equals(entry.getKey())) {
                result = true;
                break;
            }
        }
        try {
            try {
                return result;
            } catch (NullPointerException e) {
                System.out.println("We caught an exception: " + Arrays.toString(e.getStackTrace()));
                throw new RouteNotFoundException("We caught an exception: " + e.getMessage());
            }
        } catch (RouteNotFoundException e) {
            System.out.println("We caught an exception: " + e.getMessage());
        } finally {
            System.out.println("Method findFlight() is finished at " + LocalTime.now());
        }
        return result;
    }
}