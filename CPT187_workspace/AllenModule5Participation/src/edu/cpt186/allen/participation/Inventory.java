//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: create the inventory in sodOrder for MainClass.
//DATE: February 10 2020
package edu.cpt186.allen.participation;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Random;
import java.io.IOException;

public class Inventory 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final String[] DISCOUNT_NAMES = {"Member", "Senior", "No Discount"};
	private final double[] DISCOUNT_RATE = {0.25, 0.15, 0.0};
	private final String[] PRIZE_NAMES = {"Gnome","Flamingo","Bird house"};
	private final int MAX_ITEMS = 5;
	private final int NOT_FOUND = -1;
	private final int RESET_VALUE = 0;

	//declare and initialize all nonCONSTANTS class attributes
	private int[] itemIDs = new int [MAX_ITEMS];
	private String[] itemNames = new String [MAX_ITEMS];
	private double[] itemPrices = new double [MAX_ITEMS];
	private int[] inStockCounts = new int [MAX_ITEMS];
	private int itemSearchIndex = 0;
	private int recordCount = 0;
	private Random prizeGenerator = new Random();

	//The Inventory class constructor
	public Inventory() 
	{
	}//END of Inventory constructor

	//set method
	public void setReduceStock(int borrowedHowMany)
	{
		inStockCounts[itemSearchIndex] = (inStockCounts[itemSearchIndex] - borrowedHowMany);
	}

	//set method
	public void setLoadItems(String borrowedFileName)
	{
		//sets itemIds, itemNames, itemPrices and inStockCounts
		recordCount = RESET_VALUE;

		try
		{
			Scanner infile = new Scanner(new FileInputStream(borrowedFileName));
			int localIndex = 0;
			while(infile.hasNext() == true && recordCount < MAX_ITEMS)
			{
				// READ a complete record
				itemIDs[localIndex] = infile.nextInt();
				itemNames[localIndex] = infile.next();
				itemPrices[localIndex] = infile.nextDouble();
				inStockCounts[localIndex] = infile.nextInt();
				recordCount++;
				localIndex++;
			}//end of while

			infile.close();
		}//end of try

		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
		}
	}//end of setLoadItems

	//set method
	public void setSearchIndex(int borrowedTargetID)
	{
		itemSearchIndex = getSearchResults(borrowedTargetID);
	}//end of setSearchIndex

	//get method
	public int[] getInStockCounts() 
	{
		return inStockCounts;
	}//end of getInStockCounts

	//get method
	//method that will return the value of itemNames
	public String[] getItemNames()
	{
		return itemNames;
	}//end of getItemNames

	//get method
	//method that will return the value of itemPrices
	public double[] getItemPrices()
	{
		return itemPrices;
	}//end of getItemPrices

	//get method
	//method that will return the value of discountNames
	public String[] getDiscountNames()
	{
		return DISCOUNT_NAMES;
	}

	//get method
	//method that will return the value of DISCOUNT_RATE
	public double[] getDiscountRates()
	{
		return DISCOUNT_RATE;
	}

	//get method
	//method that will return the value of PRIZE_NAMES
	public String[] getPrizeNames()
	{
		return PRIZE_NAMES;
	}

	//get method
	//method that will Return the value of prizeGenerator
	public int getRandomNumber()
	{
		return prizeGenerator.nextInt(PRIZE_NAMES.length);
	}

	//get method
	//method that will return the value of itemSearchIndex
	public int getSearchIndex()
	{
		return itemSearchIndex;
	}//end of getSearchIndex

	//get method
	//method that will return the value of recordCount
	public int getRecordCount()
	{
		return recordCount;
	}

	//get method
	public int getSearchResults(int borrowedBorrowedTargetID)
	{
		int localIndex = 0;
		int found = NOT_FOUND;

		while(localIndex < recordCount)
		{
			if(borrowedBorrowedTargetID == itemIDs[localIndex])
			{
				found = localIndex;
				localIndex = recordCount;
			}
			else
			{
				localIndex++;
			}
		}

		return found;
	}
}
