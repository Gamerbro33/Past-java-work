//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help Calculate the area of the house and rooms you wish to stay in
//DATE: January 15 2020
package edu.cpt187.allen.program1;
import java.util.Scanner;


public class MainClass 
{
	//declare Non-object CLASS CONSTANTS
	public static final String MENU_OPTION_DESIGN = "Plan a home";
	public static final String MENU_OPTION_QUIT = "Quit";

	public static void main(String[] args) 
	{
		//declare and initialize all local variables and constants
		Scanner input = new Scanner (System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';
		int currentBedroomNumber = 0;
		int currentBathroomNumber = 0;

		//Create instance from the supportive class
		SingleStoryHome currentHome = new SingleStoryHome();

		//DISPLAY welcome Banner
		displayWelcomeBanner();

		//gets and displays userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMenuSelection(input);

		//run-while (menuSelection)
		while(menuSelection != 'Q')
		{
			//enter how many bedrooms
			currentBedroomNumber = validateBedroomNumber(input);

			//enter how many bedrooms
			currentBathroomNumber = validateBathroomNumber(input);

			//these will invoke behaviors in the supportive class
			currentHome.setBedroomCount(currentBedroomNumber);
			currentHome.setBathroomCount(currentBathroomNumber);

			//run-while (currentHome)
			if(currentHome.getHomeArea() > currentHome.getMaxHomeArea())
			{
				//Display Over Max area
				displayOverMaxArea(currentHome.getHomeArea(), currentHome.getMaxHomeArea());
			}//end of while(displayOverMaxArea)
			else 
			{
				//Display Design detail
				displayDesignDetails(userName, currentHome.getBedroomCount(), currentHome.getBedroomArea(), currentHome.getBathroomCount(), currentHome.getBathroomArea(), currentHome.getMaxRoomCount(), currentHome.getKitchenArea(), currentHome.getLivingRoomArea(), currentHome.getHomeArea());
			}
			//Begin Loop
			menuSelection = validateMenuSelection(input);
		}//end of while(menuSelection)

		//display farewell message
		displayFarewellMessage();
	}//end of main method

	//welcome Banner
	public static void displayWelcomeBanner()
	{
		System.out.println("******************************************");
		System.out.println("Welcome to the Computer house Planner.");
		System.out.println("The site will let you plan the design and area for");
		System.out.println("a single story home. You will get 1 livingroom,");
		System.out.println("1 kitchen, and your choice of having more than one");
		System.out.println("bedroom and/or bathroom. The program will add up all the");
		System.out.println("areas of each room and will count all the rooms you have.");
		System.out.println("******************************************");
	}//end of welcome banner
	//displays the menu
	public static void displayMainMenu() 
	{
		System.out.println("MAIN MENU");
		System.out.println("[A] to " +MENU_OPTION_DESIGN);
		System.out.println("[Q] to " +MENU_OPTION_QUIT);
		System.out.println("Enter your selection here");
	}//end of Display method
	
	public static String getUserName(Scanner borrowedInput) 
	{
		String localUsrName = "";
		System.out.println("Please enter your name");
		localUsrName = borrowedInput.nextLine();
		return localUsrName;
	}//End of prompt

	//Main Menu
	//VR Method
	public static char validateMenuSelection(Scanner borrowedInput) 
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayMainMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'A' && localMenuSelection != 'Q') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayMainMenu();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}

	public static int validateBedroomNumber(Scanner borrowedInput)
	{
		int localBedNum;
		//display Bedroom question
		displayBedroom();
		localBedNum = borrowedInput.nextInt();

		//validate input
		while(localBedNum <= 0 )
		{
			System.out.println("~Please choose a quantity greater than ZERO~");
			System.out.println("");
			displayBedroom();
			localBedNum = borrowedInput.nextInt();
		}//end of while
		return localBedNum;
	}//end of VR method

	//display bedroom question
	public static void displayBedroom() 
	{
		System.out.println("How many bedrooms would you like in your home.");
	}//end of void

	//display bedroom question
	public static void displayBathroom() 
	{
		System.out.println("How many bathrooms would you like in your home.");
	}//end of void

	public static int validateBathroomNumber(Scanner borrowedInput)
	{
		int localBathNum;
		//display Bedroom question
		displayBathroom();
		localBathNum = borrowedInput.nextInt();

		//validate input
		while(localBathNum <= 0 )
		{
			System.out.println("~Please choose a quantity greater than ZERO~");
			System.out.println("");
			displayBathroom();
			localBathNum = borrowedInput.nextInt();
		}//end of while
		return localBathNum;
	}//end of VR method
	public static void displayOverMaxArea(double borrowedHomeArea, double borrowedMaxHomeArea)
	{
		System.out.printf("%-27s%-2.1f%-4s\n","Home Area: ",borrowedHomeArea," Square ft");
		System.out.printf("Home Exceeds the maximum area allowed in the County Code");
		System.out.println("\nPlease make the home area less then "+borrowedMaxHomeArea+" Square ft");
		System.out.println("");
	}

	public  static void displayDesignDetails(String borrowedName, int borrowedBedCount, double borrowedBedArea, int borrowedBathCount, double borrowedBathArea, int borrowedFixCount, double borrowedKitchenArea, double borrowedLivingArea, double borrowedHomeArea) 
	{
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("HOUSE REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedName);
		System.out.println("");
		System.out.printf("%-22s%-5s%-10s\n","Bedroom Count:","",borrowedBedCount);
		System.out.printf("%-27s%-2.1f%-4s\n","Bedroom Area:",borrowedBedArea," Square ft");
		System.out.println("");
		System.out.printf("%-22s%-5s%-10s\n","Bathroom Count:","",borrowedBathCount);
		System.out.printf("%-27s%-2.1f%-4s\n","Bathroom Area:",borrowedBathArea," Square ft");
		System.out.println("");
		System.out.printf("%-22s%-5s%-10s\n","Kitchen Count:","",borrowedFixCount);
		System.out.printf("%-27s%-2.1f%-4s\n","Kitchen Area:",borrowedKitchenArea," Square ft");
		System.out.println("");
		System.out.printf("%-22s%-5s%-10s\n","Livingroom Count:","",borrowedFixCount);
		System.out.printf("%-27s%-2.1f%-4s\n","Livingroom Area:",borrowedLivingArea," Square ft");
		System.out.println("");
		System.out.printf("%-27s%-2.1f%-4s\n","Home Area: ",borrowedHomeArea," Square ft");
	}
	//display farewell message
	public static void displayFarewellMessage()
	{

		System.out.println("Thank you for using our Home design program,");
		System.out.println("and we hope you have a nice day!");
	}

}
