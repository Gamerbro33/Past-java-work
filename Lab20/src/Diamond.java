//RJAllen
public class Diamond extends ShapeBasics implements DiamondInterface{
	
	//variable 
	private int width;
	

    public Diamond()
    {
        super();
        this.width = 0;
    }

    public Diamond(int xOffset, int xWidth)
    {
        super(xOffset);
        this.setWidth(xWidth);
    }

  
    public void setWidth(int xWidth)
    {
    	if(xWidth >= 0 && xWidth%2 == 1)
		{
			this.width = xWidth;
		}
    	else
    	{
    		System.out.println("Invalid input in set width");
    	}
    }
    
    
    public int getWidth()
    {
    	return this.width;
    }

    /**
     Draws the shape at the current line.
    */
    public void drawHere()
    {
    	//draws the diamond
       drawTopV();
       drawBottomV();
       
    }
    
    private void drawTopV()
    {
    	int center = this.width/2;
		int start = this.getOffset() + center;
		
		this.skipSpaces(start);
		
		System.out.println("*");
		
		int insideWidth = 1;
		int count = center;
		
		for(int i = 0; i < count; i++)
		{
			start--;
			this.skipSpaces(start);
			
			System.out.print("*");
			
			this.skipSpaces(insideWidth);
			
			System.out.println("*");
			
			insideWidth += 2;
			
		}
    }
    
    private void drawBottomV()
    {

    	int center = this.width/2;
		int end = this.getOffset();
		int insideWidth = this.width - 2;
		
		insideWidth -= 2;
		int count = center-1;
		
		
		for(int i = 0; i < count; i++)
		{
			end++;
			this.skipSpaces(end);
			System.out.print("*");
			
			this.skipSpaces(insideWidth);
			
			System.out.println("*");
			
			insideWidth -=2;
			
			
		}
		this.skipSpaces(this.getOffset()+ center);
		System.out.print("*");
		
    }
    
    public void skipSpaces(int spaces)
    {
    	for (int i=0; i<spaces; i++)
		{
			System.out.print(" ");
		}
    }
 }

