//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help make an easy online experience for the human resource department.
//DATE: February 25 2020
package edu.cpt187.allen.finalexam;

import java.util.Scanner;

public class MainClass 
{

	public static final String[] MAIN_MENU_OPTIONS = {"Load a file","Quit"};
	public static final String[] SEARCH_MENU_OPTIONS = {"Search for an ID","Return to the Main Menu"};

	public static final String[] BONUS_MENU_OPTIONS = {"Process Bonus","Return to the Search Menu"};
	public static final String MASTER_FILE_NAME = "MasterOrderFile.txt";		

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';

		HumanResources currentResources = new HumanResources();
		RecordWriter writtenRecord = new RecordWriter(MASTER_FILE_NAME);


		//DISPLAY welcome Banner
		displayWelcomeBanner();

		//gets and displays userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMainMenu(input);

		//run-while
		while(menuSelection != 'Q')
		{
			//input file
			currentResources.setLoadArrays(getFileName(input));

			//run if else
			if(currentResources.getRecordCount() <= 0)
			{
				//display file error
				displayFileError();
			}//end of if
			else
			{
				menuSelection = validateSearchSelection(input);

				//run while
				while(menuSelection != 'B')
				{
					currentResources.setSearchIndex(validateSearchID(input));
					if(currentResources.getSearchedIndex() < 0)
					{
						displaySearchResult();
					}
					else
					{
						displaySearchResult(currentResources.getEmployeeID(), currentResources.getEmployeeName(), currentResources.getBonusPerSale());

						//display and input purchase menu
						menuSelection = validateBonusSelection(input);
						//run if
						if(menuSelection == 'A')
						{
							currentResources.setHowMany(validateHowMany(input));
							currentResources.getOrderQuantitys();
							//records the inputs into the master file
							writtenRecord.setSaveOneRecord(currentResources.getEmployeeID(), currentResources.getEmployeeName(), currentResources.getBonusPerSale(), currentResources.getHowMany(), currentResources.getTotalCost());
							//display confirmation
							displayRequestReport(currentResources.getEmployeeID(), currentResources.getHowMany(), currentResources.getTotalCost());

						}//end of if
					}//end of else
					menuSelection = validateSearchSelection(input);
				}//end of while

				//run if
				if(currentResources.getSearchCount() > 0)
				{
					displaySearchReport(userName, currentResources.getSearchCount(), currentResources.getSearchesFound(), currentResources.getSearchesNotFound());
				}//end of if
			}//end of else

			menuSelection = validateMainMenu(input);
		}//end of while

		if(currentResources.getFilesFound() > 0)
		{
			displayFileReport(userName, currentResources.getFileCount(), currentResources.getFilesFound(), currentResources.getFilesNotFound());
			//run if
			if(writtenRecord.getRecordCount() > 0)
			{
				currentResources.setLoadArrays(writtenRecord.getFileName(), currentResources.getRecordCount());
				displayFinalReport(currentResources.getRecordCount(), currentResources.getEmployeeIDs(), currentResources.getEmployeeNames(), currentResources.getBonusPerSales(), currentResources.getOrderQuantitys(), currentResources.getOrderTotals(), currentResources.getWrittenOrderTotalCost(), currentResources.getWrittenOrderQuantity());
			}
		}

		//DISPLAY farewell message
		displayFarewellMessage();

		//close Scanner
		input.close();

	}//end of main method

	//Welcome banner
	public static void displayWelcomeBanner() 
	{
		System.out.println("******************************************");
		System.out.println("welcome to the Human Resource Department website");
		System.out.println("this site will let you import record fields");
		System.out.println("from a file, and enter the ID number");
		System.out.println("and the employee's name and their bonus sales.");
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
	public static void displayMainMenu() 
	{
		System.out.println("MAIN MENU");
		System.out.println("[A] for " +MAIN_MENU_OPTIONS[0]);
		System.out.println("[Q] for " +MAIN_MENU_OPTIONS[1]);
		System.out.println("Enter your selection here");

	}//end of Display method

	public static char validateSearchSelection(Scanner borrowedInput)
	{
		char localMenuSelection = ' ';
		//Main Menu
		displaySearchMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'A' && localMenuSelection != 'B') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displaySearchMenu();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}
	public static void displaySearchMenu() 
	{
		System.out.println("");
		System.out.println("SEARCH MENU");
		System.out.println("[A] for " +SEARCH_MENU_OPTIONS[0]);
		System.out.println("[B] for " +SEARCH_MENU_OPTIONS[1]);
		System.out.println("Enter your selection here");

	}//end of Display method

	//display the purchase menu
	public static void displayBonusSelection() 
	{
		System.out.println("");
		System.out.println("BONUS MENU");
		System.out.println("[A] for " +BONUS_MENU_OPTIONS[0]);
		System.out.println("[B] for " +BONUS_MENU_OPTIONS[1]);
		System.out.println("Enter your selection here");

	}//end of Display method

	public static char validateBonusSelection(Scanner borrowedInput)
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayBonusSelection();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'A' && localMenuSelection != 'B') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayBonusSelection();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}//end of validateBonusSelection

	public static String getFileName(Scanner borrowedInput)
	{
		//declare local variables
		String localFileName = "";
		System.out.println("");
		System.out.println("Input the file Name for the product records:");
		localFileName = borrowedInput.next();

		return localFileName;
	}//end of getFileName

	//display howMany question
	public static void displayHowMany() 
	{
		System.out.println("How many of Bonus Rate would you like");
	}
	//user input HowMany
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

	//display purchase report
	public static void displayRequestReport(String borrowedID, int borrowedHowMany, double borrowedTotal)
	{
		System.out.println("REQUEST CONFIRMATION");
		System.out.println("");
		System.out.printf("%-10s%-7s%-1s","ITEM ID","QTY","TOTAL");
		System.out.println("");
		System.out.printf("%-2s%-3s%-6s%-1s%-1s%-5s%-2s%-1.2f%-1s","[",borrowedID,"]","[",borrowedHowMany,"]","$[",borrowedTotal,"]");
		System.out.println("");
		System.out.println("records have been Updated");
	}
	//validate Search ID
	public static int validateSearchID(Scanner borrowedInput) 
	{
		int localID = 0;

		System.out.println("Input the Item ID# to search:");
		localID = borrowedInput.nextInt();

		//validate input

		while(localID <= 0) 
		{
			System.out.println("Please enter the numbers greater than ZERO");
			System.out.println("");
			System.out.println("Input the Item ID# to search:");
			localID = borrowedInput.nextInt();
		}
		return localID;
	}	

	//display File error
	public static void displayFileError()
	{
		System.out.println("File Not Found");
		System.out.println("Please try and check the file name again.");
	}

	//display error Search Result
	public static void displaySearchResult()
	{
		System.out.println("SEARCH RESULT REPORT");
		System.out.println("ID not Found");
	}

	//display search Result
	public static void displaySearchResult(String borrowedID, String borrowedTitle, double borrowedPrice)
	{	

		System.out.println("SEARCH RESULTS REPORT");
		System.out.printf("%-10s%-13s%-1s","ITEM ID","TITLE","PRICE");
		System.out.println("");
		System.out.printf("%-1s%-1s%-6s%-1s%-1s%-6s%-2s%-1s%-1s%-1s","[",borrowedID,"]","[",borrowedTitle,"]","$","[",borrowedPrice,"]");

	}

	//displayFarewellMessage
	public static void displayFarewellMessage()
	{
		System.out.println("");
		System.out.println("Thank you for using the Human Resource");
		System.out.println("website. We hope you have a nice day!");
	}


	//display Search Report
	public static void displaySearchReport(String borrowedUserName, int borrowedSearch, int borrowedSearchFound, int borrowedSearchNot)
	{
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("SEARCH COUNT REPORT");
		System.out.printf("%-15s%-17s%-1s\n","SEARCH COUNT","IDs FOUND","IDs NOT FOUND");
		System.out.printf("%-1s%-1s%-13s%-1s%-1s%-15s%-1s%-1s%-1s\n","[",borrowedSearch,"]","[",borrowedSearchFound,"]","[",borrowedSearchNot,"]");

	}
	//display Order report
	public static void displayFinalReport(int borrowedRecordCount, String[] borrowedID, String[] borrowedTitle, double[] borrowedPrice, int[] borrowedQty, double[] borrowedTotal,  double borrowedTotalCost, int borrowedWrittenQty)
	{	

		int localIndex = 0;
		System.out.println("SEARCH RESULTS REPORT");
		System.out.printf("%-10s%-13s%-11s%-6s%-1s\n","ITEM ID","TITLE","PRICE","QTY","TOTAL");
		while (localIndex < borrowedRecordCount)
		{
			if(borrowedTitle[localIndex] != null)
			{
				System.out.printf("%-1s%-1s%-6s%-1s%-1s%-6s%-2s%-1s%-3s%-1s%-1s%-4s%-2s%-4s%-1s\n","[",borrowedID[localIndex],"]","[",borrowedTitle[localIndex],"]","$ [",borrowedPrice[localIndex],"]","[",borrowedQty[localIndex],"]","$[",borrowedTotal[localIndex],"]");
			}
			localIndex++;
		}
		System.out.printf("%-17s%-1s","ITEM COUNT","ORDER TOTAL");
		System.out.println("");
		System.out.printf("%-2s%-2s%-13s%-2s%-4.2f%-1s","[",borrowedWrittenQty,"]","$[",borrowedTotalCost,"]");
	}


	//display final report
	public static void displayFileReport(String borrowedUserName, int borrowedFile, int borrowedFileFound, int borrowedFileNot)
	{
		System.out.printf("%-18s%-2s%8s\n","Customer's Name:","",borrowedUserName);
		System.out.println("FILE PROCESSING REPORT");
		System.out.printf("%-15s%-17s%-1s\n","FILE COUNT","FILEs FOUND","FILEs NOT FOUND");
		System.out.printf("%-1s%-1s%-13s%-1s%-1s%-13s%-1s%-1s%-1s\n","[",borrowedFile,"]","[",borrowedFileFound,"]","[",borrowedFileNot,"]");

	}

}
