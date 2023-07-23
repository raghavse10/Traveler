package travelpacks;

import java.util.*;

import passenger.Passenger;

public class TravelPackage {

	private String name;
	private int passengerCapacity;
	private List<Destination> itinerary;
	private List<Passenger> passList;

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

	public void printItinerary() {

		System.out.println("Package Name: "+name);
		for (int i = 1; i <= itinerary.size(); i++) {
			System.out.println("Destination "+i+" : " +itinerary.get(i-1).getName());
			System.out.println(itinerary.get(i-1).getActList());
		}
	}

	public void printPassList() {

		System.out.println("Package Name: " + name);
		System.out.println("Passenger capacity: " + passengerCapacity);
		System.out.println("Passengers currently enrolled: " + passList.size());
		System.out.println(passList);
	}

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
