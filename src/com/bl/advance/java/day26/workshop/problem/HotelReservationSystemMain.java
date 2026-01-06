package com.bl.advance.java.day26.workshop.problem;

public class HotelReservationSystemMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservationSystem reservationSystem = new HotelReservationSystem();
        reservationSystem.addHotels(new Hotel("ABC", 110, 90));
        reservationSystem.addHotels(new Hotel("DEF", 160, 60));
        reservationSystem.addHotels(new Hotel("GHC", 250, 150));

        reservationSystem.showHotels();

    }
}
