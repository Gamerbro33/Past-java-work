//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help Calculate the area of the house and rooms you wish to stay in
//DATE: January 22 2020
package edu.cpt187.allen.Program2;
import java.util.Scanner;

public class MainClass 
{
	//declare Non-object CLASS CONSTANTS
	public static final String[] MENU_OPTIONS = {"Plan a home", "Quit"};

	public static void main(String[] args) 
	{
		//declare and initialize all local variables and constants
		Scanner input = new Scanner (System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';

		//Create instance from the supportive class
		SingleStoryHome currentHome = new SingleStoryHome();

		//DISPLAY welcome Banner
		displayWelcomeBanner();

		//gets and displays userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMenuSelection(input);

		//run-while
		while(menuSelection != 'Q')
		{
			//enter how many bedrooms
			currentHome.setBedroomCount(validateBedroomNumber(input));

			//enter how many bathrooms
			currentHome.setBathroomCount(validateBathroomNumber(input));

			//run-while(displayOverMaxArea)
			if(currentHome.getHomeArea() > currentHome.getMaxHomeArea())
			{
				//display when Home area input is more than Max home area
				displayOverMaxArea(currentHome.getHomeArea(), currentHome.getMaxHomeArea());
			}//end of while(displayOverMaxArea)
			else 
			{
				//DISPLAY Design details
				displayDesignDetails(userName, currentHome.getRoomNames(), currentHome.getBedroomCount(),currentHome.getBedroomArea(),currentHome.getBedroomCost(),currentHome.getBathroomCount(),currentHome.getBathroomArea(),currentHome.getBathroomCost(), currentHome.getMaxRoomCount(),currentHome.getKitchenArea(), currentHome.getKitchenCost(),currentHome.getLivingRoomArea(),currentHome.getLivingRoomCost(),currentHome.getHomeArea(),currentHome.getHomeCost());
			}
			//Begin Loop
			menuSelection = validateMenuSelection(input);
		}//end of while
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

	public static String getUserName(Scanner borrowedInput) 
	{
		String localUsrName = "";
		System.out.println("Please enter your name");
		localUsrName = borrowedInput.nextLine();
		return localUsrName;
	}//End of prompt

	//displays the menu
	public static void displayMainMenu() 
	{
		System.out.println("MAIN MENU");
		System.out.println("[A] to " +MENU_OPTIONS[0]);
		System.out.println("[Q] to " +MENU_OPTIONS[1]);
		System.out.println("Enter your selection here");
	}//end of Display method

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
	}//end of VR method

	//display bedroom question
	public static void displayBedroom() 
	{
		System.out.println("How many bedrooms would you like in your home.");
	}//end of void

	//VR method for how many bedrooms you want
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
	public static void displayBathroom() 
	{
		System.out.println("How many bathrooms would you like in your home.");
	}//end of void

	//VR method for how many bathrooms you want
	public static int validateBathroomNumber(Scanner borrowedInput)
	{
		int localBathNum;
		//display Bathroom question
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

	//void method to display when user is at max area
	public static void displayOverMaxArea(double borrowedHomeArea, double borrowedMaxHomeArea)
	{
		System.out.printf("%-27s%-2.1f%-4s\n","Home Area: ",borrowedHomeArea," Square ft");
		System.out.printf("Home Exceeds the maximum area allowed in the County Code");
		System.out.println("\nPlease make the home area less then "+borrowedMaxHomeArea+" Square ft");
		System.out.println("");
	}//end of Void

	//void method to display design details
	public  static void displayDesignDetails(String borrowedUserName, String[] borrowedRoomNames, int borrowedBedCount, double borrowedBedArea,double borrowedBedCost, int borrowedBathCount, double borrowedBathArea, double borrowedBathCost, int borrowedFixCount, double borrowedKitchenArea,double borrowedKitchenCost, double borrowedLivingArea,double borrowedLivingCost, double borrowedHomeArea, double borrowedHomeCost) 
	{
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("HOUSE REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.printf("%-20s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("");
		System.out.printf("%-2s%-15s%-5s%-10s\n",borrowedRoomNames[0]," Count:","",borrowedBedCount);
		System.out.printf("%-2s%-20s%-5s%-10s\n",borrowedRoomNames[0]," Area:",borrowedBedArea," Square ft");
		System.out.printf("%-2s%-20s%-2s%-1.2f\n",borrowedRoomNames[0]," Cost:","$",borrowedBedCost);
		System.out.println("");
		System.out.printf("%-2s%-14s%-5s%-10s\n",borrowedRoomNames[1]," Count:","",borrowedBathCount);
		System.out.printf("%-2s%-19s%-5s%-10s\n",borrowedRoomNames[1]," Area:",borrowedBathArea," Square ft");
		System.out.printf("%-2s%-19s%-2s%-1.2f\n",borrowedRoomNames[1]," Cost:","$",borrowedBathCost);
		System.out.println("");
		System.out.printf("%-2s%-15s%-5s%-10s\n",borrowedRoomNames[2]," Count:","",borrowedFixCount);
		System.out.printf("%-2s%-20s%-5s%-10s\n",borrowedRoomNames[2]," Area:",borrowedKitchenArea," Square ft");
		System.out.printf("%-2s%-20s%-2s%-1.2f\n",borrowedRoomNames[2]," Cost:","$",borrowedKitchenCost);
		System.out.println("");
		System.out.printf("%-2s%-11s%-5s%-10s\n",borrowedRoomNames[3]," Count:","",borrowedFixCount);
		System.out.printf("%-2s%-16s%-5s%-10s\n",borrowedRoomNames[3]," Area:",borrowedLivingArea," Square ft");
		System.out.printf("%-2s%-16s%-2s%-1.2f\n",borrowedRoomNames[3]," Cost:","$",borrowedLivingCost);
		System.out.println("");
		System.out.printf("%-27s%-2.1f%-4s\n","Home Area: ",borrowedHomeArea," Square ft");
		System.out.printf("%-27s%-2s%-1.2f\n","Home Cost: ","$",borrowedHomeCost);
	}

	//void method to display farewell message
	public static void displayFarewellMessage()
	{

		System.out.println("Thank you for using our Home design program,");
		System.out.println("and we hope you have a nice day!");
	}//end of void method
}
