package com.kodilla.exception.test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @version 0.0.1
 */

public class FindFlight {

    public static final Logger logger = Logger.getLogger((FindFlight.class.getName()));
    static Boolean result = false;//Not use null!

    public static void main(String[] args) {
        //We check if method will be working!
        try {
            findFlight(new Flight("London", "Toronto"));
            logger.info("Method findFlight is working!");
            System.out.println("Variable flightFound is: " + result + "!");
        } catch (RouteNotFoundException e) {
            System.out.println("We caught an exception here: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Variable flightFound is: " + result + "!");
        } finally {
            System.out.println("Method findFlight() is finished at " + LocalTime.now());
        }
    }

    public static void findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> flightPossible = new HashMap<>();
        flightPossible.put("Poznan", true);
        flightPossible.put("Krakow", true);
        flightPossible.put("Madrid", true);
        flightPossible.put("Warsaw", true);

        for (Map.Entry<String, Boolean> entry : flightPossible.entrySet()) {
            if (Objects.equals(flight.getArrivalAirport(), entry.getKey())) {
                result = true;
                break;
            }
        }
        if (!result){
            logger.info("Result is: " + result + "! We caught an exception!");
            throw new RouteNotFoundException("We caught an exception here: RouteNotFoundException");
        }
    }
}