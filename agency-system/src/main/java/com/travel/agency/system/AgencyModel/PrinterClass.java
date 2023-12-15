package com.travel.agency.system.AgencyModel;

import com.travel.agency.system.enums.PassengerType;

public class PrinterClass {


    /**
     * Prints the itinerary of the travel package, including activities for each destination.
     */
    public static void printItinerary(TravelPackage travelPackage) {
        System.out.println("Travel Package: " +  travelPackage.getName());
        travelPackage.getItinerary().forEach(destination -> {
            System.out.println("Destination: " + destination.getName());
            destination.getActivities().forEach(activity -> {
                System.out.println("  Activity: " + activity.getName());
                System.out.println("    Description: " + activity.getDescription());
                System.out.println("    Cost: " + activity.getCost());
                System.out.println("    Capacity: " + activity.getCapacity());
            });
        });
    }

    /**
     * Prints the list of passengers enrolled in the travel package along with their details.
     */
    public static void printPassengerList(TravelPackage travelPackage) {
        int totalPassengers = 0;
        for (Destination destination : travelPackage.getItinerary()) {
            totalPassengers += destination.getPassengers().size();
        }
        System.out.println("Travel Package: " +  travelPackage.getName());
        System.out.println("Passenger Capacity: " +  travelPackage.getCapacity());
        System.out.println("Number of Passengers Currently Enrolled: " + totalPassengers);

        travelPackage.getItinerary().forEach(destination -> destination.getPassengers().forEach(passenger -> {
            System.out.println("  Passenger Name: " + passenger.getName());
            System.out.println("  Passenger Number: " + passenger.getPassengerNumber());
        }));
    }


    /**
     * Prints detailed information about each passenger's activities in the travel package.
     */
    public static void printPassengerActivityDetails(TravelPackage travelPackage) {
        System.out.println("Individual Passengers Details for " +  travelPackage.getName());
        travelPackage.getPassengers().forEach(passenger -> {
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            System.out.println("Passenger Balance: " + passenger.getBalance());
            if (passenger.getActivities().isEmpty()) {
                System.out.println(passenger.getName() + " Not signed up for any activity");
            }
            passenger.getActivities().forEach(activity -> {
                System.out.println("Activities signed up:");
                System.out.println("  Activity: " + activity.getName());
                System.out.println("    Destination: " + activity.getDestination().getName());
                if (passenger.getType() == PassengerType.PREMIUM) {
                    System.out.println("   Price Paid: Free for premium passenger ");
                } else {
                    System.out.println("    Price Paid: " + activity.getCost());
                }
            });
        });
    }


    /**
     * Prints the available activities in the travel package, including their destinations and available spaces.
     */
    public static void printAvailableActivities(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        travelPackage.getItinerary().forEach(destination -> destination.getActivities().forEach(activity -> {
            if (activity.hasSpace()) {
                System.out.println("Available Activity: " + activity.getName() +
                        " at Destination: " + destination.getName() +
                        " (Spaces available: " + activity.getCapacity() + ")");
            }
        }));
    }


}
