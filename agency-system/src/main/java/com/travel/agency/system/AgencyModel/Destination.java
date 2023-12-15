package com.travel.agency.system.AgencyModel;

import lombok.Getter;

import java.util.*;

@Getter
public class Destination {

    private final String name;
    private final List<Activity> activities;
    private final List<Passenger> passengers;
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * To add an activity to the destination
     *
     * @param activity The activity to be added.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

}