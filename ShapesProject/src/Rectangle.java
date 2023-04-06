
public class Rectangle extends ShapeBasics implements RectangleInterface {

	private int height;
	private int width;
	
	public Rectangle()
	{
		super();
		this.height = 0;
		this.width = 0;
		
	}
	public Rectangle(int xOffset, int xHeight, int xWidth)
	{
		super(xOffset);
		this.set(xHeight, xWidth);
	}
	
	public int getHeight()
	{
		return this.height;
	}
	public int getWidth()
	{
		return this.width;
	}
	
	public void set(int xHeight, int xWidth)
	{
		if(xHeight > 0 && xWidth > 0)
		{
			this.height =xHeight;
			this.width = xWidth;
		}
	}
	
	
	public void drawHere()
	{
		//to do
		drawHorizontalLine();
		drawSides();
		drawHorizontalLine();
	}
	
	private void drawHorizontalLine()
	{
		this.skipSpaces(super.getOffSet());
		for(int i = 0; i < this.width; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		
	}
	
	
	private void drawSides()
	{
		for(int i=0; i < this.height-2; i++)
		{
			this.skipSpaces(this.getOffSet());
			System.out.print("*");
			this.skipSpaces(this.width-2);
			System.out.println("*");
		}
	}
	
	//private method can only be accessed inside a class where it is defined
	private void skipSpaces(int spaces)
	{
		for(int i = 0; i< spaces; i++)
		{
			System.out.print(" ");
		}
	}
}
