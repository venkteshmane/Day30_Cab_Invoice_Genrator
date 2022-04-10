package com.bridgelabz.main;

import java.util.ArrayList;

public class CabInvoiceGenerator {
    //CONSTANTS
    private int COST_PER_KM= 10;
    private int COST_PER_MINUTE = 1;
    private int MINIMUM_FARE = 5;

    RideRepository rideRepository = new RideRepository();

    public CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    public InvoiceDetails getInvoiceDetails(String userId) {
        int totalFare = 0;
        ArrayList userRides = rideRepository.getRideDetails(userId);
        Ride[] rides = new Ride[userRides.size()];
        userRides.toArray(rides);
        for (Ride ride : rides) {
            totalFare += this.getTotalFare((int) ride.distance, ride.duration, ride.rideType);
        }
        return new InvoiceDetails(rides.length, totalFare);
    }

    //METHOD TO GET TOTAL FARE FOR JOURNEY
    public double getTotalFare(int distance, int duration, RideType rideType) {
        int totalFare = 0;
            totalFare = (distance * COST_PER_KM) + (duration * COST_PER_MINUTE);
            return Math.max(MINIMUM_FARE, totalFare);
        }


    private void setValue(RideType type) {
        this.COST_PER_KM = type.costPerKM;
        this.COST_PER_MINUTE = type.costPerMinute;
        this.MINIMUM_FARE = type.minFare;
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }
}