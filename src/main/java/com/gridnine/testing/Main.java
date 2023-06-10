package com.gridnine.testing;

import java.util.List;

/**
 * Класс для проверочного запуска приложения
 *
 */
public class Main
{
    public static void main( String[] args ) {
        List<Flight> flights =  FlightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();

        System.out.println("Все рейсы: ");
        flightFilter.getAllFlights(flights);
        System.out.println("-------------");

        System.out.println("Полеты в которых вылет до текущего момента времени: ");
        flightFilter.filterUpToTheCurrentTime(flights);
        System.out.println("-------------");

        System.out.println("Полеты в которых имеются сегменты с датой прилёта раньше даты вылета: ");
        flightFilter.filterSegmentsWithArrivalDateBeforeDepartureDate(flights);
        System.out.println("-------------");

        System.out.println("Полеты в которых общее время, проведённое на земле превышает два часа: ");
        flightFilter.filterOnEarthMoreThanTwoHours(flights);
    }
}
