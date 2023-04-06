import java.util.*;
public class Clock24Tester {

	public static void main(String[] args) {

		Clock24 clock = new Clock24();
		Scanner key = new Scanner(System.in);
		
		boolean quit = false;
		while(quit == false)
		{
			//Prompt the user
			System.out.println("Enter a time in the 24-hour notation or enter \"Exit\" to quit:");
			//Gets the user input
			String input = key.nextLine();
			if(input.equalsIgnoreCase("exit"))
			{
				System.out.println("Goodbye!");
				break;
			}
			try
			{
				clock.setTime(input);
				clock.printTime();
			}
			catch(TimeFormatException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


}