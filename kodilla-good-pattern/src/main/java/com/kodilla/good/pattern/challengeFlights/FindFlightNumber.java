package com.kodilla.good.pattern.challengeFlights;

import java.util.Map;
import static com.kodilla.good.pattern.challengeFlights.BoardFlight.boardFlight;
import static com.kodilla.good.pattern.challengeFlights.FlightService.result;

public class FindFlightNumber {

    public static void findFlightNumber(Flight flight) {
        for (Map.Entry<Integer, Flight> entry : boardFlight().entrySet()) {
            int nameOfAirport = 0;
            if (flight.getDepartureAirport().equals(entry.getValue().getDepartureAirport())) {
                result = true;
                nameOfAirport = entry.getKey();
            }
            else if (flight.getTransferAirport().equals(entry.getValue().getTransferAirport())) {
                result = true;
                nameOfAirport = entry.getKey();
            }
            else if (flight.getArrivalAirport().equals(entry.getValue().getArrivalAirport())) {
                result = true;
                nameOfAirport = entry.getKey();
            }
            if (nameOfAirport != 0)
                System.out.println("Number of flight is: " + nameOfAirport);
        }
    }
}
