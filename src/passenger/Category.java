package passenger;

public class Category {

	private String name;
	private double discountIndex;	//discount when a Gold or Premium member purchases an activity
	private double categoryPrice;	//adding a subscription charge for being a Gold or Premium member

	//the categoryIndex and categoryPrice are adjustable if they change in future(not hard coded)
	
	//Constructor to create a category for a new passenger
	public Category(String name) {
		
		if (name.equals("Gold"))
		{
			this.name = name;
			discountIndex = 0.9;
			categoryPrice = 100.0;
		}
		else if (name.equals("Premium"))
		{
			this.name = name;
			discountIndex = 0.0;
			categoryPrice = 200.0;
		}
		else
		{
			this.name = "Standard";
			discountIndex = 1.0;
			categoryPrice = 0.0;
		}
	}

	public String getName() {
			return name;
	}

	public double getDiscountIndex() {
		return discountIndex;
	}
	
	public double getCategoryPrice() {
		return categoryPrice;
	}
}
