package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter departureBeforeCurrentTimeFilter = new FilterDepartureBeforeCurrentTime();
        List<Flight> departureBeforeCurrentTime = departureBeforeCurrentTimeFilter.filter(flights);
        System.out.println("Excluded: departure before current time:");
        printFlights(departureBeforeCurrentTime);

        FlightFilter arrivalBeforeDepartureFilter = new FilterArrivalBeforeDeparture();
        List<Flight> arrivalBeforeDeparture = arrivalBeforeDepartureFilter.filter(flights);
        System.out.println("\nExcluded: arrival time before departure time:");
        printFlights(arrivalBeforeDeparture);

        FlightFilter totalGroundTimeExceedsTwoHoursFilter = new FilterTotalGroundTimeExceedsTwoHours();
        List<Flight> totalGroundTimeExceedsTwoHours = totalGroundTimeExceedsTwoHoursFilter.filter(flights);
        System.out.println("\nExcluded: total ground time exceeds two hours:");
        printFlights(totalGroundTimeExceedsTwoHours);
    }

    private static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}