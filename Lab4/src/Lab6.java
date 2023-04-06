//RJ Allen
import java.util.Scanner;
public class Lab6 {

	public static final double MIN = 60;
	public static final double HOUR = 3600;
	public static final double DAY = 86400;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//users inputs seconds
		System.out.println("Enter the time in Seconds more then 60");
		
		double sec = input.nextDouble();
		
		//else if statements to tell if its in min hours or days
		if(sec >= 60 && sec <= 3599)
		{
			//variable for amount of min
			double amtMin = sec / MIN;
			System.out.println(sec+" seconds is the same as "+amtMin+" minutes");
		}
		else if(sec >= 3600 && sec <= 86399)
		{
			//variable for amount of hour
			double amtHour = sec / HOUR;
			System.out.println(sec+" seconds is the same as "+amtHour+" Hours");
		}
		else if(sec >= 86400)
		{
			//variable for amount of days
			double amtDay = sec / DAY;
			System.out.println(sec+" seconds is the same as "+amtDay+" Day(s)");
		}
		//if they put no numbers
		else
		{
			System.out.println("incorrect input shutting down!");
			System.exit(0);
		}
	}

}
