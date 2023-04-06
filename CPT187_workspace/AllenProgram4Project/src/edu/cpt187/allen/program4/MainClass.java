//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Create a simulation for Metro and Express trains stations.
//DATE: February 5 2020
package edu.cpt187.allen.program4;
import java.util.Scanner;

public class MainClass 
{
	public static final String[] MAIN_MENU_OPTIONS = {"Metropolitan Train opertions", "Express Train operations", "Quit"};
	public static final String[] SUB_MENU_OPTIONS = {"Return to the Simulation Menu", "Create a Metropolitan Train Simulation", "Run a Metropolitan Train Simulation",  "Create an Express Train Simulation", "Run an Express Train Simulation"};
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		//local variables 
		String userName = "";
		char menuSelection = ' ';

		//Create instance from the supportive class 
		SubwayTrain currentTrain = new SubwayTrain();

		Stations homeStation = new Stations();
		Stations stationN = new Stations();

		//DISPLAY welcome banner
		displayWelcomeBanner();


		//user inputs userName
		userName = getUserName(input);

		//Prime read of MenuSelection
		menuSelection = validateMenuSelection(input);

		//run While
		while(menuSelection != 'Q')
		{
			//run if
			if(menuSelection == 'A')
			{
				menuSelection = validateMetropolisSelection(input);
				//run metro while
				while(menuSelection != 'R')
				{
					//run metro if
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
							displayDepartingAnnouncement(currentTrain.getCurrentStationIndex(), currentTrain.getNumberOnBoard());

							currentTrain.setMoveStation();


							while(currentTrain.getStopCounter() < currentTrain.getMaximumStops())
							{
								//display Arrival
								displayArrivalAnnouncement(currentTrain.getCurrentStationIndex());
								currentTrain.setUnloadPassengers();

								displayUnloadingAnnouncement(currentTrain.getNumberUnloaded(),  currentTrain.getNumberOnBoard());
								currentTrain.setLoadPassengers();

								displayLoadingAnnouncement(currentTrain.getNumberLoaded());

								displayDepartingAnnouncement(currentTrain.getCurrentStationIndex(), currentTrain.getNumberOnBoard());
								currentTrain.setMoveStation();
							} 

							displayArrivalAnnouncement(currentTrain.getCurrentStationIndex());

							currentTrain.setUnloadAllPassengers();
							displayUnloadingAnnouncement(currentTrain.getNumberUnloaded(), currentTrain.getNumberOnBoard());

							displayEndOfSimReport(currentTrain.getMaximumCapacity(), currentTrain.getNumberOfStations(), currentTrain.getStations(), currentTrain.getStopCounter());
							currentTrain.setResetMetroSimulation();
						}
					}
					//begin loop
					menuSelection = validateMetropolisSelection(input);
				}//end of metro while
				menuSelection = validateMenuSelection(input);
			}
			else
			{
				menuSelection = validateExpressSelection(input);
				//run Express while
				while(menuSelection != 'R')
				{
					if(menuSelection == 'A')
					{
						currentTrain.setNumberOfStations();

						currentTrain.setHomeStation(validateHomeStation(input));

						currentTrain.setStations(validateStationN(input));

						currentTrain.setMaximumCapacity(validateMaxTrainCapacity(input));
						homeStation.setMaximumCapacity(currentTrain.getMaximumCapacity());
						stationN.setMaximumCapacity(currentTrain.getMaximumCapacity());
					}
					else
					{
						if(homeStation.getMaximumCapacity() <=0)
						{
							displaySimulationError();
						}
						else
						{
							homeStation.setPassengersWaiting();
							stationN.setPassengersWaiting();

							displayWaitingAnnouncement(homeStation.getPassengersWaiting(), stationN.getPassengersWaiting());

							currentTrain.setLoadFromStation(homeStation);

							displayLoadingAnnouncement(currentTrain.getNumberLoaded());

							displayDepartingAnnouncement(currentTrain.getCurrentStationIndex(), currentTrain.getNumberOnBoard());

							currentTrain.setMoveStation();

							while(homeStation.getPassengersWaiting() > 0 || stationN.getPassengersWaiting() > 0)
							{
								displayArrivalAnnouncement(currentTrain.getCurrentStationIndex());

								currentTrain.setUnloadAllPassengers();
								displayUnloadingAnnouncement(currentTrain.getNumberUnloaded(),  currentTrain.getNumberOnBoard());
								currentTrain.setLoadFromStation(homeStation, stationN);

								displayLoadingAnnouncement(currentTrain.getNumberLoaded());

								displayDepartingAnnouncement(currentTrain.getCurrentStationIndex(), currentTrain.getNumberOnBoard());

								currentTrain.setMoveStation();
							
							if(Integer.valueOf(currentTrain.getCurrentStationIndex()) != Integer.valueOf(currentTrain.getHomeStation()))
								{
									displayDepartingAnnouncement(currentTrain.getCurrentStationIndex(), currentTrain.getNumberOnBoard());

									currentTrain.setMoveStation();
								}
							}
							displayArrivalAnnouncement(currentTrain.getCurrentStationIndex());

							displayEndOfSimReport(currentTrain.getMaximumCapacity(), currentTrain.getNumberOfStations(), currentTrain.getStations(), currentTrain.getStopCounter());

							currentTrain.setResetExpressSimulation();
						}
					}
					menuSelection = validateExpressSelection(input);
				}//end of Express While
				menuSelection = validateMenuSelection(input);
			}
		}//end of first while

		if(currentTrain.getCreateMetroCounter() > 0 || currentTrain.getCreateExpressCounter() > 0)
		{
			displayUsageReport(userName, currentTrain.getCreateMetroCounter(), currentTrain.getRunMetroCounter(),  currentTrain.getCreateExpressCounter(), currentTrain.getRunExpressCounter());
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
		System.out.println("[A] to " +MAIN_MENU_OPTIONS[0]);
		System.out.println("[B] to " +MAIN_MENU_OPTIONS[1]);
		System.out.println("[Q] to " +MAIN_MENU_OPTIONS[2]);
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


	public static void displayMetroMenu() 
	{
		System.out.println("METRO MENU");
		System.out.println("[R] to " +SUB_MENU_OPTIONS[0]);
		System.out.println("[A] to " +SUB_MENU_OPTIONS[1]);
		System.out.println("[B] to " +SUB_MENU_OPTIONS[2]);
		System.out.println("Enter your selection here");
	}//end of DisplayMainMenu


	//VR Method
	public static char validateMetropolisSelection(Scanner borrowedInput) 
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayMetroMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'R' && localMenuSelection != 'A' && localMenuSelection != 'B') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayMetroMenu();
			localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMenuSelection;
	}//end of VR method

	public static void displayExpressMenu() 
	{
		System.out.println("METRO MENU");
		System.out.println("[R] to " +SUB_MENU_OPTIONS[0]);
		System.out.println("[A] to " +SUB_MENU_OPTIONS[3]);
		System.out.println("[B] to " +SUB_MENU_OPTIONS[4]);
		System.out.println("Enter your selection here");
	}//end of DisplayMainMenu


	//VR Method
	public static char validateExpressSelection(Scanner borrowedInput) 
	{
		char localMenuSelection = ' ';
		//Main Menu
		displayExpressMenu();
		localMenuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(localMenuSelection != 'R' && localMenuSelection != 'A' && localMenuSelection != 'B') 
		{
			System.out.println("\nInvalid Selection please try again.\n");
			displayExpressMenu();
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

	public static void displayStationsN()
	{
		System.out.println("What is the Number of next Station");
	}

	public static int validateStationN(Scanner borrowedInput)
	{
		int localNoOfStations = 0;
		displayStationsN();
		localNoOfStations = borrowedInput.nextInt();
		//validate input

		while(localNoOfStations <= 0) 
		{
			System.out.println("Please choose a quantity greater than ZERO");
			displayStationsN();
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

	public static void displayWaitingAnnouncement(int borrowedCurrentPassengers, int borrowedNPassengers)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Waiting Announcement:");
		System.out.printf("%-19s%-1s\n","Home Station","Next Station");
		System.out.printf("%-19s%-1s\n","Passengers","Passengers");
		System.out.printf("%-1s%-1s%-19s%-1s%-1s%-1s"," [",borrowedCurrentPassengers,"]","[",borrowedNPassengers,"]");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	public static void displayDepartingAnnouncement(int borrowedCurrentStation, int borrowedNumOnBoard)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Departing Announcement:");
		System.out.printf("%-12s%-1s\n","Leaving","Passengers");
		System.out.printf("%-12s%-1s\n","Station","Onboard");
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
	public static void displayUnloadingAnnouncement(int borrowedNumberUnloaded, int borrowedNumOnBoard)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Unloading Announcement:");
		System.out.printf("%-14s%-1s\n","Now","Passengers");
		System.out.printf("%-14s%-1s\n","Unloading","Onboard");
		System.out.printf("%-1s%-1s%-11s%-1s%-1s%-1s"," [",borrowedNumberUnloaded,"]","[",borrowedNumOnBoard,"]");
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
	public static void displayUsageReport(String borrowedUserName, int borrowedCreateMetroCounter, int borrowedRunMetroCounter, int borrowedCreateExpressCounter, int borrowedRunExpressCounter)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%-18s%-2s%8s\n","User Name:","",borrowedUserName);
		System.out.printf("%-18s%-2s%8s\n","Metro Sims Created:","",borrowedCreateMetroCounter);
		System.out.printf("%-19s%-2s%8s\n","Metro Sims Runned:","",borrowedRunMetroCounter);
		System.out.printf("%-15s%-2s%6s\n","Express Sims Created:","",borrowedCreateExpressCounter);
		System.out.printf("%-16s%-2s%7s\n","Express Sims Runned:","",borrowedRunExpressCounter);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public static void displayFarewellMessage()
	{
		System.out.println("Thank you for using our train simulator");
		System.out.println("We hope you have a nice day!");
	}
}
