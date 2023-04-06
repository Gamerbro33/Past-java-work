
public class Box {
	//instance varable
	private String label;
	private double length;
	private double width;
	private double height;
	
	//default constructor
	public Box()
	{
		this.label = "none";
		this.length = 0.0;
		this.width = 0.0;
		this.height = 0.0;
	}
	//Parameterized constructor
	public Box(String xLabel, double xLength, double xWidth, double xHeight)
	{
		this.setLabel(xLabel);
		this.setLength(xLength);
		this.setWidth(xWidth);
		this.setHeight(xHeight);
	}
	//accessors
	public String getLabel()
	{
		return this.label;
	}
	public double getLength()
	{
		return this.length;
	}
	
	public double getWidth()
	{
		return this.width;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	
	public void setLabel(String xLabel)
	{
		this.label = xLabel;
	}
	
	public void setLength(double xLength)
	{
		if(xLength > 0)
		{
			this.length = xLength;
		}
		else
		{
			System.out.println("Error input in value of length");
		}
	}
	
	public void setWidth(double xWidth)
	{
		if(xWidth > 0)
		{
			this.width = xWidth;
		}
		else
		{
			System.out.println("Error input in value of width");
		}
	}
	
	public void setHeight(double xHeight)
	{
		if(xHeight > 0)
		{
			this.height = xHeight;
		}
		else
		{
			System.out.println("Error input in value of width");
		}
	}
	
	//
	public double getVolume()
	{
		return this.length * this.width * this.height;
	}
	
	
	//display to string
	public String toString()
	{
		return "Label: "+this.label+
				"         Volume"+this.getVolume();
	}
}
