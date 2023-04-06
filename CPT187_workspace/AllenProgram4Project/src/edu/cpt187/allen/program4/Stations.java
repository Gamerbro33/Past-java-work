//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Supports the main class for simulating a train of overloaded method.
//DATE: February 5 2020
package edu.cpt187.allen.program4;
import java.util.Random;

public class Stations 
{
	//declare and initialize all nonCONSTANTS class attributes
	private int maximumCapacity = 0;
	private int passengersWaiting = 0;
	private Random ranNumGenerator = new Random();

	//The Station class constructor
	public Stations() 
	{
	}//END of Station constructor

	//set method
	//method that will Assign the value of maximumCapacity
	public void setMaximumCapacity(int borrowedTrainCapacity)
	{
		maximumCapacity = borrowedTrainCapacity * borrowedTrainCapacity;
	}//end of setMaximumCapacity

	//set method
	//method that will Assign the value of passengerWaiting
	public void setPassengersWaiting()
	{
		passengersWaiting = getRandomNumber();
	}//end of setPassengersWaiting

	//set method
	public void setReducedNumberWaiting(int borrowedNumberLoaded)
	{
		passengersWaiting = passengersWaiting - borrowedNumberLoaded;
	}//end of setReducedNumberWaiting

	//get method
	//method that will Return the value of maximumCapacity
	public int getMaximumCapacity()
	{
		return maximumCapacity;
	}//end of getMaximumCapacity

	//get method
	//method that will Return the value of maximumCapacity
	public int getPassengersWaiting()
	{
		return passengersWaiting;
	}//end of getPassengersWaiting

	//get method
	//method that will Return the value of ranNumGenerator
	public int getRandomNumber()
	{
		return ranNumGenerator.nextInt(maximumCapacity);
	}//end of getRandomNumber

}

