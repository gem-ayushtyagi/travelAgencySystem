package com.travel.agency.system.CommonUtils;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Passenger;
import com.travel.agency.system.enums.PassengerType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultBalanceDeduction implements BalanceDeduction {

    /**
     * Deducts the required balance for the activity from the passenger's account.
     *
     * @param passenger The passenger for whom the balance needs to be deducted.
     * @param activity  The activity for which the balance needs to be deducted.
     * @return True if the balance deduction is successful; otherwise, false.
     */
    @Override
    public boolean deductBalance(Passenger passenger, Activity activity) {
        double costToPay = passenger.getType() == PassengerType.GOLD ? activity.getCost() * 0.9 : activity.getCost();
        if (passenger.getBalance() >= costToPay) {
            passenger.setBalance(passenger.getBalance() - costToPay);
            return true;
        } else {
            log.error("Error: {} has Insufficient balance for activity: {}",passenger.getName(),activity.getName());
            return false;
        }
    }


    /**
     * Checks if the passenger can sign up for a specific activity.
     * Conditions include available space in the activity and sufficient balance if the passenger is not of type PREMIUM.
     *
     * @param passenger The passenger to check for eligibility.
     * @param activity  The activity to check for eligibility.
     * @return True if the passenger can sign up; otherwise, false.
     */
    @Override
    public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
        if (!activity.hasSpace()) {
            log.error("Error: {} is unable to sign up for activity: {} as the activity is already full", passenger.getName(), activity.getName());
            return false;
        }

        return passenger.getType() == PassengerType.PREMIUM || deductBalance(passenger, activity);
    }

}
