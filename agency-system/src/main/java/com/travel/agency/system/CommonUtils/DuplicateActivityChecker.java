package com.travel.agency.system.CommonUtils;

import com.travel.agency.system.AgencyModel.Activity;
import com.travel.agency.system.exceptions.TravelAgencyException;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import static com.travel.agency.system.utils.TravelAgencyConstants.ERROR_DUPLICATE_ACTIVITY;

@Slf4j
public class DuplicateActivityChecker {

    /**
     * Checks for duplicate activities across different destinations and prints an error message if duplicates are found.
     *
     * @param check A list of lists containing activities for different destinations.
     * @throws TravelAgencyException If duplicate activities are found across different destinations.
     */
    public static void checkForDuplicateActivities(List<List<Activity>> check) {
        List<String> activityNames = new ArrayList<>();
        check.forEach(activities -> activities.forEach(activity -> {
            if (activityNames.contains(activity.getName())) {
                log.error("Error: Activity '{}' is already associated with Different destination.", activity.getName());
                throw new TravelAgencyException(String.format(ERROR_DUPLICATE_ACTIVITY, activity.getName()));
            }
            activityNames.add(activity.getName());
        }));
    }
}
