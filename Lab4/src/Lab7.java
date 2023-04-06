//RJ Allen
import java.util.Scanner;
public class Lab7 {

	//a set Int
	public static final int ZODIAC = 1924;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String animal = "";
		String element= "";
		//imported Scanner
		Scanner input = new Scanner(System.in);
		
		//ask user to input year
		System.out.println("What is your Chinese zodiac? Enter your birth Year");
		int year = input.nextInt();
		//if else statement
		if(year >= ZODIAC)
		{
			//equation
			int symbol =  (year - ZODIAC)%12;
			//if any of the years in equation match with to their animal
			if(symbol == 0)
			{
				animal = "rat";
			}
			else if(symbol == 1)
			{
				animal = "ox";
			}
			else if(symbol == 2)
			{
				animal = "tiger";
			}
			else if(symbol == 3)
			{
				animal = "rabbit";
			}
			else if(symbol == 4)
			{
				animal = "dragon";
			}
			else if(symbol == 5)
			{
				animal = "snake";
			}
			else if(symbol == 6)
			{
				animal = "horse";
			}
			else if(symbol == 7)
			{
				animal = "goat";
			}
			else if(symbol == 8)
			{
				animal = "monkey";
			}
			else if(symbol == 9)
			{
				animal = "rooster";
			}
			else if(symbol == 10)
			{
				animal = "dog";
			}
			else if(symbol == 11)
			{
				animal = "pig";
			}
			//input error message
			else
			{
				System.out.println(" error occured in animals");
				System.exit(0);
				
			}
			
			//if they have an animal what is their element.
			if(animal.equalsIgnoreCase("rabbit") || animal.equalsIgnoreCase("tiger"))
			{
				element = "wood";
			}
			else if(animal.equalsIgnoreCase("snake") || animal.equalsIgnoreCase("horse"))
			{
				element = "fire";
			}
			else if(animal.equalsIgnoreCase("ox") || animal.equalsIgnoreCase("dragon") || animal.equalsIgnoreCase("goat") || animal.equalsIgnoreCase("dog"))
			{
				element = "earth";
			}
			else if(animal.equalsIgnoreCase("monkey") || animal.equalsIgnoreCase("rooster"))
			{
				element = "metal";
			}
			else if(animal.equalsIgnoreCase("pig") || animal.equalsIgnoreCase("rate"))
			{
				element = "water";
			}
			//display error
			else 
			{
				System.out.println("Error occured in elements");
				System.exit(0);
			}
			System.out.println("You are a "+element+" "+animal);
		}
		//display error
		else
		{
			System.out.println("Invalid year");
			System.exit(0);
		}
		
	}

}
