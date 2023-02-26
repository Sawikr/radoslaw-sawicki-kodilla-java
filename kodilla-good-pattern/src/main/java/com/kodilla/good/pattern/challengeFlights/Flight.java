package com.kodilla.good.pattern.challengeFlights;

import java.util.Objects;

public class Flight {

    private int Id;
    private final String departureAirport;
    private final String transferAirport;
    private final String arrivalAirport;

    public Flight(int Id, String departureAirport, String transferAirport, String arrivalAirport) {
        this.Id = Id;
        this.departureAirport = departureAirport;
        this.transferAirport = transferAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getId() {
        return Id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getTransferAirport() {
        return transferAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(transferAirport, flight.transferAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, transferAirport, arrivalAirport);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "Id = " + Id +
                ", departureAirport = '" + departureAirport + '\'' +
                ", transferAirport = '" + transferAirport + '\'' +
                ", arrivalAirport = '" + arrivalAirport + '\'' +
                '}';
    }
}