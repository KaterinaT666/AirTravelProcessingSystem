package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс для тестирования методов приложения
 */
public class FlightFilterImplTest {
    private final List<Segment> segments = new ArrayList<>();
    private final FlightFilter flightFilter = new FlightFilterImpl();
    private final List<Flight> flights = new ArrayList<>();
    LocalDateTime time = LocalDateTime.now();
    @Test
    @DisplayName("Тестирование метода фильтра полетов в которых вылет до текущего момента времени.")
    public void filterUpToTheCurrentTime(){
        Segment segment = new Segment(LocalDateTime.now().minusHours(5),LocalDateTime.now());
        segments.add(segment);
        List<Flight> filteredFlights = flightFilter.filterUpToTheCurrentTime(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test
    @DisplayName("Тестирование метода" +
            " фильтра полетов в которых имеются сегменты с датой прилёта раньше даты вылета.")
    public void filterSegmentsWithArrivalDateBeforeDepartureDate(){
        Segment segment = new Segment(LocalDateTime.now(),LocalDateTime.now().minusHours(2));
        segments.add(segment);
        List<Flight> filteredFlights = flightFilter.filterSegmentsWithArrivalDateBeforeDepartureDate(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test
    @DisplayName("Тестирование метода " +
            "фильтра полетов в которых общее время, проведённое на земле превышает два часа.")
    public void filterOnEarthMoreThanTwoHours(){
        Segment segment1 = new Segment(time.plusHours(2), time);
        Segment segment2 = new Segment(time.plusHours(2).plusMinutes(5),time.plusHours(5));
        segments.add(segment1);
        segments.add(segment2);
        List<Flight> filteredFlights = flightFilter.filterOnEarthMoreThanTwoHours(flights);
        assertTrue(filteredFlights.isEmpty());
    }
}
