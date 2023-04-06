//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: create the inventory in sodOrder for MainClass.
//DATE: February 17 2020
package edu.cpt187.allen.participation;

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
	private int[] orderQuantity = new int [MAX_ITEMS];
	private double[] orderTotal = new double[MAX_ITEMS];
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
	}//end of setReducesStock
	
	public void setLoadItems(String borrowedFileName)
	{
		//sets itemIds, itemNames, itemPrices and inStockCounts
		recordCount = RESET_VALUE;

		try
		{
			Scanner infile = new Scanner(new FileInputStream(borrowedFileName));

			while(infile.hasNext() == true && recordCount < MAX_ITEMS)
			{
				// READ a complete record
				itemIDs[recordCount] = infile.nextInt();
				itemNames[recordCount] = infile.next();
				itemPrices[recordCount] = infile.nextDouble();
				inStockCounts[recordCount] = infile.nextInt();
				recordCount++;
			}//end of while
			//close Scanner
			infile.close();
			
			//sort
			setBubbleSort();
		}//end of try

		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
		}
	}//end of setLoadItems
	
	//set method
	public void setLoadItems(String borrowedFileName, int borrowedSize)
	{
		recordCount = RESET_VALUE;
		orderQuantity = new int[borrowedSize];
		orderTotal = new double[borrowedSize];
		
		try
		{
			Scanner infile = new Scanner(new FileInputStream(borrowedFileName));
			while(infile.hasNext() == true && recordCount < borrowedSize && recordCount < MAX_ITEMS)
			{
				itemIDs[recordCount] = infile.nextInt();
				itemNames[recordCount] = infile.next();
				itemPrices[recordCount] = infile.nextDouble();
				orderQuantity[recordCount] = infile.nextInt();
				orderTotal[recordCount] = infile.nextDouble();
				recordCount++;
			}
			//close the file
			infile.close();
			setBubbleSort();
		}
		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
		}
	}//end of setLoadItems
	
	//set method
	public void setSearchIndex(int borrowedIndex)
	{
		itemSearchIndex = getSearchResults(borrowedIndex);
	}//end of setSearchIndex
	
	//set method
	public void setBubbleSort()
	{
		int last = 0;
		int index = 0;
		boolean swap;
		
		last = recordCount - 1;
		
		while(last > RESET_VALUE)
		{
			index = RESET_VALUE;
			swap = false;
			
			while(index < last)
			{
				if (itemIDs[index] > itemIDs[index + 1])
				{
					setSwapArrayElements(index);
					swap = true;
				}//end of if
				
				index++;
			}//end of while
			
			if (swap == false)
			{
				last = RESET_VALUE;
			}
			else
			{
				last = last - 1;
			}
		}//end of while
				
	}//end of setBubbleSort
	
	//set method
	public void setSwapArrayElements(int borrowedIndex)
	{
		int localIntHolder = 0;
		String localStringHolder = "";
		double localDoubleHolder = 0.0;
		
		//item ID
		localIntHolder = itemIDs[borrowedIndex + 1];
		itemIDs[borrowedIndex + 1] = itemIDs[borrowedIndex];
		itemIDs[borrowedIndex] = localIntHolder;
		
		//Item name
		localStringHolder = itemNames[borrowedIndex + 1];
		itemNames[borrowedIndex + 1] = itemNames[borrowedIndex];
		itemNames[borrowedIndex] = localStringHolder;
				
		//item price
		localDoubleHolder = itemPrices[borrowedIndex + 1];
		itemPrices[borrowedIndex + 1] = itemPrices[borrowedIndex];
		itemPrices[borrowedIndex] = localDoubleHolder;
		
		//in stock Count
		localIntHolder = inStockCounts[borrowedIndex + 1];
		inStockCounts[borrowedIndex + 1] = inStockCounts[borrowedIndex];
		inStockCounts[borrowedIndex] = localIntHolder;
		
		
	}//end of setSwapArrayElements
	
	//get method
	public int[] getInStockCounts() 
	{
		return inStockCounts;
	}//end of getInStockCounts

	public int[] getItemIDs()
	{
		return itemIDs;
	}
	
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
	
	public int[] getOrderQuantities()
	{
		return orderQuantity;
	}//end of getOrderQuantities

	public double[] getOrderTotals()
	{
		return orderTotal;
	}//end of getOrderTotals
	
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

	public int getMaxRecords()
	{
		return MAX_ITEMS;
	}
	
	public int getSearchIndex()
	{
		return itemSearchIndex;
	}
	
	//get method
	//method that will return the value of recordCount
	public int getRecordCount()
	{
		return recordCount;
	}

	//get method
	public int getSearchResults(int borrowedBorrowedTargetID)
	{
		int first = 0;
		int last = 0;
		int mid = 0;
		boolean found;
		
		last = recordCount - 1;
		found = false;

		while(first <= last && found == false)
		{
			mid = (first + last) / 2;
			
			if (itemIDs[mid] == borrowedBorrowedTargetID)
			{
				found = true;
			}
			else
			{
				if(itemIDs[mid] < borrowedBorrowedTargetID)
				{
					first = mid + 1;
				}
				else
				{
					last = mid - 1;
				}
			}
			
		}
		if(found == false)
		{
			mid = NOT_FOUND;
		}

		return mid;
	}
	
}
