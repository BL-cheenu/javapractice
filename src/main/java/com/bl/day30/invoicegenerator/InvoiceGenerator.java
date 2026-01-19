package com.bl.day30.invoicegenerator;

public class InvoiceGenerator {

    public double calculateFare(Ride ride) {
        double fare = 0;

        if (ride.rideType == RideType.NORMAL) {
            fare = ride.distance * 10 + ride.time * 1;
            return Math.max(fare, 5);
        } else {
            fare = ride.distance * 15 + ride.time * 2;
            return Math.max(fare, 20);
        }
    }

    public InvoiceSummary calculateInvoice(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
