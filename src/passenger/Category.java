package passenger;

public class Category {

	private String name;
	private double discountIndex;
	private double categoryPrice;

	public Category(String name) {
		this.name = name;
		if (name.equals("Standard"))
		{
			discountIndex = 1.0;
			categoryPrice = 0.0;
		}
			
		else if (name.equals("Gold"))
		{
			discountIndex = 0.9;
			categoryPrice = 100.0;
		}
		else if (name.equals("Premium"))
		{
			discountIndex = 0.0;
			categoryPrice = 200.0;
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
