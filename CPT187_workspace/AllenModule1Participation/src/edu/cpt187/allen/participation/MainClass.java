//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help make an easy online experience to buy your shopping goods.
//DATE: January 13 2020
package edu.cpt187.allen.participation;
import java.util.Scanner;

public class MainClass 
{
	public static final String MENU_CREATE_ORDER = "Create Order";
	public static final String MENU_QUIT = "Quit";

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		//local variables 
		String userName;
		char menuSelection;
		int howMany;


		//Create instance from the supportive class 
		SodOrder mySodOrder = new SodOrder();

		//DISPLAY welcome Banner
		displayWelcomeBanner();

		//gets and displays userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMainMenu(input);

		//run-while
		while(menuSelection != 'Q') 
		{   //select an item from the menu
			menuSelection = validateItemMenu(input);
			//these will invoke behaviors in the supportive class
			mySodOrder.setItemName(menuSelection);
			mySodOrder.setItemPrice(menuSelection);

			howMany = validateHowMany(input);

			mySodOrder.setHowMany(howMany);

			//selecting a discount from the menu
			menuSelection = validateDiscountMenu(input);
			mySodOrder.setDiscountRate(menuSelection);

			//Displays customers receipt
			displayItemReceipt(userName, mySodOrder.getItemName(), mySodOrder.getItemPrice(), mySodOrder.getHowMany(), mySodOrder.getDiscountRate(), mySodOrder.getDiscountAmt(), mySodOrder.getDiscountPrice(), mySodOrder.getSubTotal(), mySodOrder.getTaxRate(), mySodOrder.getTaxAmt(), mySodOrder.getTotalCost());

			//Begin Loop
			menuSelection = validateMainMenu(input);

		}//end of while
		//DISPLAY Farewell Message
		displayFarwellMessage();

		//Close Scanner
		input.close();
	}//end of Main Method


	//Welcome banner
	public static void displayWelcomeBanner() 
	{
		System.out.println("******************************************");
		System.out.println("welcome to the Sod Shopping website");
		System.out.println("this site will let you select from one of our ");
		System.out.println("products, how many of the product you want,");
		System.out.println("and then select a discount of your choice.");
		System.out.println("The transaction details will calculate the total cost for you.");
		System.out.println("******************************************");
	}//End of display method


	//requests userName from user
	//return to main
	public static String getUserName(Scanner borrowedInput) 
	{
		String localUsrName = "";
		System.out.println("Please enter your name");
		localUsrName = borrowedInput.nextLine();
		return localUsrName;
	}//End of prompt

	public static void displayMainMenu() 
	{
		System.out.println("MAIN MENU");
		System.out.println("[A] for " +MENU_CREATE_ORDER);
		System.out.println("[Q] for " +MENU_QUIT);
		System.out.println("Enter your selection here");
	}//end of Display method

	//Main Menu
	//VR Method
	public static char validateMainMenu(Scanner borrowedInput) 
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

	//void method
	public static void displayItemMenu(String borrowedNamePremium, String borrowedNameSpecial, String borrowedNameBasic, double borrowedPricePremium, double borrowedPriceSpecial, double borrowedPriceBasic) 
	{
		System.out.println("ITEMS MENU");
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[A] for ",borrowedNamePremium," $",borrowedPricePremium);
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[B] for ",borrowedNameSpecial," $",borrowedPriceSpecial);
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[C] for ",borrowedNameBasic," $",borrowedPriceBasic);
		System.out.println("Please make your selection here:");
	}
	public static char validateItemMenu(Scanner borrowedInput) 
	{
		SodOrder mySodOrder = new SodOrder();
		char localItemSelection = ' ';
		//Main Menu
		displayItemMenu(mySodOrder.getItemNamePremium(), mySodOrder.getItemNameSpecial(), mySodOrder.getItemNameBasic(), mySodOrder.getItemPricePremium(), mySodOrder.getItemPriceSpecial(), mySodOrder.getItemPriceBasic());
		localItemSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localItemSelection != 'A' && localItemSelection != 'B' && localItemSelection != 'C') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayItemMenu(mySodOrder.getItemNamePremium(), mySodOrder.getItemNameSpecial(), mySodOrder.getItemNameBasic(), mySodOrder.getItemPricePremium(), mySodOrder.getItemPriceSpecial(), mySodOrder.getItemPriceBasic());
			localItemSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localItemSelection;
	}
	public static void displayHowMany() {
		System.out.println("How many of this product would you like");
	}

	public static int validateHowMany(Scanner borrowedInput) {
		int localHowMany = 0;
		displayHowMany();
		localHowMany = borrowedInput.nextInt();
		//validate input

		while(localHowMany <= 0) 
		{
			System.out.println("Please choose a quantity greater than ZERO");
			displayHowMany();
			localHowMany = borrowedInput.nextInt();
		}
		return localHowMany;
	}//end of howMany VR Method
	public static void displayDiscountMenu(String borrowedDiscountNeMember, String borrowedDiscountNeSenior, String borrowedDiscountNeNone, double borrowedDiscountMember, double borrowedDiscountSenior, double borrowedDiscountNone)
	{
		System.out.println("DISCOUNT MENU");
		System.out.printf("%-6s%-2s%-10s%-3.2f%2.2s\n","[A] for ",borrowedDiscountNeMember," ",borrowedDiscountMember*100,"%");
		System.out.printf("%-6s%-2s%-10s%-3.2f%2.2s\n","[B] for ",borrowedDiscountNeSenior," ",borrowedDiscountSenior*100,"%");
		System.out.printf("%-7s%-3s%-6s%-3.2f%2.2s\n","[C] for ",borrowedDiscountNeNone," ",borrowedDiscountNone*100,"%");


	}
	public static char validateDiscountMenu(Scanner borrowedInput) 
	{
		SodOrder mySodOrder = new SodOrder();
		char localDisSelection = ' ';
		//display Discount Menu
		displayDiscountMenu(mySodOrder.getDiscountNameMember(), mySodOrder.getDiscountNameSenior(), mySodOrder.getDiscountNameNone(), mySodOrder.getDiscountRateMember(), mySodOrder.getDiscountRateSenior(), mySodOrder.getDiscountRateNone());
		localDisSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localDisSelection != 'A' && localDisSelection != 'B' && localDisSelection != 'C') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayDiscountMenu( mySodOrder.getDiscountNameMember(), mySodOrder.getDiscountNameSenior(), mySodOrder.getDiscountNameNone(), mySodOrder.getDiscountRateMember(), mySodOrder.getDiscountRateSenior(), mySodOrder.getDiscountRateNone());
			localDisSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localDisSelection;
	}
	public static void displayItemReceipt(String borrowedUserName, String borrowedItemName, double borrowedItemPrice,int borrowedHowMany,double borrowedDiscountRate, double borrowedDiscountAmt, double borrowedDiscountPrice,  double borrowedSubTotal, double borrowedTaxRate, double borrowedTaxAmt, double borrowedTotalCost)
	{
		//format and display receipt
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("ORDER REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("");
		System.out.printf("%-20s%-5s%-10s\n","Item Purchase:","",borrowedItemName);
		System.out.printf("%-25s%-2s%4.2f\n","The items Price:","$",borrowedItemPrice);
		System.out.println("");
		System.out.printf("%-27s%-2.1f%-4.2s\n","Discount Rate:",borrowedDiscountRate*100,"%");
		System.out.printf("%-25s%-2s%-8.2f\n","Discount Amount:","$",borrowedDiscountAmt);
		System.out.printf("%-25s%-2s%-8.2f\n","Discount Price:","$",borrowedDiscountPrice);
		System.out.println("");
		System.out.printf("%-24s%-2s%2s\n","Quantity:","",borrowedHowMany);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Sub Total: ","$",borrowedSubTotal);
		System.out.printf("%-27s%-2.1f%-8.2s\n","Tax Rate: ",borrowedTaxRate*100,"%");
		System.out.printf("%-25s%-2s%-8.2f\n","Tax Amount: ","$",borrowedTaxAmt);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Total Cost: ","$",borrowedTotalCost);
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
	}
	//display farewell message
	public static void displayFarwellMessage()
	{
		System.out.println("Thank you for using our online system and we hope you have a nice day!");
	}
}
