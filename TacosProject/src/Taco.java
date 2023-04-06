
public class Taco 
{
	private String name;
	private double price;
	
	public Taco()
	{
		this.name = "none";
		this.price = 0;
	}
	
	public Taco(String xName, double xPrice)
	{
		//to do
		this.setName(xName);
		this.setPrice(xPrice);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void setName(String xName)
	{
		this.name = xName;
	}
	
	public void setPrice(double xPrice)
	{
		if(xPrice > 0)
		{
			this.price = xPrice;
		}
		else
		{
			System.out.println("Invalid value for taco price");
		}
	}
	
	public boolean equals(Taco t)
	{
		return this.name.equalsIgnoreCase(t.getName())
				&& this.price == t.getPrice();
	}
	
	public String toString()
	{
		return "Name:"+this.name+"\nPrice: $"+this.price;
	}
}
