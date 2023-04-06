
public class TimeFormatException extends Exception{
	
	//default constructor
	public TimeFormatException()
	{
		super("EXCEPTION!: The is an incorrect time!");
		
	}
	
	//parameterized constructor
	public TimeFormatException(String msg)
	{
		super(msg);
		
	}
}
