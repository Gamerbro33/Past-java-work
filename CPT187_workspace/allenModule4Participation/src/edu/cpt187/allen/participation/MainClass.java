//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help make an easy online experience to buy your shopping goods.
//DATE: February 4 2020
package edu.cpt187.allen.participation;

import java.util.Scanner;

public class MainClass 
{
	public static final String[] MENU_OPTIONS = {"Load Inventory","Create Order", "Quit"};

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';

		//Create instance from the supportive class 
		SodOrder mySodOrder = new SodOrder();
		Inventory currentInventory = new Inventory();

		//DISPLAY welcome Banner
		displayWelcomeBanner();

		//gets and displays userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMainMenu(input);
		
		//run-while
		while(menuSelection != 'Q') 
		{
			//if statement
			if(menuSelection == 'A')
			{
				currentInventory.setInStockCounts(validateCounts(input, currentInventory.getItemNames()));
			}//end of if
			else
			{
				mySodOrder.setItemSelection(validateItemMenu(input, currentInventory.getItemNames(), currentInventory.getItemPrice()));
				//these will invoke behaviors in the supportive class
				mySodOrder.setItemName(currentInventory.getItemNames());
				mySodOrder.setItemPrice(currentInventory.getItemPrice());
				mySodOrder.setHowMany(validateHowMany(input));
				
				if(mySodOrder.getInStockCount(currentInventory.getInStockCounts()) < mySodOrder.getHowMany())
				{
					displayOutOfStock();
				}
				else
				{
					mySodOrder.setDiscountType(validateDiscountMenu(input, currentInventory.getDiscountNames(), currentInventory.getDiscountRate()));
					mySodOrder.setDiscountName(currentInventory.getDiscountNames());
					mySodOrder.setDiscountRate(currentInventory.getDiscountRate());
					mySodOrder.setDecreaseInStock(currentInventory);
					mySodOrder.setPrizeName(currentInventory.getPrizeNames(), currentInventory.getRandomNumber());
					
					if(mySodOrder.getDiscountRate() > 0.0)
					{
						displayItemReceipt(userName, mySodOrder.getItemName(), mySodOrder.getItemPrice(), mySodOrder.getHowMany(), mySodOrder.getDiscountName(), mySodOrder.getDiscountRate(), mySodOrder.getDiscountAmt(), mySodOrder.getDiscountPrice(), mySodOrder.getSubTotal(), mySodOrder.getTaxRate(), mySodOrder.getTaxAmt(), mySodOrder.getTotalCost(), mySodOrder.getPrizeName());
					}
					else
					{
						displayItemReceipt(userName, mySodOrder.getItemName(), mySodOrder.getItemPrice(), mySodOrder.getHowMany(), mySodOrder.getSubTotal(), mySodOrder.getTaxRate(), mySodOrder.getTaxAmt(), mySodOrder.getTotalCost(), mySodOrder.getPrizeName());
					}
				}
			}//end of else
			menuSelection = validateMainMenu(input);
		}//end of while
		if(mySodOrder.getTotalCost() > 0.0)
		{
			displayFinalReport(currentInventory.getItemNames(), mySodOrder.getItemCounts(), currentInventory.getDiscountNames(), mySodOrder.getDiscountCounts(), currentInventory.getPrizeNames(), mySodOrder.getPrizeCount(), currentInventory.getInStockCounts());
		}
		displayFarewellMessage();
	}//end of Main method
	
	//Welcome banner
	public static void displayWelcomeBanner() 
	{
		System.out.println("******************************************");
		System.out.println("welcome to the Sod Shopping website");
		System.out.println("this site will let you select from one of our ");
		System.out.println("products, how many of the product you want,");
		System.out.println("and then select a discount of your choice.");
		System.out.println("Transaction details will calculate the total cost.");
		System.out.println("At the end you will get a prize.");
		System.out.println("******************************************");
	}//End of display method
	
	public static void displayOutOfStock()
	{
		System.out.println("It would appear that we are out for ");
		System.out.println("the item you wish to purchase. Please check");
		System.out.println("the inventory to see and load more products");
	}
	//display farewell message
	public static void displayFarewellMessage()
	{
		System.out.println("Thank you for using our online system and");
		System.out.println("we hope you have a nice day!");
	}
	
	public static char validateMainMenu(Scanner borrowedInput)
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayMainMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'A' && localMenuSelection !='B' && localMenuSelection != 'Q') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayMainMenu();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}
	public static void displayMainMenu() 
	{
		System.out.println("MAIN MENU");
		System.out.println("[A] for " +MENU_OPTIONS[0]);
		System.out.println("[B] for " +MENU_OPTIONS[1]);
		System.out.println("[Q] for " +MENU_OPTIONS[2]);
		System.out.println("Enter your selection here");

	}//end of Display method
	
	//requests userName from user
	//return to main
	public static String getUserName(Scanner borrowedInput) 
	{
		String localUsrName = "";
		System.out.println("Please enter your name");
		localUsrName = borrowedInput.nextLine();
		return localUsrName;
	}//End of prompt
	
	public static int[] validateCounts(Scanner borrowedInput, String[] borrowedItemNames)
	{
		int localStockCount = 0;
		int localIndex = 0;
		
		
		int[] localStockCounts = new int[borrowedItemNames.length];
		
		while(localIndex < borrowedItemNames.length) 
		{
			System.out.printf("%-20s", "Enter amount of " + borrowedItemNames[localIndex] + " In Stock: ");
			localStockCount = borrowedInput.nextInt();
			//begin loop array while
			while(localStockCount <= 0)
			{
				System.out.println("Enter a valid number.");
				System.out.printf("%-20s\n", "Amount of " + borrowedItemNames[localIndex] + " In Stock: ");
			}
			localStockCounts[localIndex] = localStockCount;
			localIndex++;
		}
		return localStockCounts;
	}
	
	public static void displayHowMany() {
		System.out.println("How many of this product would you like");
	}
	public static int validateHowMany(Scanner borrowedInput)
	{
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
	
	public static void displayItemMenu(String[] borrowedItemName, double[] borrowedItemPrice)
	{
		System.out.println("ITEMS MENU");
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[A] for ",borrowedItemName[0]," $",borrowedItemPrice[0]);
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[B] for ",borrowedItemName[1]," $",borrowedItemPrice[1]);
		System.out.printf("%-6s%-16s%-3s%5.2f\n","[C] for ",borrowedItemName[2]," $",borrowedItemPrice[2]);
		System.out.println("Please make your selection here:");
	}
	public static char validateItemMenu(Scanner borrowedInput, String[] borrowedItemsName, double[] borrowedItemPrice)
	{
		Inventory currentInventory = new Inventory();
		char localItemSelection = ' ';
		//Main Menu
		displayItemMenu(currentInventory.getItemNames(), currentInventory.getItemPrice());
		localItemSelection = borrowedInput.next().toUpperCase().charAt(0);
		while(localItemSelection != 'A' && localItemSelection != 'B' && localItemSelection != 'C') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayItemMenu(currentInventory.getItemNames(), currentInventory.getItemPrice());
			localItemSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localItemSelection;
	}
	
	public static void displayDiscountMenu(String[] borrowedDiscountName, double[] borrowedDiscountRate)
	{
		System.out.println("DISCOUNT MENU");
		System.out.printf("%-6s%-2s%-10s%-3.1f%2.1s\n","[A] for ",borrowedDiscountName[0]," ",borrowedDiscountRate[0]*100,"%");
		System.out.printf("%-6s%-2s%-10s%-3.1f%2.1s\n","[B] for ",borrowedDiscountName[1]," ",borrowedDiscountRate[1]*100,"%");
		System.out.printf("%-7s%-3s%-6s%-3.1f%2.1s\n","[C] for ",borrowedDiscountName[2]," ",borrowedDiscountRate[2]*100,"%");
	}
	
	public static char validateDiscountMenu(Scanner borrowedInput, String[] borrowedDiscountName, double[] borrowedDiscountRate)
	{
		Inventory currentInventory = new Inventory();
		char localDisSelection = ' ';
		//Main Menu
		displayDiscountMenu(currentInventory.getDiscountNames(), currentInventory.getDiscountRate());
		localDisSelection = borrowedInput.next().toUpperCase().charAt(0);
		while(localDisSelection != 'A' && localDisSelection != 'B' && localDisSelection != 'C') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayDiscountMenu(currentInventory.getDiscountNames(), currentInventory.getDiscountRate());
			localDisSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localDisSelection;
	}
	
	public static void displayItemReceipt(String borrowedUserName, String borrowedItemName, double borrowedItemPrice, int borrowedHowMany, String borrowedDisName, double borrowedDisRate, double borrowedDisAmt, double borrowedDisPrice, double borrowedSubTotal, double borrowedTaxRate, double borrowedTaxAmt, double borrowedTotalCost, String borrowedPrizeName)
	{
		//format and display receipt
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("ORDER REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("");
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("");
		System.out.printf("%-20s%-5s%-10s\n","Item Purchase:","",borrowedItemName);
		System.out.printf("%-25s%-2s%4.2f\n","The items Price:","$",borrowedItemPrice);
		System.out.println("");
		System.out.printf("%-20s%-5s%-10s\n","Discount Name:","",borrowedDisName);
		System.out.printf("%-27s%-2.1f%-4.2s\n","Discount Rate:",borrowedDisRate*100,"%");
		System.out.printf("%-25s%-2s%-8.2f\n","Discount Amount:","$",borrowedDisAmt);
		System.out.printf("%-25s%-2s%-8.2f\n","Discount Price:","$",borrowedDisPrice);
		System.out.println("");
		System.out.printf("%-24s%-2s%2s\n","Quantity:","",borrowedHowMany);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Sub Total: ","$",borrowedSubTotal);
		System.out.printf("%-27s%-2.1f%-8.2s\n","Tax Rate: ",borrowedTaxRate*100,"%");
		System.out.printf("%-25s%-2s%-8.2f\n","Tax Amount: ","$",borrowedTaxAmt);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Total Cost: ","$",borrowedTotalCost);
		System.out.printf("%-20s%-2s%8s\n","Prize earned:","",borrowedPrizeName);
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
	}
	public static void displayItemReceipt(String borrowedUserName, String borrowedItemName, double borrowedItemPrice, int borrowedHowMany, double borrowedSubTotal, double borrowedTaxRate, double borrowedTaxAmt, double borrowedTotalCost, String borrowedPrizeName)
	{
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("ORDER REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("");
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("");
		System.out.printf("%-20s%-5s%-10s\n","Item Purchase:","",borrowedItemName);
		System.out.printf("%-25s%-2s%4.2f\n","The items Price:","$",borrowedItemPrice);
		System.out.println("");
		System.out.printf("%-24s%-2s%2s\n","Quantity:","",borrowedHowMany);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Sub Total: ","$",borrowedSubTotal);
		System.out.printf("%-27s%-2.1f%-8.2s\n","Tax Rate: ",borrowedTaxRate*100,"%");
		System.out.printf("%-25s%-2s%-8.2f\n","Tax Amount: ","$",borrowedTaxAmt);
		System.out.println("");
		System.out.printf("%-25s%-2s%-8.2f\n","Total Cost: ","$",borrowedTotalCost);
		System.out.printf("%-20s%-2s%8s\n","Prize earned:","",borrowedPrizeName);
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
	}
	
	public static void displayFinalReport(String[] borrowedItemName, int[] borrowedItemCount, String[] borrowedDiscountName, int[] borrowedDiscountCount, String[] borrowedPrizeName, int[] borrowedPrizeCount, int[] borrowedStockCount)
	{
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		System.out.println("ORDER REPORT");
		System.out.println("~~~~~ ~~~~~~ ~~~~~ ~~~~ ~~~~ ~~~~~~");
		
		System.out.printf("%-1s%-2s%8s\n",borrowedItemName[0]," count:",borrowedItemCount[0]);
		System.out.printf("%-1s%-2s%8s\n",borrowedItemName[1]," count:",borrowedItemCount[1]);
		System.out.printf("%-3s%-2s%10s\n",borrowedItemName[2]," count:",borrowedItemCount[2]);
		System.out.println("");
		System.out.printf("%-6s%-2s%13s\n",borrowedDiscountName[0]," count:",borrowedDiscountCount[0]);
		System.out.printf("%-6s%-2s%13s\n",borrowedDiscountName[1]," count:",borrowedDiscountCount[1]);
		System.out.printf("%-1s%-2s%8s\n",borrowedDiscountName[2]," count:",borrowedDiscountCount[2]);
		System.out.println("");
		System.out.printf("%-1s%-2s%14s\n",borrowedPrizeName[0]," count:",borrowedPrizeCount[0]);
		System.out.printf("%-1s%-2s%11s\n",borrowedPrizeName[1]," count:",borrowedPrizeCount[1]);
		System.out.printf("%-1s%-2s%9s\n",borrowedPrizeName[2]," count:",borrowedPrizeCount[2]);
		System.out.println("");
		System.out.printf("%-1s%-2s%5s\n",borrowedItemName[0]," in Stock:",borrowedStockCount[0]);
		System.out.printf("%-1s%-2s%5s\n",borrowedItemName[1]," in Stock:",borrowedStockCount[1]);
		System.out.printf("%-3s%-2s%7s\n",borrowedItemName[2]," in Stock:",borrowedStockCount[2]);
	}
}
