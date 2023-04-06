
public class Concert {
	//instance variable
	private String name;
	private int capacity;
	private int numPhone;
	private int numVenue;
	private double pricePhone;
	private double priceVenue;
	
	public Concert()
	{
		this.name = "no name yet";
		this.capacity = 0;
		this.numPhone = 0;
		this.numVenue = 0;
		this.pricePhone = 0.0;
		this.priceVenue = 0.0;
	}
	public Concert(String xName, int xCapacity, double xPhPrice, double xVnPrice)
	{
		this.setBandName(xName);
		this.setCapacity(xCapacity);
		this.setPriceByPhone(xPhPrice);
		this.setPriceAtVenue(xVnPrice);
	}
	public Concert(String xName, int xCapacity, int xNumPhone, int xNumVenue,double xPhPrice, double xVnPrice)
	{
		this.setBandName(xName);
		this.setCapacity(xCapacity);
		this.setNumTicketSoldbyPhone(xNumPhone);
		this.setNumTicketSoldAtVenue(xNumVenue);
		this.setPriceByPhone(xPhPrice);
		this.setPriceAtVenue(xVnPrice);
	}
	//accessors
	public String getBandName()
	{
		return this.name;
	}
	public int getCapcity()
	{
		return this.capacity;
	}
	
	public int getNumTicketsSoldByPhone()
	{
		return this.numPhone;
	}
	public int getNumTicketsSoldAtVenue()
	{
		return this.numVenue;
	}
	
	public double getPriceAtVenue()
	{
		return this.priceVenue;
	}
	public double getPriceByPhone()
	{
		return this.pricePhone;
	}
	//mutator
	public void setCapacity(int xCapacity) {
		// TODO Auto-generated method stub
		if(xCapacity > 0)
		{
			this.capacity = xCapacity;
		}
		else
		{
			System.out.println("Invalid input of capacity");
		}
	}
	public void setNumTicketSoldAtVenue(int xVenue) {
		// TODO Auto-generated method stub
		if(xVenue > 0)
		{
			this.numVenue = xVenue;
		}
		else
		{
			System.out.println("Invalid input of tickets");
		}
	}
	public void setNumTicketSoldbyPhone(int xPhone) {
		// TODO Auto-generated method stub
		if(xPhone > 0)
		{
			this.numPhone = xPhone;
		}
		else
		{
			System.out.println("Invalid input of tickets");
		}
	}
	public void setBandName(String xName) {
		// TODO Auto-generated method stub
		this.name = xName;
	}
	public void setPriceAtVenue(double xVnPrice) {
		// TODO Auto-generated method stub
		if(xVnPrice > 0)
		{
			this.priceVenue = xVnPrice;
		}
		else
		{
			System.out.println("Invalid input of Venue Price");
		}
	}
	public void setPriceByPhone(double xPhPrice) {
		// TODO Auto-generated method stub
		if(xPhPrice > 0)
		{
			this.pricePhone = xPhPrice;
		}
		else
		{
			System.out.println("Invalid input of Phone Price");
		}
	}
	
	public double totalSales()
	{
		return (this.numPhone * this.pricePhone) +(this.numVenue*this.priceVenue);
	}
	
	public int ticketsRemaining()
	{
		return this.capacity-(numPhone+numVenue);
	}
	public int totalNumberOfTicketsSold()
	{
		return this.numPhone + this.numVenue;
	}
	public void buyTicketsAtVenue(int xTicket)
	{
		this.numVenue += xTicket;
	}
	public void buyTicketsByPhone(int xTicket2)
	{
		this.numPhone += xTicket2;
	}
}
