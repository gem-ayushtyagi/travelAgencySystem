package com.travel.agency.system.AgencyModelTest;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Destination;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 30, destination);

        // Ensure that initially, the destination has no activities
        assertEquals(0, destination.getActivities().size());

        // Add activity to the destination
        destination.addActivity(activity);

        // Ensure that after adding the activity, the destination has one activity
        assertEquals(1, destination.getActivities().size());
    }

}
