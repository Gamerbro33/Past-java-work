//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Supports the main class for building rooms in houses.
//DATE: January 22 2020
package edu.cpt187.allen.Program2;

public class SingleStoryHome 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final double[] ROOM_SIZES = {231.0, 115.0, 192.0, 256.0};
	private final String[] ROOM_NAMES = {"Bedroom", "Bathroom", "Kitchen", "Living Room"};
	private final double COST_PER_SQUARE_FOOT = 125.00;
	private final double MAX_HOME_AREA = 1400.0;
	private final int MAX_ROOM_COUNT = 1;

	//declare and initialize all nonCONSTANTS class attributes
	private int bedroomCount = 0;
	private int bathroomCount = 0;

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
		return ROOM_SIZES[0] * bedroomCount;
	}//end of getBedroomArea

	//get method
	//method that will Return the value of BATHROOM_SIZE
	public double getBathroomArea()
	{
		return ROOM_SIZES[1] * bathroomCount;
	}

	//get method
	//method that will Return the value of KITCHEN_SIZE
	public double getKitchenArea()
	{
		return ROOM_SIZES[2] * MAX_ROOM_COUNT;
	}//end of getKitchenArea

	//get method
	//method that will Return the value of LIVINGROOM_SIZE
	public double getLivingRoomArea()
	{
		return ROOM_SIZES[3] * MAX_ROOM_COUNT;
	}//end of getLivingRoomArea

	//get method
	//method that will Return the value of Home area
	public double getHomeArea()
	{
		return (getBedroomArea() + getBathroomArea() + getKitchenArea() + getLivingRoomArea());
	}//end of getHomeArea

	//get method
	//method that will Return the value of COST_PER_SQUARE_FOOT
	public double getCostPerSquareFt()
	{
		return COST_PER_SQUARE_FOOT;
	}//end of getCostPerSquareFt

	//get method
	//method that will Return the value of ROOM_SIZES
	public double[] getRoomSizes()
	{
		return ROOM_SIZES;
	}

	//get method
	//method that will Return the value of ROOM_NAMES
	public String[] getRoomNames()
	{
		return ROOM_NAMES;
	}//end of getRoomNames

	//get method
	//method that will Return the value of bedroomCost
	public double getBedroomCost()
	{
		return getBedroomArea() * COST_PER_SQUARE_FOOT;
	}//end of getBedroomCost

	//get method
	//method that will Return the value of bathroomCost
	public double getBathroomCost()
	{
		return getBathroomArea() * COST_PER_SQUARE_FOOT;
	}//end of getBathroomCost

	//get method
	//method that will Return the value of kitchenCost
	public double getKitchenCost()
	{
		return getKitchenArea() * COST_PER_SQUARE_FOOT;
	}//end of getKitchenCost

	//get method
	//method that will Return the value of livingRoomCost
	public double getLivingRoomCost()
	{
		return getLivingRoomArea() * COST_PER_SQUARE_FOOT;
	}//end of getLivingRoomCost

	//get method
	//method that will Return the value of HomeCost
	public double getHomeCost()
	{
		return (getBedroomCost() + getBathroomCost() + getKitchenCost() + getLivingRoomCost());
	}//end of getHomeCost
}
