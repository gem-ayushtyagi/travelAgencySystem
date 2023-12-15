package com.travel.agency.system.AgencyModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Setter
@Getter
@AllArgsConstructor
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;


    /**
     * Checks if there is available space for passengers in the activity.
     *
     * @return true if there is available space, false otherwise.
     */
    public boolean hasSpace() {
        return capacity > destination.getPassengers().size();
    }
}

