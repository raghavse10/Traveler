package main;

import java.util.*;

import passenger.Category;
import passenger.Passenger;
import travelpacks.Activity;
import travelpacks.Destination;
import travelpacks.TravelPackage;

public class Driver{

	//populating all data when Main() runs
	private static HashMap<String, TravelPackage> travelPackages = new HashMap<>();
	private static HashMap<String, Destination> destinations = new HashMap<>();
	private static HashMap<String, Activity> activities = new HashMap<>();
	private static HashMap<Integer, Passenger> passengers = new HashMap<>();

	private static void populateDestinations() {
		
		List<Activity> act = new ArrayList<>();
		
		//Destination 1
		destinations.put("Manali", new Destination("Manali"));
		act.clear();
		
		//Destination 2
		destinations.put("Shimla", new Destination("Shimla"));
		act.clear();
		
		//Destination 3
		destinations.put("Nainital", new Destination("Nainital"));
		act.clear();
		
		//Destination 4
		destinations.put("Rishikesh", new Destination("Rishikesh"));
		act.clear();
		
		//Destination 5
		destinations.put("LehLadakh", new Destination("Leh Ladakh"));
		act.clear();
	}

	private static void populateActivities() {
	
		Activity act;
		
		//Activity 1
		act = new Activity("Ropeway", "Manali", "Describe Ropeway", 150, 3);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 2
		act = new Activity("Skiing", "Manali", "Describe Skiing", 100, 2);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 3
		act = new Activity("HorseRiding", "Shimla", "Describe Horse Riding", 250, 4);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 4
		act = new Activity("IceSkating", "Shimla", "Describe Ice Skating", 250, 1);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 5
		act = new Activity("Boating", "Nainital", "Describe Boating", 50, 2);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 6
		act = new Activity("RiverRafting", "Rishikesh", "Describe River Rafting", 150, 3);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 7
		act = new Activity("Camping", "Rishikesh", "Describe Camping", 450, 1);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 8
		act = new Activity("Trekking", "LehLadakh", "Describe Trekking", 350, 3);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 9
		act = new Activity("Biking", "LehLadakh", "Describe Biking", 500, 2);
		Activity.addEligibleActivity(act, activities, destinations);
		
		//Activity 10
		act = new Activity("Cycling", "LehLadakh", "Describe Cycling", 400, 5);
		Activity.addEligibleActivity(act, activities, destinations);
	}

	private static void populatePassengers() {
		
		List<Activity> act = new ArrayList<>();
		Passenger p;
		
		//Passenger 1
		act.add(activities.get("Ropeway"));
		act.add(activities.get("Skiing"));
		p = new Passenger("Ramesh", 101, new Category("Standard"), 500, act);
		Passenger.addEligiblePassenger(p, passengers);
		act.clear();
		
		//Passenger 2
		act.add(activities.get("Boating"));
		act.add(activities.get("Camping"));
		p = new Passenger("Suresh", 102, new Category("Gold"), 700, act);
		Passenger.addEligiblePassenger(p, passengers);
		act.clear();
		
		//Passenger 3
		act.add(activities.get("Trekking"));
		act.add(activities.get("Biking"));
		p = new Passenger("Mahesh", 103, new Category("Gold"), 900, act);
		Passenger.addEligiblePassenger(p, passengers);
		act.clear();
		
		//Passenger 4
		act.add(activities.get("Trekking"));
		p = new Passenger("Mukesh", 104, new Category("Premium"), 1000, act);
		Passenger.addEligiblePassenger(p, passengers);
		act.clear();
		
		//Passenger 5
		act.add(activities.get("Skiing"));
		act.add(activities.get("Ropeway"));
		act.add(activities.get("IceSkating"));
		p = new Passenger("Rajiv", 105, new Category("Premium"), 1200, act);
		Passenger.addEligiblePassenger(p, passengers);
		act.clear();
	}
	
	private static void populatePackages() {
		List<Destination> itin = new ArrayList<>();
		List<Passenger> pass = new ArrayList<>();
		
		//Package 1
		itin.add(destinations.get("Manali"));
		itin.add(destinations.get("Shimla"));
		pass.add(passengers.get(101));
		pass.add(passengers.get(105));
		travelPackages.put("Himachal", new TravelPackage("Himachal", 10, itin, pass));
		itin.clear();
		pass.clear();

		//Package 2
		itin.add(destinations.get("Nainital"));
		itin.add(destinations.get("Rishikesh"));
		pass.add(passengers.get(102));
		travelPackages.put("Uttarakhand", new TravelPackage("Uttarakhand", 20, itin, pass));
		itin.clear();
		pass.clear();

		//Package 3
		itin.add(destinations.get("LehLadakh"));
		pass.add(passengers.get(103));
		pass.add(passengers.get(104));
		travelPackages.put("LehLadakh", new TravelPackage("Leh Ladakh", 5, itin, pass));
		itin.clear();
		pass.clear();

		return;
	}
		
	public static void main(String[] args) {
		
		System.out.println("Populating Destinations...");
		populateDestinations();
		System.out.println("Populating Activities...");
		populateActivities();
		System.out.println("Populating Passengers...");
		populatePassengers();
		System.out.println("Populating Travel Packages...\n");
		populatePackages();

		System.out.println("Welcome to traveler.\n");
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		//running the application till user Exits.
		while(input != 5)
		{
			System.out.println("\nChoose from the following options:\n");
			System.out.println("1. Print itinerary of a travel package.");
			System.out.println("2. Print the passenger list of a travel package.");
			System.out.println("3. Print the details of an individual passenger.");
			System.out.println("4. Print all activities that still have spaces available.");
			System.out.println("5. Exit\n");
			input = sc.nextInt();
			
			//Combining since both input = 1 and input = 2 require display of packages and choosing
			if(input == 1 || input == 2)
			{
				HashMap<String, TravelPackage> TP = new HashMap<>(travelPackages);
				System.out.println("The following Packages are there:\n");
				for (Map.Entry <String, TravelPackage> entry : TP.entrySet())
				{
					System.out.print(entry.getValue().getPackageName()+ "; ");	//Printing all packages
				}
				System.out.println("\n\nEnter the key for the package: ");
				String packageKey = sc.next();
				TravelPackage tp = TP.get(packageKey);
				if(!travelPackages.containsKey(packageKey))		//checking if package exists or not
				{
					System.out.println("Travel Package doesn't exist.");
					continue;
				}
				if(input == 1)
				{
					tp.printItinerary();
				}
				if(input == 2)
				{
					tp.printPassList();
				}
			}
			
			else if(input == 3)
			{
				HashMap<Integer, Passenger> PASS = new HashMap<>(passengers);
				System.out.println("The following passengers are there:\n");
				for (Map.Entry <Integer, Passenger> entry : PASS.entrySet())
				{
					System.out.print(entry.getValue().getCode()+ "; ");
				}
				System.out.println("\n\nEnter Passenger code: ");
				int passengerCode = sc.nextInt();
				Passenger p = PASS.get(passengerCode);
				if(passengers.containsKey(passengerCode))		//checking if passenger exists or not
					p.printPassenger();
				else
					System.out.println("Passenger doesn't exist.");
			}
			
			else if(input == 4)
			{
				TravelPackage tp;
				for(Map.Entry<String, TravelPackage> entry : travelPackages.entrySet())
				{
					tp = entry.getValue();
					tp.printEmptySpaces();
					System.out.println("\n");
				}
			}
		}
		sc.close();
		System.out.println("\nThanks for using Traveler.");		//Exiting
		return;
	}
		
}
