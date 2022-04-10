package com.bridgelabz.main;

public class Ride {
    public final double distance;
    public final int duration;
    public final RideType rideType;


    public Ride(double distance, int duration, RideType rideType) {
        this.distance = distance;
        this.duration = duration;
        this.rideType = rideType;

    }
}