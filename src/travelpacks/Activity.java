package travelpacks;

public class Activity {

	private String actName;
	private String destKey;
	private String description;
	private int cost;
	private int capacity;

	private int passengerCount;

	public Activity(String actName, String description, int cost, int capacity) {

		this.actName = actName;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		passengerCount = 0;
	}
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
		return capacity - passengerCount;
	}

}
