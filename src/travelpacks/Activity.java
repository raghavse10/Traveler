package travelpacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity {

	private String actName;
	private String destKey;
	private String description;
	private int cost;
	private int capacity;

	private int passengerCount;

	public Activity(String actName, String destKey, String description, int cost, int capacity) {

		this.destKey = destKey;
		this.actName = actName;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		passengerCount = 0;
	}

	@Override
	public String toString() {
		String str;
		str = "Activity Name: " + actName + " Description: " + description + " Cost: " + Integer.toString(cost)
				+ " Capacity: " + Integer.toString(capacity);
		return str;
	}

	public int getCost() {
		return cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getActName() {
		return actName;
	}
	
	public String getDestKey() {
		return destKey;
	}
	public void increasePassengerCount() {
		if (passengerCount < capacity)
			passengerCount++;
		else
			System.out.println("Can't exceed capacity.");
	}

	public int emptySpaces() {
		return (capacity-passengerCount);
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public static void addEligibleActivity(Activity act, HashMap<String, Activity> activities, HashMap<String, Destination> destinations) {
		
		String destKey = act.getDestKey();
		if(destinations.containsKey(destKey))
		{

			activities.put(act.getActName(), act);
			Destination des = destinations.get(destKey);
			if(des.getActList() == null)
			{
				String desName = destinations.get(destKey).getName();
				destinations.remove(destKey);
				List<Activity> ls = new ArrayList<>();
				ls.add(act);
				destinations.put(destKey, new Destination(desName, ls));
			}
			else
			{
				destinations.put(destKey, des.addActivity(act));
			}
		}
		else
		{
			System.out.println("Error! Attempting to add activity without a destination.");
			return;
		}
	}
	

}
