package travelpacks.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import passenger.Category;
import passenger.Passenger;
import travelpacks.Activity;
import travelpacks.Destination;
import travelpacks.TravelPackage;

class TestCaseForTravelPackage {

	TravelPackage pack;

	@BeforeEach
	void setUp() throws Exception {
		
		Destination d1;
		Destination d2;

		List<Activity> LS1 = new ArrayList<Activity>();				//creating Activity list
		List<Activity> LS2 = new ArrayList<Activity>();
		LS1.add(new Activity("Ropeway", "Ahmedabad", "Describe Ropeway", 150, 3));
		LS1.add(new Activity("Skiing", "Ahmedabad", "Describe Skiing", 100, 2));
		d1 = new Destination("Ahmedabad", LS1);						//creating a new destination
		
		LS2.add(new Activity("Horse Riding", "Mumbai", "Describe Horse Riding", 250, 4));
		LS2.add(new Activity("Ice Skating", "Mumbai", "Describe Ice Skating", 250, 1));
		d2 = new Destination("Mumbai", LS2);						//adding another destination
;
		List<Destination> itinerary = new ArrayList<>();			//Creating itinerary of Destinations
		itinerary.add(d1);
		itinerary.add(d2);
		
		List<Passenger> passList = new ArrayList<>();
		Passenger p1 = new Passenger("Mahesh", 301, new Category("Standard"), 4000, LS1);
		Passenger p2 = new Passenger("Mukesh", 302, new Category("Gold"), 2000, LS1);
		passList.add(p1);
		passList.add(p2);											//adding passengers to list
		pack = new TravelPackage("West", 5, itinerary, passList);
	}

	@Test
	void testGetPackageName() {
		String str = "West";
		assertEquals(str, pack.getPackageName());
	}
}
