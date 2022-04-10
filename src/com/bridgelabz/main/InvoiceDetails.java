package com.bridgelabz.main;

public class InvoiceDetails {
    public int totalRides;
    public int totalFare;
    public double aggregateFarePerRide;

    public InvoiceDetails(int totalRides, int totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.aggregateFarePerRide = totalFare / totalRides;
    }

    public int getTotalRides() {
        return  totalRides;
    }
    public int getTotalFare() {
        return totalFare;
    }
    public double getAggregateFarePerRide() {
        return aggregateFarePerRide;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        InvoiceDetails that = (InvoiceDetails) o;
//        return Double.compare(that.numberOfRides, numberOfRides) == 0 &&
//                Double.compare(that.totalFare, totalFare) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(numberOfRides, totalFare);
//    }
//
}