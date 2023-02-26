package com.kodilla.good.pattern.challengeFlights;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import static com.kodilla.good.pattern.challengeFlights.BoardFlight.boardFlight;
import static com.kodilla.good.pattern.challengeFlights.FindFlightNumber.findFlightNumber;
import static com.kodilla.good.pattern.challengeFlights.FlightService.logger;
import static com.kodilla.good.pattern.challengeFlights.FlightService.result;

public class FindFlightSecondSolution {
    public static void findFlightFromAirportName(Flight flight) throws RouteNotFoundException {
        Map<Integer, Flight> boardFlightNew;
        for (Map.Entry<Integer, Flight> entry : boardFlight().entrySet()) {
            if (flight.getDepartureAirport().equals(entry.getValue().getDepartureAirport())) {
                boardFlightNew = boardFlight().entrySet().stream()
                        .filter(s -> Objects.equals(s.getValue().getDepartureAirport(), flight.getDepartureAirport()))
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toMap(Flight::getId, s -> s));
                for (Map.Entry<Integer, Flight> entryNew : boardFlightNew.entrySet()) {
                    System.out.println(entryNew.getValue());
                }
                result = true;
                findFlightNumber(flight);
                break;
            }
            if (flight.getTransferAirport().equals(entry.getValue().getTransferAirport())) {
                boardFlightNew = boardFlight().entrySet().stream()
                        .filter(s -> Objects.equals(s.getValue().getTransferAirport(), flight.getTransferAirport()))
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toMap(Flight::getId, s -> s));
                for (Map.Entry<Integer, Flight> entryNew : boardFlightNew.entrySet()) {
                    System.out.println(entryNew.getValue());
                }
                result = true;
                findFlightNumber(flight);
                break;
            }
            if (flight.getArrivalAirport().equals(entry.getValue().getArrivalAirport())) {
                boardFlightNew = boardFlight().entrySet().stream()
                        .filter(s -> Objects.equals(s.getValue().getArrivalAirport(), flight.getArrivalAirport()))
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toMap(Flight::getId, s -> s));
                for (Map.Entry<Integer, Flight> entryNew : boardFlightNew.entrySet()) {
                    System.out.println(entryNew.getValue());
                }
                result = true;
                findFlightNumber(flight);
                break;
            }
            if (!result) {
                logger.info("Result is: " + result + "! We caught an exception!");
                throw new RouteNotFoundException("We caught an exception here: RouteNotFoundException");
            }
        }
    }
}