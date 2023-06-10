package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для фильтрации списка рейсов
 */

public class FlightFilterImpl implements FlightFilter {
    private final List<Segment> segs = new ArrayList<>();
    private final LocalDateTime currentDateTime = LocalDateTime.now();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final List <Flight> tempListFlights = new ArrayList<>();

    /**
     * Метод получения всех полетов
     * @param flights
     */
    @Override
    public void getAllFlights(List<Flight> flights) {
        flights.forEach(System.out::println);
    }

    /**
     * Фильтр полетов в которых вылет до текущего момента времени
     * @param flights
     * @return tempListFlights
     */
    @Override
    public List<Flight> filterUpToTheCurrentTime(List<Flight> flights){
        for (Flight flight : flights){
            segs.addAll(flight.getSegments());
            while (segs.size() > 0){
                LocalDateTime dep = segs.get(0).getDepartureDate();
                LocalDateTime arr = segs.remove(0).getArrivalDate();
                if (dep.isBefore(currentDateTime)){
                    showFlight(flight, dep, arr);
                    tempListFlights.add(flight);
                }
            }
        }
        return tempListFlights;
    }

    /**
     * Фильтр полетов в которых имеются сегменты с датой прилёта раньше даты вылета
     * @param flights
     * @return tempListFlights
     */
    @Override
    public List<Flight> filterSegmentsWithArrivalDateBeforeDepartureDate(List<Flight> flights) {
        for (Flight flight : flights) {
            segs.addAll(flight.getSegments());
            while (segs.size() > 0) {
                LocalDateTime dep = segs.get(0).getDepartureDate();
                LocalDateTime arr = segs.remove(0).getArrivalDate();
                if (arr.isBefore(dep)) {
                    showFlight(flight, dep, arr);
                    tempListFlights.add(flight);
                }
            }
        }
        return tempListFlights;
    }

    /**
     * Фильтр полетов в которых общее время, проведённое на земле превышает два часа
     * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
     * @param flights
     * @return tempListFlights
     */
    @Override
    public List<Flight> filterOnEarthMoreThanTwoHours(List<Flight> flights){
        for (Flight flight : flights) {
            segs.addAll(flight.getSegments());
            if (segs.size() > 2){
                while (segs.size() > 2){
                    LocalDateTime arr = segs.remove(1).getArrivalDate();
                    LocalDateTime dep = segs.remove(1).getDepartureDate();
                    if (arr.plusHours(2).isBefore(dep)){
                        showFlight(flight, dep, arr);
                        tempListFlights.add(flight);
                    }
                }
            }
        }
        return tempListFlights;
    }

    /**
     * Метод отображения информации о рейсе
     * @param flight
     * @param dep
     * @param arr
     */
    private void showFlight (Flight flight, LocalDateTime dep, LocalDateTime arr){
        System.out.println("Отправление: " + dateTimeFormatter.format(dep)+ "\n"
                + "Прибытие: " + dateTimeFormatter.format(arr) + "\n");
    }
}
