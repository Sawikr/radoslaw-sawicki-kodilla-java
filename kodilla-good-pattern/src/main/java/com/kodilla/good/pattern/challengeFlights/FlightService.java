package com.kodilla.good.pattern.challengeFlights;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Logger;
import static com.kodilla.good.pattern.challengeFlights.FindFlightFirstSolution.findFlightFromAirportName;

public class FlightService {

    public static final Logger logger = Logger.getLogger((FindFlightFirstSolution.class.getName()));
    static Boolean result = false;//Not use null!

    public static void main(String[] args) {
        try {
            findFlightFromAirportName(new Flight(1,"London", " ", " "));
            findFlightFromAirportName(new Flight(2, " ", "Poznan", " "));
            findFlightFromAirportName(new Flight(3, " ", "Gdansk", "Wroclaw"));
            findFlightFromAirportName(new Flight(4, " ", "Gdansk", " "));
            findFlightFromAirportName(new Flight(5, "Paris", " ", " "));
            findFlightFromAirportName(new Flight(6, "Madrid", "Rome", " "));

            //Another solution
            System.out.println("\nAnother solution:");
            FindFlightSecondSolution.findFlightFromAirportName(new Flight(1," ", "Gdansk", " "));

            logger.info("Method findFlight is working!");
            System.out.println("\nVariable flightFound is: " + result + "!");
        } catch (RouteNotFoundException e) {
            System.out.println("\nWe caught an exception here: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Variable flightFound is: " + result + "!");
        } finally {
            System.out.println("Method findFlight() is finished at " + LocalTime.now());
        }
    }
}
