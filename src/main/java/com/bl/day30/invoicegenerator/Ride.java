package com.bl.day30.invoicegenerator;

public class Ride {
    public double distance;
    public int time;
    public RideType rideType;

    public Ride(RideType rideType, double distance, int time) {
        this.rideType = rideType;
        this.distance = distance;
        this.time = time;
    }
}
