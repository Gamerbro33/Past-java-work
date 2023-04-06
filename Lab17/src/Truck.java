//RJ Allen
public class Truck  extends Vehicle 
{
	private double loadCap;
	private double towingCap;
	
	//default constructor
	public Truck()
	{
		super(); //calls the parent's default constructor
		this.loadCap = 0.0;
		this.towingCap = 0.0;
	}
	
	public Truck(String xManName, int xCylinder, String xOwner, double xLoadCap, double xTowCap)
	{
		super(xManName, xCylinder, xOwner);
		this.setLoadCapacity(xLoadCap);
		this.setTowingCapacity(xTowCap);
	}
	
	//accessors
	public double getLoadCapacity()
	{
		return this.loadCap;
	}
	public double getTowingCapacity()
	{
		return this.towingCap;
	}
	
	//mutator
	public void setTowingCapacity(double xTowCap) {
		// TODO Auto-generated method stub
		if(xTowCap >= 0)
		{
			this.towingCap = xTowCap;
		}
		else
		{
			System.out.println("invalid input for towing capacity");
		}
	}

	public void setLoadCapacity(double xLoadCap) {
		// TODO Auto-generated method stub
		if(xLoadCap >= 0)
		{
			this.loadCap = xLoadCap;
		}
		else
		{
			System.out.println("invalid input for loading capacity");
		}
	}
	
	public boolean equals(Truck t)
	{
		return super.equals(t) && this.loadCap == t.getLoadCapacity() && this.towingCap == t.getTowingCapacity();
		
	}
	public String toString()
	{
		return ""+super.toString()+
				"\nLoading Capacity: "+this.loadCap+
				"\nTowing Capacity: "+this.towingCap;
	}
}
