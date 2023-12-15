package com.travel.agency.system.AgencyModel;

import com.travel.agency.system.CommonUtils.DefaultBalanceDeduction;
import com.travel.agency.system.enums.PassengerType;
import com.travel.agency.system.exceptions.TravelAgencyException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static com.travel.agency.system.utils.TravelAgencyConstants.*;

@Slf4j
@Setter
@Getter
public class Passenger {
    private final String name;
    private final int passengerNumber;
    private double balance;
    private final PassengerType type;
    private final List<Activity> activities;
    private DefaultBalanceDeduction defaultBalanceDeduction = new DefaultBalanceDeduction();;


    // Constructor for passengers without balance
    public Passenger(String name, int passengerNumber, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.activities = new ArrayList<>();
    }

    // Constructor for passengers with balance
    public Passenger(String name, int passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.activities = new ArrayList<>();
        this.balance = balance;
    }


    /**
     * Signs up the passenger for a specific activity.
     * Updates the activity's capacity, adds the activity to the passenger's list, and adds the passenger to the activity's destination.
     *
     * @param passenger The passenger who wants to sign up for the activity.
     * @param activity  The activity the passenger wants to sign up for.
     * @throws TravelAgencyException If the passenger is unable to sign up for the activity.
     */
    public void signUpForActivity(Passenger passenger,Activity activity) {
        if (defaultBalanceDeduction.canSignUpForActivity(passenger,activity)) {
            int updatedCapacity = activity.getCapacity() - 1;
            activity.setCapacity(updatedCapacity);
            activities.add(activity);
            activity.getDestination().getPassengers().add(passenger);
        } else {
            throw new TravelAgencyException(String.format(ERROR_SIGN_UP_ACTIVITY, activity.getName()));
        }
    }

}

