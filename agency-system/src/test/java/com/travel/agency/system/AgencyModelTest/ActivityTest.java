package com.travel.agency.system.AgencyModelTest;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Destination;
import com.travel.agency.system.AgencyModel.Passenger;
import com.travel.agency.system.enums.PassengerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    @Test
    public void testHasSpace() {

        // Create an instance of destination and an activity
        Destination destination = new Destination("TestDestination");
        Activity activityWithSpace = new Activity("TestActivity", "Description", 50.0, 10, destination);

        // Create an instance of passenger and add it to the destination
        Passenger passenger1 = new Passenger("Passenger", 1, PassengerType.STANDARD);
        destination.getPassengers().add(passenger1);

        // Ensure that the activity has available space
        assertTrue(activityWithSpace.hasSpace(),"Activity should have space for passengers");

        // Create another activity with limited space
        Activity activityWithOutSpace = new Activity("TestActivity1", "Description1", 50.0, 5, destination);

        // Add passengers to fill up the activity
        for (int i = 0; i < 5; i++) {
            Passenger passenger = new Passenger("Passenger" + i, i, PassengerType.STANDARD);
            destination.getPassengers().add(passenger);
        }

        // Ensure that the activity is full and has no available space
        assertFalse(activityWithOutSpace.hasSpace(), "Activity should be full");


    }
}
