package com.travel.agency.system;

import com.travel.agency.system.AgencyModel.*;
import com.travel.agency.system.CommonUtils.DuplicateActivityChecker;
import com.travel.agency.system.enums.PassengerType;
import com.travel.agency.system.exceptions.TravelAgencyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import static com.travel.agency.system.utils.TravelAgencyConstants.*;

@Slf4j
@SpringBootApplication
public class TravelAgencyManagementSystemApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws TravelAgencyException  {



		// Example usage
		// Creating destinations in India
		Destination indiaDestination1 = new Destination(DESTINATION_AGRA);
		indiaDestination1.addActivity(new Activity(ACTIVITY_TAJ_MAHAL_TOUR, ACTIVITY_TAJ_MAHAL_TOUR_DESCRIPTION, 40.0, 45, indiaDestination1));
		indiaDestination1.addActivity(new Activity(ACTIVITY_AGRA_FORT_EXPLORATION, ACTIVITY_AGRA_FORT_EXPLORATION_DESCRIPTION, 35.0, 30, indiaDestination1));

		Destination indiaDestination2 = new Destination(DESTINATION_DELHI);
		indiaDestination2.addActivity(new Activity(ACTIVITY_RED_FORT_VISIT, ACTIVITY_RED_FORT_VISIT_DESCRIPTION, 30.0, 40, indiaDestination2));
		indiaDestination2.addActivity(new Activity(ACTIVITY_INDIA_GATE_SIGHTSEEING, ACTIVITY_INDIA_GATE_SIGHTSEEING_DESCRIPTION, 25.0, 20, indiaDestination2));

		// Creating a travel package for India
		TravelPackage indiaTour = new TravelPackage(TRAVEL_PACKAGE_INDIA_TOUR, 120);
		indiaTour.addDestination(indiaDestination1);
		indiaTour.addDestination(indiaDestination2);

		List<List<Activity>> check = new ArrayList<>();
		// Adding activities of India destinations to the check list
		check.add(indiaDestination1.getActivities());
		check.add(indiaDestination2.getActivities());

		try {
			// Checking for duplicate activities
			DuplicateActivityChecker.checkForDuplicateActivities(check);


		// Creating passengers for the India tour
		Passenger rahul = new Passenger(PASSENGER_RAHUL, 101, PassengerType.STANDARD, 100.0);
		Passenger shubham = new Passenger(PASSENGER_SHUBHAM, 102, PassengerType.GOLD, 100.0);
		Passenger ankur = new Passenger(PASSENGER_ANKUR, 103, PassengerType.PREMIUM);

		// Adding passengers to the India tour
		indiaTour.addPassenger(rahul);
		indiaTour.addPassenger(shubham);
		indiaTour.addPassenger(ankur);

		// Printing Itinerary of the India travel package
		PrinterClass.printItinerary(indiaTour);

		// Signing up passengers for specific activities
		rahul.signUpForActivity(rahul,indiaDestination1.getActivities().get(0));
		shubham.signUpForActivity(shubham,indiaDestination2.getActivities().get(1));
		ankur.signUpForActivity(ankur,indiaDestination2.getActivities().get(1));

		System.out.println();
		// Printing passenger list
		PrinterClass.printPassengerList(indiaTour);

		System.out.println();
		// Printing Passenger Activity Details
		PrinterClass.printPassengerActivityDetails(indiaTour);

		System.out.println();
		// Printing details of all available activities
		PrinterClass.printAvailableActivities(indiaTour);

		} catch (TravelAgencyException e) {
			log.error("Exception occurred: {}",e.getMessage());
		}

	}
}
