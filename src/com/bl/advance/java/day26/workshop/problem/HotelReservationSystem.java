package com.bl.advance.java.day26.workshop.problem;

import java.util.ArrayList;
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
}
