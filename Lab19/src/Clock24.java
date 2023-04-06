

public class Clock24 {
	//instance Variable
	private int hours;
	private int minutes;
	private boolean isAM;
	
	//default constructors
	public Clock24()
	{
		this.hours = 0;
		this.minutes = 0;
		this.isAM = true;
	}
	
	//parameter constructor
	public Clock24(int xHours, int xMinutes)
	{
		this.setHours(xHours);
		this.setMinutes(xMinutes);
		
		
	}
	
	//accessors
	public int getHours()
	{
		return this.hours;
	}
	
	public int getMinutes()
	{
		return this.minutes;
	}
	
	public boolean getIsAM()
	{
		return this.isAM;
	}
	
	//mutators
	public void setHours(int xHours)
	{
		if(xHours > 0 && xHours <=24)
		{
			this.hours = xHours;
		}
		else
		{
			System.out.println("Invalid input for hours");
		}
	}
	
	public void setMinutes(int xMinutes)
	{
		if(xMinutes >= 0 && xMinutes <= 59)
		{
			this.minutes = xMinutes;
		}
		else
		{
			System.out.println("Invalid input for minutes");
		}
	}
	
	public void setIsAM()
	{
		
		if(this.hours >= 0||this.hours < 12)
		{
			this.isAM = false;
		}
		if(this.hours >=12 || this.hours <24)
		{
			this.isAM = true;
		}

	}

	//sets the timer
	public void setTime() throws TimeFormatException
	{
		String xTime = this.hours+":"+this.minutes;
		int colon = xTime.indexOf(":");

		int hour = Integer.parseInt(xTime.substring(0,colon));
		int minute = Integer.parseInt(xTime.substring(colon + 1));

		this.setHours(hour);
		this.setMinutes(minute);
		try
		{
			
		
		if(hour > 0 && hour <=24 && minute >= 0 && minute <= 59)
		{
			hour = this.hours;
			minute = this.minutes;

			if(hour > 12)
			{
				hour = hour%12;
				this.isAM = false;
				this.hours = hour;
				this.minutes = minute;
			}
			else
			{
				this.hours = hour;
				this.minutes = minute;
				this.isAM = true;
			}
			//this.hours = hour;
			//this.minutes = minute;
		}
		else {
			throw new TimeFormatException();
		}
		}catch(TimeFormatException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void setTime(String xTime)throws TimeFormatException
	{

		int colon = xTime.indexOf(":");

		int hour = Integer.parseInt(xTime.substring(0,colon));
		int minute = Integer.parseInt(xTime.substring(colon + 1));

		this.setHours(hour);
		this.setMinutes(minute);
		try
		{
			
		
		if(hour > 0 && hour <=24 && minute >= 0 && minute <= 59)
		{
			hour = this.hours;
			minute = this.minutes;

			if(hour > 12)
			{
				hour = hour%12;
				this.isAM = false;
				this.hours = hour;
				this.minutes = minute;
			}
			else
			{
				this.hours = hour;
				this.minutes = minute;
				this.isAM = true;
			}
			//this.hours = hour;
			//this.minutes = minute;
		}
		else {
			throw new TimeFormatException();
		}
		}catch(TimeFormatException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void printTime()
	{
		
			if(this.minutes <10)
			{
			System.out.print(this.hours +":0"+this.minutes+" ");
			}
			else
			{
				System.out.print(this.hours +":"+this.minutes+" ");
			}
			if(this.isAM == true)
			{
				System.out.print("AM\n");
			}
			else
			{
				System.out.print(" PM\n");
			}
		
		
	}
}
