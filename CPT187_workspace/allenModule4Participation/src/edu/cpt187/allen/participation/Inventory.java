//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: create the inventory in sodOrder for MainClass.
//DATE: February 4 2020
package edu.cpt187.allen.participation;

import java.util.Random;

public class Inventory 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final String[] ITEM_NAMES= {"Premium Sod", "Special Sod", "Basic Sod"};
	private final double[] ITEM_PRICES = {9.95, 5.95, 1.95};
	private final String[] DISCOUNT_NAMES = {"Member", "Senior", "No Discount"};
	private final double[] DISCOUNT_RATE = {0.25, 0.15, 0.0};
	private final String[] PRIZE_NAMES = {"Gnome","Flamingo","Bird house"};
	
	//declare and initialize all nonCONSTANTS class attributes
	private int[] inStockCounts = new int [ITEM_NAMES.length];
	private Random prizeGenerator = new Random();
	
	//The Inventory class constructor
	public Inventory() 
	{
	}//END of Inventory constructor
	
	//set method
	public void setReduceStock(int borrowedHowMany, int borrowedLastItemSelectionIndex)
	{
		
		inStockCounts[borrowedLastItemSelectionIndex] = inStockCounts[borrowedLastItemSelectionIndex] - borrowedHowMany;
		
		
	}
	
	//set method
	public void setInStockCounts(int[] borrowedCounts)
	{
		
		inStockCounts = borrowedCounts;
		
	}
	
	//get method
	public int[] getInStockCounts() 
	{
		return inStockCounts;
	}
	
	//set method
	//method that will Assign the value of ITEM_NAMES
	public String[] getItemNames()
	{
		return ITEM_NAMES;
	}
	
	//set method
	//method that will Assign the value of ITEM_PRICE
	public double[] getItemPrice()
	{
		return ITEM_PRICES;
	}
	
	//set method
	//method that will Assign the value of DISCOUNT_NAMES
	public String[] getDiscountNames()
	{
		return DISCOUNT_NAMES;
	}
	
	//set method
	//method that will Assign the value of DISCOUNT_RATE
	public double[] getDiscountRate()
	{
		return DISCOUNT_RATE;
	}
	
	//set method
	//method that will Assign the value of DISCOUNT_NAMES
	public String[] getPrizeNames()
	{
		return PRIZE_NAMES;
	}
		
	//set method
	//method that will Assign the value of prizeGenerator
	public int getRandomNumber()
	{
		return prizeGenerator.nextInt(PRIZE_NAMES.length);
	}
}
