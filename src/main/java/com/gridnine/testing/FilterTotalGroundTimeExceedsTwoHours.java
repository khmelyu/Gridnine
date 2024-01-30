package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTotalGroundTimeExceedsTwoHours implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    Duration totalGroundTime = Duration.ZERO;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Duration groundTime = Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
                        totalGroundTime = totalGroundTime.plus(groundTime);
                    }
                    return totalGroundTime.toHours() <= 2;
                })
                .collect(Collectors.toList());
    }
}
