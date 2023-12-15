package com.travel.agency.system.AgencyModel;

import lombok.Getter;

import java.util.*;

@Getter
public class TravelPackage {
    private final String name;
    private final int capacity;
    private final List<Destination> itinerary;
    private final List<Passenger> passengers;

    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }


    /**
     * To add a destination to the travel package's itinerary.
     *
     * @param destination The destination to be added.
     */
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }


    /**
     * To add a passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     */

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}


