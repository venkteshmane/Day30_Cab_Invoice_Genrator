package com.bridgelabz.test;

import com.bridgelabz.main.CabInvoiceGenerator;
import com.bridgelabz.main.InvoiceDetails;
import com.bridgelabz.main.Ride;
import com.bridgelabz.main.RideType;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoice = new CabInvoiceGenerator();

    // Test Case for TOTAL FARE OF JOURNEY
    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnTotalFareForJourney() {
        int time = 5;
        double distance = 2.0;
        String userId = "user";
        Ride[] rides = {new Ride(distance, time, RideType.NORMAL)};
        cabInvoice.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoice.getInvoiceDetails(userId);
        Assert.assertEquals(25, invoiceDetails.totalFare, 0);
    }
    // Test Case for MINIMUM FARE OF JOURNEY
    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnMinimumFareForJourney() {
        int time = 3;
        double distance = 0.1;
        String userId = "user";
        Ride[] rides = {new Ride(distance, time, RideType.NORMAL)};
        cabInvoice.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoice.getInvoiceDetails(userId);
        Assert.assertEquals(5, invoiceDetails.totalFare, 0);
    }

    // Test Case for NORMAL User Rides
    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFareForMultipleRides_ShouldReturnTotalFareForJourney() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 1, RideType.NORMAL)};
        cabInvoice.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoice.getInvoiceDetails(userId);
        Assert.assertEquals(30, invoiceDetails.totalFare, 0);
    }

    // Test Case for NORMAL User Rides
    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFareForMultipleRides_ShouldReturnInvoiceDetails() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 1, RideType.NORMAL)};
        cabInvoice.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoice.getInvoiceDetails(userId);
        Assert.assertEquals(30, invoiceDetails.totalFare, 0);
    }

    // Test Case for PREMIUM User Rides
    @Test
    public void givenDistanceTimeRideType_InvoiceGeneratorGenerateFareForRide_ShouldReturnInvoiceDetails() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.PREMIUM), new Ride(0.2, 5, RideType.PREMIUM)};
        cabInvoice.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoice.getInvoiceDetails(userId);
        Assert.assertEquals(65, invoiceDetails.totalFare, 0);
    }
}