package passenger;

import java.util.*;

import travelpacks.Activity;

public class Passenger {

	private String name;
	private int code;
	private Category category;
	private double balance;

	private List<Activity> passengerActivities;

	public Passenger(String name, int code, Category category, double balance, List<Activity> passengerActivities) {

		this.name = name;
		this.code = code;
		this.category = category;
		if(balance >= 0)
			this.balance = balance;
		else
			balance = 0;
		List<Activity> LS = new ArrayList<>(passengerActivities);
		this.passengerActivities = LS;
	}

	@Override
	public String toString() {
		String str;
		str = "Passenger Name: " + name + " & Passenger Code: " + code;
		return str;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void updateBalance(double newBalance) {
		balance = newBalance;
	}
	
	public List<Activity> getPassengerActivities() {
		return passengerActivities;
	}
	
	public Category getPassengerCategory() {
		return category;
	}
	
	public void printPassenger() {
		System.out.println("Passenger Name: " + name);
		System.out.println("Passenger Code: " + code);
		String categoryName = category.getName();
		System.out.println("Passenger Category: " + categoryName);
		double index = category.getDiscountIndex();

		if (categoryName.equals("Standard") || categoryName.equals("Gold")) {
			System.out.println("Balance: " + balance);
		}

		System.out.println("\nAll Activities signed up: ");

		for (int i = 0; i < passengerActivities.size(); i++) {
			System.out.println("\n");
			Activity activity = passengerActivities.get(i);

			System.out.println("Activity: " + activity.getActName());
			System.out.println("Destination: " + activity.getDestKey());

			if (categoryName.equals("Standard")) {
				double cost = index * activity.getCost();
				System.out.println("Price paid: Rs. " + cost);
			} else if (categoryName.equals("Gold")) {
				double cost = index * activity.getCost();
				System.out.println("Price paid: Rs. " + cost);
			} else if (categoryName.equals("Premium")) {
				double cost = index * activity.getCost();
				System.out.println("Price paid: Rs. " + cost);
			}
		}
	}
	
	public static void addEligiblePassenger(Passenger p, HashMap<Integer, Passenger> passengers) {
		
		double sum = 0.0, balance = p.getBalance();
		List<Activity> act = p.getPassengerActivities();
		
		Category cat = p.getPassengerCategory();
		
		for(int i = 0; i < act.size(); i++)
		{
			sum += act.get(i).getCost();
		}
		sum *= cat.getDiscountIndex();
		balance -= sum;
		balance -= cat.getCategoryPrice();
		if(balance >= 0)
		{
			p.updateBalance(balance);
			for(int i = 0; i < act.size(); i++)
			{
				act.get(i).increasePassengerCount();
			}
			passengers.put(p.getCode(), p);
		}
		else if(balance < 0)
		{
			System.out.println("Insufficient Balance for passenger: " + p.getCode());
		}
	}

}