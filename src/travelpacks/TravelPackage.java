package travelpacks;

import java.util.*;

import passenger.Passenger;

public class TravelPackage {

	private String name;
	private int passengerCapacity;
	private List<Destination> itinerary;	//List of all destinations at this package
	private List<Passenger> passList;		//List of all passengers who chose this package

	//Constructor to create Travel Package
	public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary, List<Passenger> passList) {
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		List<Destination> itin = new ArrayList<>(itinerary);
		this.itinerary = itin;
		List<Passenger> pass = new ArrayList<>(passList);
		this.passList = pass;
	}

	public String getPackageName() {
		return name;
	}

	//Prints the itinerary of a package
	public void printItinerary() {

		System.out.println("Package Name: "+name);
		for (int i = 1; i <= itinerary.size(); i++) {
			System.out.println("Destination "+i+" : " +itinerary.get(i-1).getName());
			System.out.println(itinerary.get(i-1).getActList());
		}
	}
	//Prints the passengers who chose this package
	public void printPassList() {

		System.out.println("Package Name: " + name);
		System.out.println("Passenger capacity: " + passengerCapacity);
		System.out.println("Passengers currently enrolled: " + passList.size());
		System.out.println(passList);
	}
	
	//Prints the empty spaces of all activities at all destinations in this package
	public void printEmptySpaces() {
		for (int i = 0; i < itinerary.size(); i++) {
			Destination destination = itinerary.get(i);
			System.out.println("Destination: " + destination.getName());
			List<Activity> activityList = destination.getActList();
			for (int j = 0; j < activityList.size(); j++) {
				Activity act = activityList.get(j);
				System.out.println("Activity " + act.getActName() + " has " + act.emptySpaces() + " seats free.");
			}
		}
	}
}
