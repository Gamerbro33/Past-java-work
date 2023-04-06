
public class ShapeBasics implements ShapesInterface{

	private int offset;
	
	public ShapeBasics()
	{
		this.offset = 0;
	}
	
	public ShapeBasics(int xOffSet)
	{
		//to do
	}
	
	public int getOffSet()
	{
		return this.offset;
	}
	
	public void setOffSet(int xOffset)
	{
		if(xOffset >= 0)
		{
			this.offset = xOffset;
		}
		
	}
	public void drawAt(int lineNumber)
	{
		for(int i=0; i < lineNumber; i++)
		{
			System.out.println();
		}
		drawHere();
	}
	
	public void drawHere()
	{
		for(int i = 0; i < this.offset; i++)
		{
			System.out.print(" ");
		}
		System.out.print("*");
	}
	/*public static void skipSpace(int a)
	{
		for(int i =0;i<a;i++)
		{
			System.out.println
		}
	}*/
}
