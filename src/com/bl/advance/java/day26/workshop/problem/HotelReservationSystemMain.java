package com.bl.advance.java.day26.workshop.problem;

public class HotelReservationSystemMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservationSystem reservationSystem = new HotelReservationSystem();
        reservationSystem.addHotels(new Hotel("ABC", 110, 90, 2));
        reservationSystem.addHotels(new Hotel("DEF", 160, 60, 3));
        reservationSystem.addHotels(new Hotel("GHC", 250, 150, 5));

        reservationSystem.showHotels();

        Hotel hotel = reservationSystem.findCheapestBestRatedHotel("10Mar2025", "11Mar2025");
        int totalCost = reservationSystem.calculateTotalCost(hotel, "10Mar2025", "11Mar2025");
        System.out.println("Cheapest hotel is: " + hotel.getHotelName() + " and rating is: " + hotel.getRating() + " the cost is: " + totalCost);
    }
}
