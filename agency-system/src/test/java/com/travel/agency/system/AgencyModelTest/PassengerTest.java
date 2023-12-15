package com.travel.agency.system.AgencyModelTest;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Destination;
import com.travel.agency.system.AgencyModel.Passenger;
import com.travel.agency.system.CommonUtils.DefaultBalanceDeduction;
import com.travel.agency.system.enums.PassengerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testSignUpForActivity() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 30, destination);
        Passenger passenger = new Passenger("TestPassenger", 101, PassengerType.PREMIUM);

        // Ensure that initially, the passenger has no signed-up activities
        assertTrue(passenger.getActivities().isEmpty(), "Passenger should not have any signed-up activities initially");

        // Sign up the passenger for the activity
        passenger.signUpForActivity(passenger, activity);

        // Ensure that after signing up, the passenger has a signed-up activity
        assertFalse(passenger.getActivities().isEmpty(), "Passenger should have a signed-up activity after sign-up");

        // Check if the passenger is added to the activity's destination
        assertTrue(activity.getDestination().getPassengers().contains(passenger), "Passenger should be added to the activity's destination");
    }
}
