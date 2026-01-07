package com.bl.advance.java.day26.workshop.problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservationSystem {
    List<Hotel> hotels = new ArrayList<>();

    public void addHotels(Hotel hotel) {
        hotels.add(hotel);
        System.out.println("Hotel added successfully: " + hotel.getHotelName());
    }

    public void showHotels() {
        if (hotels.isEmpty()) {
            System.out.println("No hotels are available!!");
            return;
        }
        System.out.println("Available Hotels list are:  ");
        hotels.forEach(System.out::println);
    }

    public void findCheapestHotel(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");

        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        int weekDaysCount = 0;
        int weekendDaysCount = 0;

        LocalDate date = start;

        while (!date.isAfter(end)) {
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                weekendDaysCount++;
            } else {
                weekDaysCount++;
            }
            date = date.plusDays(1);
        }

        int cheapPrice = Integer.MAX_VALUE;
        String cheapHotelName = "";

        for (Hotel hotel : hotels) {

            int totalCostOfHotel = (hotel.getWeekdayRate() * weekDaysCount) + (hotel.getWeekendRate() * weekendDaysCount);

            if (totalCostOfHotel < cheapPrice) {
                cheapPrice = totalCostOfHotel;
                cheapHotelName = hotel.getHotelName();
            }
        }
        System.out.println("Cheapest Hotel is : " + cheapHotelName + " and the price is: " + cheapPrice);
    }

    public Hotel findCheapestBestRatedHotel(String startDate, String endDate) {
        return hotels.stream()
                .min(
                        Comparator.comparingInt((Hotel h) ->
                                        calculateTotalCost(h, startDate, endDate))
                                .thenComparing(Hotel::getRating, Comparator.reverseOrder())
                )
                .orElse(null);
    }

    public int calculateTotalCost(Hotel hotel, String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end   = LocalDate.parse(endDate, formatter);

        int total = 0;
        LocalDate date = start;

        while (!date.isAfter(end)) {
            DayOfWeek day = date.getDayOfWeek();

            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                total += hotel.getWeekendRate();
            else
                total += hotel.getWeekdayRate();

            date = date.plusDays(1);
        }
        return total;
    }
}
