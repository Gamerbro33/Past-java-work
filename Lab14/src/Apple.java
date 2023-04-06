//RJ Allen
public class Apple {
	private String type;
	private double weight;
	private double price;
	
	public Apple()
	{
		this.type = "Gala";
		this.weight = 0.5;
		this.price = 0.88;
	}
	//accessors
	//getter method for types
	public String getType()
	{
		return this.type;
	}
	
	//getter method for weight
	public double getWeight()
	{
		return this.weight;
	}
	//getter method for price
	public double getPrice()
	{
		return this.price;
	}
	//mutators
	public void setType(String xType)
	{
		if(xType.equalsIgnoreCase("Red Delicious") 
				||xType.equalsIgnoreCase("Golden Delicious")
				||xType.equalsIgnoreCase("Gala")
				||xType.equalsIgnoreCase("Granny Smith"))
		{
			this.type = xType;
		}
		else
		{
			System.out.println("Invalid type entered!");
			this.type = "Gala";
		}
	}
	
	public void setWeight(double xWeight)
	{
		if(xWeight > 0 && xWeight < 2)
		{
			this.weight = xWeight;
		}
		else
		{
			System.out.println("Invalid value for weight!");
			this.weight = 0.5;
		}
	}
	public void setPrice(double xPrice)
	{
		if(xPrice > 0)
		{
			this.price = xPrice;
		}
		else
		{
			System.out.println("invalid value for the price");
			this.price = 0.88;
		}
	}
	
	public void writeOutput()
	{
		
		
		System.out.println("Type: "+this.type
				+ "\nWeight: "+this.weight+" kg"
				+"\nPrice: $"+this.price);
		
	}
}
