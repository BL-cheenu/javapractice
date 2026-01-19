package com.bl.day30.invoicegenerator;

public class InvoiceSummary {
    public int totalRides;
    public double totalFare;
    public double averageFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / totalRides;
    }

    @Override
    public String toString() {
        return "Invoice Summary {" +
                "Total Rides = " + totalRides +
                ", Total Fare = " + totalFare +
                ", Average Fare = " + averageFare +
                '}';
    }
}
