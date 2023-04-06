//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Supports the main class for simulating a train of overloaded method.
//DATE: February 5 2020
package edu.cpt187.allen.program4;
import java.util.Random;

public class SubwayTrain 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final int ZERO = 0;
	private final int TWO = 2;


	//declare and initialize all nonCONSTANTS class attributes
	private int numberOfStations = 0;
	private int maximumStops = 0;
	private int homeStation = 0;
	private String[] stations;
	private int createMetroCounter = 0;
	private int runMetroCounter = 0;
	private int createExpressCounter = 0;
	private int runExpressCounter = 0;
	private int maximumCapacity = 0;
	private int stopCounter = 0;
	private int currentStationIndex = 0;
	private int numberOnBoard = 0;
	private int numberLoaded= 0;
	private int numberUnloaded = 0;
	private Random ranNumGenerator = new Random();

	//SubwayTrain class constructor
	public SubwayTrain()
	{
	}//end of class constructor

	//set method
	//method that will Assign the value of Express' numberOfStations
	public void setNumberOfStations()
	{
		numberOfStations = TWO;
		createExpressCounter++;
	}//end of setNumberOfStations

	//set method
	//method that will Assign the value of metro's numberOfStations
	public void setNumberOfStations(int borrowedNoOfStations)
	{
		numberOfStations = borrowedNoOfStations;
		createMetroCounter++;
	}//end of setNumberOfStations

	//set method
	//method that will Assign the value of maximumStops
	public void setMaximumStops()
	{
		maximumStops = (numberOfStations * TWO) - TWO;
	}//end of setMaximumStops

	//set method
	//method that will Assign the value of homeStations
	public void setHomeStation(int borrowedHomeStation)
	{
		homeStation = borrowedHomeStation;
	}//end of setHomeStation

	//set method
	//method that will Assign the value of metro's stations
	public void setStations()
	{
		int localIndex = 0;
		stations = new String[numberOfStations];

		while(localIndex < stations.length)
		{
			stations[localIndex] = String.valueOf(homeStation + localIndex);
			localIndex++;
		}
	}//end of setStations

	//set method
	//method that will Assign the value of express' stations
	public void setStations(int borrowedStationN)
	{
		stations = new String[numberOfStations];
		stations[0] = String.valueOf(homeStation);
		stations[1] = String.valueOf(borrowedStationN);
	}//end of setStations

	//set method
	//method that will Assign the value of maximumCapacity
	public void setMaximumCapacity(int borrowedMaxCapacity)
	{
		maximumCapacity = borrowedMaxCapacity;
	}//end of setMaximumCapacity

	//set method
	public void setMoveStation()
	{
		stopCounter++;
		if(stopCounter < numberOfStations)
		{
			currentStationIndex = stopCounter;
		}
		else if(numberOfStations == TWO && currentStationIndex == ZERO)
		{
			currentStationIndex = currentStationIndex + 1;
		}
		else
		{
			currentStationIndex = currentStationIndex - 1;
		}
	}//end of setMoveStation

	//set method

	public void setLoadFromStation(Stations borrowedHomeStation)
	{	
		int localPassengersWaiting = borrowedHomeStation.getPassengersWaiting();

		if(localPassengersWaiting > maximumCapacity - numberOnBoard)
		{
			numberLoaded = maximumCapacity - numberOnBoard;
		}
		else
		{
			numberLoaded = localPassengersWaiting;
		}

		numberOnBoard = numberOnBoard + numberLoaded;
		borrowedHomeStation.setReducedNumberWaiting(numberLoaded);

	}//end of setLoadFromStation

	//set method
	public void setLoadFromStation(Stations borrowedHomeStation, Stations borrowedStationN)
	{
		int localPassengersWaiting = getRandomNumber();
		if(currentStationIndex == 0)
		{
			localPassengersWaiting = borrowedHomeStation.getPassengersWaiting();
			if(localPassengersWaiting > maximumCapacity - numberOnBoard)
			{
				numberLoaded = maximumCapacity - numberOnBoard;
			}
			else
			{
				numberLoaded = localPassengersWaiting;
			}
			numberOnBoard = numberOnBoard + numberLoaded;
			borrowedHomeStation.setReducedNumberWaiting(numberLoaded);
		}
		else
		{
			localPassengersWaiting = borrowedStationN.getPassengersWaiting();
			if(localPassengersWaiting > maximumCapacity - numberOnBoard)
			{
				numberLoaded = maximumCapacity - numberOnBoard;
			}
			else
			{
				numberLoaded = localPassengersWaiting;
			}
			numberOnBoard = numberOnBoard + numberLoaded;
			borrowedStationN.setReducedNumberWaiting(numberLoaded);

		}

	}//end of setLoadFromStation


	//set method
	public void setLoadPassengers()
	{
		int localPassengersWaiting = getRandomNumber();
		if(localPassengersWaiting > maximumCapacity - numberOnBoard)
		{
			numberLoaded = maximumCapacity - numberOnBoard;
		}
		else
		{
			numberLoaded = localPassengersWaiting;
		}
		numberOnBoard = numberOnBoard + numberLoaded;
	}//end of setLoadPassengers

	//set method
	public void setUnloadPassengers()
	{
		int localPassengersWaiting = getRandomNumber();
		if(localPassengersWaiting > numberOnBoard)
		{
			numberUnloaded = numberOnBoard;
		}
		else
		{
			numberUnloaded = localPassengersWaiting;
		}
		numberOnBoard = numberOnBoard - numberUnloaded;
	}//end of setUnloadPassengers

	//set method
	public void setUnloadAllPassengers()
	{
		numberUnloaded = numberOnBoard;
		numberOnBoard = numberOnBoard - numberUnloaded;
		
	}//end of setUnloadAllPassengers


	//set method
	public void setResetMetroSimulation()
	{
		stopCounter = ZERO;
		currentStationIndex = ZERO;
		runMetroCounter++;
	}//end of setUnloadAllPassengers

	//set method
	public void setResetExpressSimulation()
	{
		stopCounter = ZERO;
		currentStationIndex = ZERO;
		runExpressCounter++;
	}//end of setUnloadAllPassengers

	//get method
	//method that will Return the value of ranNumber
	public int getRandomNumber()
	{
		return ranNumGenerator.nextInt(maximumCapacity * TWO);
	}//end of getRandomNumber

	//get method
	//method that will Return the value of ranNumber
	public int getNumberOfStations()
	{
		return numberOfStations;
	}//end of getNumberOfStations

	//get method
	//method that will Return the value of maxiumumStops
	public int getMaximumStops()
	{
		return maximumStops;
	}

	//get method
	//method that will Return the value of homeStation
	public int getHomeStation()
	{
		return homeStation;
	}

	//get method
	//method that will Return the value of stations
	public String[] getStations()
	{
		return stations;
	}

	//get method
	//method that will Return the value of createMetroCounter
	public int getCreateMetroCounter()
	{
		return createMetroCounter;
	}

	//get method
	//method that will Return the value of RunMetroCounter
	public int getRunMetroCounter()
	{
		return runMetroCounter;
	}

	//get method
	//method that will Return the value of createExpressCounter
	public int getCreateExpressCounter()
	{
		return createExpressCounter;
	}

	//get method
	//method that will Return the value of RunExpressCounter
	public int getRunExpressCounter()
	{
		return runExpressCounter;
	}

	//get method
	//method that will Return the value of maximumCapacity
	public int getMaximumCapacity()
	{
		return maximumCapacity;

	}//end of getMaximumCapacity

	//get method
	//method that will Return the value of maximumCapacity
	public int getStopCounter()
	{
		return stopCounter;
	}//end of getStopCounter

	//get method
	//method that will Return the value of currentStationIndex
	public int getCurrentStationIndex()
	{
		return Integer.parseInt(stations[currentStationIndex]);

	}//end of getCurrentStationIndex

	public int getNumberOnBoard()
	{
		return numberOnBoard;
	}

	public int getNumberLoaded()
	{
		return numberLoaded;
	}

	public int getNumberUnloaded()
	{
		return numberUnloaded;
	}

}

