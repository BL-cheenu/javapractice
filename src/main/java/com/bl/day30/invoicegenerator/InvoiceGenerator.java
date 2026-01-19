package com.bl.day30.invoicegenerator;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, MIN_FARE);
    }

    public InvoiceSummary calculateInvoice(Ride[] rides) {
        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }

        return new InvoiceSummary(rides.length, totalFare);
    }
}
