
public class Product 
{
	//instance variables
	private String name;
	private double price;
	private int quantity;
	
	//default constructor
	public Product()
	{
		this.name = "no name yet";
		this.price = 0.0;
		this.quantity = 0;
		
	}
	
	//parameterized constructor
	public Product(String xName, double xPrice, int xQuantity)
	{
		this.setName(xName);
		this.setPrice(xPrice);
		this.setQuantity(xQuantity);
	}
	
	public Product(double xPrice, String xName, int xQuantity)
	{
		this.setPrice(xPrice);
		this.setName(xName);
		this.setQuantity(xQuantity);
	}
	
	//copy constuctor
	public Product(Product p)
	{
		this.setName(p.getName());
		this.setPrice(p.getPrice());
		this.setQuantity(p.getQuantity());
	}
	//accessors
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	//mutators
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
			System.out.println("invalid value for price!");
		}
	}
	
	public void setQuantity(int xQuantity)
	{
		if(xQuantity >= 1)
		{
			this.quantity = xQuantity;
		}
		else
		{
			System.out.println("Invalid value for quantity!");
		}
	}
	
	public String toString()
	{
		return "Product name:"+this.name
				+"\nPrice:$"+this.price
				+"\nQuantity:"+this.quantity;
	}
	
	public boolean equals(Product p)
	{
		return this.name.equalsIgnoreCase(p.getName()) 
				&& this.price == p.getPrice()
				&& this.quantity == p.getQuantity();
	}
	
	//method overloading - same method signature but different parameters/args
	
	public double totalCost()
	{
		return this.price * this.quantity;
	}
	
	public double totalCost(double xPrice)
	{
		if(xPrice > 0)
		{
			return xPrice * this.quantity;
		}
		else {
			return 0;
		}
		
	}
	
	public double totalCost(double xPrice, int xQuantity)
	{
		if(xPrice > 0 && xQuantity > 0)
		{
			return xPrice * xQuantity;
		}
		else {
			return 0;
		}
		
	}
}
