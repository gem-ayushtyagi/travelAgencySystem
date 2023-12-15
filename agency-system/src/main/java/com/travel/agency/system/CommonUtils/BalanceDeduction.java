package com.travel.agency.system.CommonUtils;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.AgencyModel.Passenger;

public interface BalanceDeduction {
    boolean deductBalance(Passenger passenger, Activity activity);
    boolean canSignUpForActivity(Passenger passenger,Activity activity);

}
