//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Supports the main class for simulating a train.
//DATE: January 28 2020
package edu.cpt187.allen.Program3;

import java.util.Random;

public class SubwayTrain 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attribute
	private final int ZERO = 0;
	private final int TWO = 2;

	//declare and initialize all nonCONSTANTS class attributes
	private int numberOfStations = 0;
	private int maximumStops = 0;
	private int homeStation = 0;
	private String[] stations;
	private int createCounter = 0;
	private int runCounter = 0;
	private int maximumCapacity = 0;
	private int stopCounter = 0;
	private int currentStationIndex = 0;
	private int numberOnBoard = 0;
	private int numberLoaded = 0;
	private int numberUnloaded = 0;
	//private int unloadAll = 0;
	private Random ranNumGenerator = new Random();

	//SubwayTrain class constructor
	public SubwayTrain()
	{
	}//end of class constructor

	//set method
	//method that will Assign the value of numberOfStations
	public void setNumberOfStations(int borrowedNoOfStations)
	{
		numberOfStations = borrowedNoOfStations;
		createCounter++;
	}//end of setNumberOfStations

	//set method
	//method that will Assign the value of maximumStops
	public void setMaximumStops()
	{
		maximumStops = (numberOfStations * TWO) - TWO;
	}//end of setMaximumStops

	//set method
	//method that will Assign the value of homeStation
	public void setHomeStation(int borrowedHomeStation)
	{
		homeStation = borrowedHomeStation;
	}//end of setHomeStation

	//set method
	//method that will Assign the value of stations
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
		else
		{
			currentStationIndex = currentStationIndex - 1;
		}

	}//end of setMoveStation

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

		runCounter++;
	}//end of setUnloadAllPassengers

	//set method
	// method to make set a simulationReset
	public void setResetSimulation()
	{
		stopCounter = ZERO;
		currentStationIndex = ZERO;


	}//end of setResetSimulation

	//get method
	//method that will Return the value of ranNumber
	public int getRandomNumber()
	{
		return ranNumGenerator.nextInt(maximumCapacity * TWO);
	}//end of getRandomNumber

	//get method
	//method that will Return the value of numberOfStation
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
	//method that will Return the value of createCounter
	public int getCreateCounter()
	{
		return createCounter;
	}

	//get method
	//method that will Return the value of RunCounter
	public int getRunCounter()
	{
		return runCounter;
	}

	//get method
	//method that will Return the value of maximumCapacity
	public int getMaximumCapacity()
	{
		return maximumCapacity;

	}

	public int getStopCounter()
	{
		return stopCounter;
	}

	public int getCurrentStation()
	{
		return Integer.parseInt(stations[currentStationIndex]);
	}

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
