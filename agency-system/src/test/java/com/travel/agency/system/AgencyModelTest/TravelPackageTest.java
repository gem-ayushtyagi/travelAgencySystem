package com.travel.agency.system.AgencyModelTest;

import com.travel.agency.system.AgencyModel.Destination;
import com.travel.agency.system.AgencyModel.Passenger;
import com.travel.agency.system.AgencyModel.TravelPackage;
import com.travel.agency.system.enums.PassengerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 50);
        Destination destination = new Destination("TestDestination");

        // Ensure that initially, the travel package has no destinations in its itinerary
        assertEquals(0, travelPackage.getItinerary().size(), "Initial itinerary size should be 0");

        // Add the destination to the travel package
        travelPackage.addDestination(destination);

        // Ensure that after adding the destination, the travel package has one destination in its itinerary
        assertEquals(1, travelPackage.getItinerary().size(), "Itinerary size should be 1 after adding the destination");
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 50);
        Passenger passenger = new Passenger("TestPassenger", 101, PassengerType.STANDARD);

        // Ensure that initially, the travel package has no passengers
        assertEquals(0, travelPackage.getPassengers().size(), "Initial passengers size should be 0");

        // Add the passenger to the travel package
        travelPackage.addPassenger(passenger);

        // Ensure that after adding the passenger, the travel package has one passenger
        assertEquals(1, travelPackage.getPassengers().size(), "Passengers size should be 1 after adding the passenger");
    }

}

