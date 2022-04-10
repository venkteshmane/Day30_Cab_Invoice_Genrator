package com.bridgelabz.main;

public enum RideType {

    NORMAL(10,1,5), PREMIUM(15,2,20);

    public final int costPerKM;
    public final int costPerMinute;
    public final int minFare;

    RideType(int costPerKilometer, int costPerMinute, int minFare) {
        this.costPerKM = costPerKilometer;
        this.costPerMinute = costPerMinute;
        this.minFare = minFare;
    }
}