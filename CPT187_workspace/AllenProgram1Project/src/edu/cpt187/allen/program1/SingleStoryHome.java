//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Supports the main class for building rooms in houses.
//DATE: January 15 2020
package edu.cpt187.allen.program1;

public class SingleStoryHome 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final double BEDROOM_SIZE = 231.0;
	private final double BATHROOM_SIZE = 115.0;
	private final double KITCHEN_SIZE = 192.0;
	private final double LIVINGROOM_SIZE = 256.0;
	private final double MAX_HOME_AREA = 1400.0;
	private final int MAX_ROOM_COUNT = 1;

	//declare and initialize all nonCONSTANTS class attributes
	private int bedroomCount;
	private int bathroomCount;

	//the SingleStoryHome Class Constructor
	public SingleStoryHome() 
	{
	}//end of SingleStoryHome Constructor

	//set method
	//method that will Assign the value of BedroomCount
	public void setBedroomCount(int borrowedRoomNumber)
	{
		bedroomCount = borrowedRoomNumber;

	}//end of setBedroomCount

	//set method
	//method that will Assign the value of BathroomCount
	public void setBathroomCount(int borrowedRoomNumber)
	{
		bathroomCount = borrowedRoomNumber;

	}//end of setBathroomCount

	//get method
	//method that will Return the value of MAX_HOME_AREA
	public double getMaxHomeArea() 
	{
		return MAX_HOME_AREA;
	}//end of getMaxHomeArea

	//get method
	//method that will Return the value of MAX_ROOM_COUNT
	public int getMaxRoomCount()
	{
		return MAX_ROOM_COUNT;
	}//end of getMaxRoomCount

	//get method
	//method that will Return the value of bedroomCount
	public int getBedroomCount()
	{
		return bedroomCount;
	}//end of getBedroomCount

	//get method
	//method that will Return the value of bathroomCount
	public int getBathroomCount()
	{
		return bathroomCount;
	}//end of getBathroomCount

	//get method
	//method that will Return the value of BEDROOM_SIZE
	public double getBedroomArea()
	{
		return BEDROOM_SIZE * bedroomCount;
	}//end of getBedroomArea

	//get method
	//method that will Return the value of BATHROOM_SIZE
	public double getBathroomArea()
	{
		return BATHROOM_SIZE * bathroomCount;
	}

	//get method
	//method that will Return the value of KITCHEN_SIZE
	public double getKitchenArea()
	{
		return KITCHEN_SIZE * MAX_ROOM_COUNT;
	}//end of getKitchenArea

	//get method
	//method that will Return the value of LIVINGROOM_SIZE
	public double getLivingRoomArea()
	{
		return LIVINGROOM_SIZE * MAX_ROOM_COUNT;
	}//end of getLivingRoomArea

	//get method
	//method that will Return the value of Home area
	public double getHomeArea()
	{
		return (getBedroomArea() + getBathroomArea() + getKitchenArea() + getLivingRoomArea());
	}//end of getHomeArea

}
