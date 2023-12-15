package com.travel.agency.system.AgencyModelTest;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Destination;
import com.travel.agency.system.AgencyModel.Passenger;
import com.travel.agency.system.CommonUtils.DefaultBalanceDeduction;
import com.travel.agency.system.enums.PassengerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultBalanceDeductionTest {

    @Test
    void testDeductBalance() {
        DefaultBalanceDeduction balanceDeduction = new DefaultBalanceDeduction();
        Passenger passenger = new Passenger("TestPassenger", 1, PassengerType.STANDARD, 200.0);
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 100.0, 5, destination);


        // Ensure that the balance deduction is successful
        assertTrue(balanceDeduction.deductBalance(passenger, activity));

        // Ensure that the passenger's balance is updated correctly after the deduction
        assertEquals(100.0, passenger.getBalance(), "Balance should be deducted");
    }

    @Test
    void testCanSignUpForActivity() {
        DefaultBalanceDeduction balanceDeduction = new DefaultBalanceDeduction();
        Passenger passenger = new Passenger("TestPassenger", 1, PassengerType.STANDARD, 150.0);
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 100.0, 5, destination);

        // Ensure that the standard passenger can sign up for the activity
        assertTrue(balanceDeduction.canSignUpForActivity(passenger, activity), "Passenger should be able to sign up");

        DefaultBalanceDeduction balanceDeduction1 = new DefaultBalanceDeduction();
        Passenger passenger1 = new Passenger("TestPassenger", 1, PassengerType.STANDARD, 50.0);
        Destination destination1 = new Destination("TestDestination");
        Activity activity1 = new Activity("TestActivity", "TestDescription", 100.0, 5, destination1);

        // Ensure that the second standard passenger cannot sign up for the activity due to insufficient balance
        assertFalse(balanceDeduction1.canSignUpForActivity(passenger1, activity1), "Passenger should not be able to sign up");
    }

}
