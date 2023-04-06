//RJ Allen
public class Car extends Vehicle{
	//instance Variable
	private double gas;
	private int passengers;
	
	public Car()
	{
		super();
		this.gas = 0.0;
		this.passengers = 0;
	}
	
	public Car(String xManName, int xCylinder, String xOwner, double xGas, int xPassengers)
	{
		super(xManName,xCylinder, xOwner);
		this.setGas(xGas);
		this.setPassengers(xPassengers);
		
		
	}

	//accessors
	public double getGas()
	{
		return this.gas;
	}
	
	public int getPassengers()
	{
		return this.passengers;
	}
	//mutator
	public void setPassengers(int xPassengers) {
		// TODO Auto-generated method stub
		if(xPassengers >= 0)
		{
			this.passengers = xPassengers;
		}
		else
		{
			System.out.println("Invalid input for passenger");
		}
	}

	public void setGas(double xGas) {
		// TODO Auto-generated method stub
		if(xGas >= 0)
		{
			this.gas = xGas;
		}
		else
		{
			System.out.println("Invalid input for gas");
		}
	}
	public boolean equals(Car c)
	{
		return super.equals(c) && this.gas == c.getGas() && this.passengers == c.getPassengers();
		
	}
	public String toString()
	{
		return ""+super.toString()+
				"\nGas: "+this.gas+
				"\nPassengers: "+this.passengers;
	}
}
