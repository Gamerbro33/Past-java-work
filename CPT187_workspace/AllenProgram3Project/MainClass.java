//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Create a simulation for subway trains stations.
//DATE: January 28 2020
package edu.cpt187.allen.Program3;
import java.util.Scanner;

public class MainClass 
{
	public static final String[] MENU_OPTIONS = {"Create a Metropolitan Train simulation","Run a metropoltian Train simulation","Quit"};
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';

		//Create instance from the supportive class 
		SubwayTrain currentTrain = new SubwayTrain();

		//DISPLAY welcome banner
		displayWelcomeBanner();


		//user inputs userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMenuSelection(input);

		//run-while
		while(menuSelection != 'Q')
		{
			//run if else
			if(menuSelection == 'A')
			{
				currentTrain.setNumberOfStations(validateNumberOfStations(input));

				currentTrain.setHomeStation(validateHomeStation(input));

				currentTrain.setMaximumCapacity(validateMaxTrainCapacity(input));
				//these will invoke behaviors in the supportive class
				currentTrain.setMaximumStops();
				currentTrain.setStations();
				//menuSelection = validateMenuSelection(input);
			}


			else
			{
				if(currentTrain.getMaximumCapacity() <= 0)
				{
					//DISPLAY simulation ERROR
					displaySimulationError();
				}
				else
				{
					currentTrain.setLoadPassengers();
					//Display loading announcement
					displayLoadingAnnouncement(currentTrain.getNumberLoaded());

					//DISPLAY departing Announcement
					displayDepartingAnnouncement(currentTrain.getCurrentStation(), currentTrain.getNumberOnBoard());

					currentTrain.setMoveStation();


					while(currentTrain.getStopCounter() < currentTrain.getMaximumStops())
					{
						//display Arrival
						displayArrivalAnnouncement(currentTrain.getCurrentStation());
						currentTrain.setUnloadPassengers();

						displayUnloadingAnnouncement(currentTrain.getNumberUnloaded());
						currentTrain.setLoadPassengers();

						displayLoadingAnnouncement(currentTrain.getNumberLoaded());

						displayDepartingAnnouncement(currentTrain.getCurrentStation(), currentTrain.getNumberOnBoard());
						currentTrain.setMoveStation();
					} 

					displayArrivalAnnouncement(currentTrain.getCurrentStation());

					currentTrain.setUnloadAllPassengers();
					displayUnloadingAnnouncement(currentTrain.getNumberUnloaded());

					displayEndOfSimReport(currentTrain.getMaximumCapacity(), currentTrain.getNumberOfStations(), currentTrain.getStations(), currentTrain.getStopCounter());
					currentTrain.setResetSimulation();
				}
			}
			//begin loop
			menuSelection = validateMenuSelection(input);
		}//end of while

		if(currentTrain.getCreateCounter() > 0)
		{
			displayUsageReport(userName, currentTrain.getCreateCounter(), currentTrain.getRunCounter());
		}
		//Display Farewell message
		displayFarewellMessage();
	}//end of main method

	public static void displayWelcomeBanner()
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to the Metropolis Subway Train Simulator.");
		System.out.println("You start a sumlation of loading and unloading passengers.");
		System.out.println("The train will be going to diffenent stations,");
		System.out.println("and in the end it will show the stations you stopped at");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

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
		System.out.println("[B] to " +MENU_OPTIONS[1]);
		System.out.println("[Q] to " +MENU_OPTIONS[2]);
		System.out.println("Enter your selection here");
	}//end of DisplayMainMenu


	//Main Menu
	//VR Method
	public static char validateMenuSelection(Scanner borrowedInput) 
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayMainMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'A' && localMenuSelection != 'B' && localMenuSelection != 'Q') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayMainMenu();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}//end of VR method

	public static int validateNumberOfStations(Scanner borrowedInput)
	{
		int localNoOfStations = 0;
		displayNumberOfStationsQ();
		localNoOfStations = borrowedInput.nextInt();
		//validate input

		while(localNoOfStations <= 0) 
		{
			System.out.println("Please choose a quantity greater than ZERO");
			displayNumberOfStationsQ();
			localNoOfStations = borrowedInput.nextInt();
		}
		return localNoOfStations;
	}//end of howMany VR Method

	public static void displayNumberOfStationsQ()
	{
		System.out.println("How many Stations are in route");
	}

	public static int validateHomeStation(Scanner borrowedInput)
	{
		int localHomeStations = 0;
		displayHomeStationsQ();
		localHomeStations = borrowedInput.nextInt();
		//validate input

		while(localHomeStations <= 0) 
		{
			System.out.println("Please choose a quantity greater than ZERO");
			displayNumberOfStationsQ();
			localHomeStations = borrowedInput.nextInt();
		}
		return localHomeStations;
	}//end of howMany VR Method

	public static void displayHomeStationsQ()
	{
		System.out.println("Enter Home Station's number");
	}

	public static int validateMaxTrainCapacity(Scanner borrowedInput)
	{
		int localCapacity = 0;
		displayCapacityQ();
		localCapacity = borrowedInput.nextInt();
		//validate input

		while(localCapacity <= 0) 
		{
			System.out.println("Please choose a quantity greater than ZERO");
			displayCapacityQ();
			localCapacity = borrowedInput.nextInt();
		}
		return localCapacity;
	}//end of howMany VR Method

	public static void displayCapacityQ()
	{
		System.out.println("Enter the max capacity of people your train can hold");
	}

	public static void displaySimulationError()
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("It would appear that there is an error");
		System.out.println("in the simulation. Please note that you must create");
		System.out.println("a simulation before you run a simulation please try again.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public static void displayLoadingAnnouncement(int borrowedNumberLoaded)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Loading Announcement:");
		System.out.printf("%-16s%-1s%-1s%-1s","Now Loading: ","[",borrowedNumberLoaded,"]passengers");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	public static void displayDepartingAnnouncement(int borrowedCurrentStation, int borrowedNumOnBoard)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Departing Announcement:");
		System.out.println("Leaving     Passengers");
		System.out.println("Station      Onboard");
		System.out.printf("%-1s%-1s%-11s%-1s%-1s%-1s"," [",borrowedCurrentStation,"]","[",borrowedNumOnBoard,"]");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
	public static void displayArrivalAnnouncement(int borrowedCurrentStation)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Arrival Announcement:");
		System.out.printf("%-16s%-1s%-1s%-1s","Arriving at: ","Station[",borrowedCurrentStation,"]");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
	public static void displayUnloadingAnnouncement(int borrowedNumberUnloaded)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Unloading Announcement:");
		System.out.printf("%-17s%-1s%-1s%-1s","Now Unloading: ","[",borrowedNumberUnloaded,"]passengers");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
	public static void displayEndOfSimReport(int borrowedMaxCapacity, int borrowedNumbOfStations, String[] borrowedStations, int borrowedStopCounter)
	{
		int localIndex = 0;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Simulation Report");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%-27s%-2s%-4s\n","Train's Max Capacity:",borrowedMaxCapacity," Passengers");
		System.out.printf("%-27s%-2s%-4s\n","Number of stations:",borrowedNumbOfStations," Stations");
		while(localIndex < borrowedStations.length)
		{
			System.out.printf("%-18s%-1s%-8s%-7s\n","Names of stations",localIndex,":",borrowedStations[localIndex]);
			localIndex++;
		}
		System.out.printf("%-27s%-2s%-4s\n","Totals stops made:",borrowedStopCounter,"");

	}

	public static void displayUsageReport(String borrowedUserName, int borrowedCreateCounter, int borrowedRunCounter)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%-18s%-2s%8s\n","User Name:","",borrowedUserName);
		System.out.printf("%-18s%-2s%8s\n","Sims Created:","",borrowedCreateCounter);
		System.out.printf("%-18s%-2s%8s\n","Sims Runned:","",borrowedRunCounter);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public static void displayFarewellMessage()
	{
		System.out.println("Thank you for using our train simulator");
		System.out.println("We hope you have a nice day!");
	}
}
