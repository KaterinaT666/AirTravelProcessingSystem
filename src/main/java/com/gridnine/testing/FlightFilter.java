package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс для класса FlightFilterImpl
 */
public interface FlightFilter {

    // Все полеты
    void getAllFlights(List<Flight> flights);
    //Фильтр полетов в которых вылет до текущего момента времени
    List<Flight> filterUpToTheCurrentTime(List<Flight> flights);

    // Фильтр полетов в которых имеются сегменты с датой прилёта раньше даты вылета
    List<Flight> filterSegmentsWithArrivalDateBeforeDepartureDate(List<Flight> flights);

    //Фильтр полетов в которых общее время, проведённое на земле превышает два часа
    // (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
    List<Flight> filterOnEarthMoreThanTwoHours(List<Flight> flights);
}
