//RJ Allen
public class Vehicle 
{
	//Instance variable
	private String manufactName;
	private int numCylinder;
	private String ownerName;
	
	//default constructor
	public Vehicle()
	{
		this.manufactName = "no Manufacture Name";
		this.numCylinder = 1;
		this.ownerName = "no owner's name";
	}
	
	//parameterized Constructor
	public Vehicle(String xManName, int xCylinder, String xOwner)
	{
		this.setManufacturerName(xManName);
		this.setCylinder(xCylinder);
		this.setOwnerName(xOwner);
	}
	
	//Accessors
	public String getManufacturerName()
	{
		return this.manufactName;
	}
	
	public String getOwnerName()
	{
		return this.ownerName;
	}
	
	public int getCylinder()
	{
		return this.numCylinder;
	}
	
	//mutator
	public void setOwnerName(String xOwner) {
		// TODO Auto-generated method stub
		this.ownerName = xOwner;
	}

	public void setCylinder(int xCylinder) {
		// TODO Auto-generated method stub
		if(xCylinder > 0)
		{
			this.numCylinder = xCylinder;
		}
		else
		{
			System.out.println("invalid input for the number of cylinder");
		}
	}

	public void setManufacturerName(String xManName) {
		// TODO Auto-generated method stub
		this.manufactName = xManName;
	}
	
	public boolean equals(Vehicle v)
	{
		return this.manufactName.equalsIgnoreCase(v.getManufacturerName()) 
				&& this.numCylinder == v.getCylinder()
				&& this.ownerName.equalsIgnoreCase(v.getOwnerName());
	}
	
	public String toString()
	{
		return "Manufacturer's Name: "+this.manufactName+
				"\nCylinders: "+this.numCylinder+
				"\nOwner's Name"+this.ownerName;
	}
}
