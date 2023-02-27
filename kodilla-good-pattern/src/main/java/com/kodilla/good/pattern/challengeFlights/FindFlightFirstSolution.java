package com.kodilla.good.pattern.challengeFlights;

import java.util.Map;
import java.util.Objects;
import static com.kodilla.good.pattern.challengeFlights.BoardFlight.boardFlight;
import static com.kodilla.good.pattern.challengeFlights.FindFlightNumber.findFlightNumber;
import static com.kodilla.good.pattern.challengeFlights.FlightService.logger;
import static com.kodilla.good.pattern.challengeFlights.FlightService.result;

public class FindFlightFirstSolution {

    public static void findFlightFromAirportName(Flight flight) throws RouteNotFoundException {
        for (Map.Entry<Integer, Flight> entry : boardFlight().entrySet()) {
            if (getDepartureAirport(flight, entry))
                break;
            if (getTransferAirport(flight, entry))
                break;
            if (getArrivalAirport(flight, entry))
                break;
            if (!result) {
                logger.info("Result is: " + result + "! We caught an exception!");
                throw new RouteNotFoundException("We caught an exception here: RouteNotFoundException");
            }
        }
    }

    private static boolean getArrivalAirport(Flight flight, Map.Entry<Integer, Flight> entry) {
        if (flight.getArrivalAirport().equals(entry.getValue().getArrivalAirport())) {
            boardFlight().entrySet().stream()
                    .filter(s -> Objects.equals(s.getValue().getArrivalAirport(), flight.getArrivalAirport()))
                    .map(Map.Entry::getValue)
                    .forEach(System.out::println);
            result = true;
            findFlightNumber(flight);
            return true;
        }
        return false;
    }

    private static boolean getTransferAirport(Flight flight, Map.Entry<Integer, Flight> entry) {
        if (flight.getTransferAirport().equals(entry.getValue().getTransferAirport())) {
            boardFlight().entrySet().stream()
                    .filter(s -> Objects.equals(s.getValue().getTransferAirport(), flight.getTransferAirport()))
                    .map(Map.Entry::getValue)
                    .forEach(System.out::println);
            result = true;
            findFlightNumber(flight);
            return true;
        }
        return false;
    }

    private static boolean getDepartureAirport(Flight flight, Map.Entry<Integer, Flight> entry) {
        if (flight.getDepartureAirport().equals(entry.getValue().getDepartureAirport())) {
            boardFlight().entrySet().stream()
                    .filter(s -> Objects.equals(s.getValue().getDepartureAirport(), flight.getDepartureAirport()))
                    .map(Map.Entry::getValue)
                    .forEach(System.out::println);
            result = true;
            findFlightNumber(flight);
            return true;
        }
        return false;
    }
}