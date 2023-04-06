//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help support the main class.
//DATE: February 17 2020
package edu.cpt187.allen.participation;

import edu.cpt187.allen.participation.Inventory;

public class SodOrder 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final double ZERO_TOTAL = 0.0;
	private final double TAX_RATE = .075;

	//declare and initialize all nonCONSTANTS class attributes
	private int[] itemCount;
	private int[] discountCount;
	private int[] prizeCount;
	private char discountType = ' ';
	private int itemID = 0;
	private String itemName = "";
	private double itemPrice = 0.0;
	private String discountName = "";
	private double discountRate = 0.0;
	private int howMany = 0;
	private int lastItemSelectedIndex = 0;
	private String prizeName = "";
	
	//The SodOrder class constructor
	public SodOrder() 
	{
	}//END of SodOrder constructor

	//set method
	public void setItemCountArray(int borrowedMaxRecords)
	{
		if(itemCount == null)
		{
			itemCount = new int[borrowedMaxRecords];
		}
	}//end of setItemCountArray
	
	//set method
	public void setItemSelection(int borrowedSearchIndex)
	{
		lastItemSelectedIndex = borrowedSearchIndex;
	}//end of setItemSelection
	
	//set method
	public void setItemID(int[] borrowedItemIDs)
	{
		itemID = borrowedItemIDs[lastItemSelectedIndex];
	}//end of setItemSelection
	
	//set method
	//method that will Assign the value of itemName
	public void setItemName(String[] borrowedItemNames)
	{
		itemName = borrowedItemNames[lastItemSelectedIndex];
		itemCount[lastItemSelectedIndex]++;
	}
	
	//set method
	//method that will Assign the value of itemPrice
	public void setItemPrice(double[] borrowedItemPrices)
	{
		itemPrice = borrowedItemPrices[lastItemSelectedIndex];
	}

	//set method
	//method that will Assign the value of howMany
	public void setHowMany(int borrowedHowMany)
	{
		howMany = borrowedHowMany;
	}//end of setHowMany

	//set method
	//method that will Assign the value of discountType
	public void setDiscountType(char borrowedMenuSelection)
	{
		discountType = borrowedMenuSelection;
	}//end of setDiscountType

	//set method
	public void setDiscountName(String[] borrowedDiscountNames)
	{
		if(discountCount == null)
		{
			discountCount = new int[borrowedDiscountNames.length];
		}
		if(discountType == 'A') 
		{
			discountName = borrowedDiscountNames[0];
			discountCount[0]++;
		}
		else if(discountType == 'B') 
		{
			discountName = borrowedDiscountNames[1];
			discountCount[1]++;
		}
		else 
		{
			discountName = borrowedDiscountNames[2];
			discountCount[2]++;
		}
	}//end of setDiscountName

	//set method
	//method that will Assign the value of itemSelection
	public void setDiscountRate(double[] borrowedDiscountRate)
	{
		if(discountType =='A')
		{
			discountRate = borrowedDiscountRate[0];

		}
		else if(discountType == 'B')
		{
			discountRate = borrowedDiscountRate[1];
		}
		else 
		{
			discountRate = borrowedDiscountRate[2];
		}
	}

	//set method
	//method that will assign the value of prizeName
	public void setPrizeName(String[] borrowedPrizeNames, int borrowedPrizeIndex)
	{
		
		
		if(prizeCount == null)
		{
			prizeCount = new int[borrowedPrizeNames.length];
		}

		prizeName = borrowedPrizeNames[borrowedPrizeIndex];
		prizeCount[borrowedPrizeIndex]++;

	}//end of setPrizeName

	//set method
	public void setDecreaseInStock(Inventory borrowedInventoryObject)
	{
		borrowedInventoryObject.setReduceStock(howMany);
	}//end of setDecreaseInStock

	//get method
	public int getInStockCount(int[] borrowedInStockCounts)
	{
		return borrowedInStockCounts[lastItemSelectedIndex];
	}//end of getInStockCount
	
	//get method
	public int getItemID()
	{
		return itemID;
	}//end of getItemID

	
	//get method
	//method that will Return the value of ItemName
	public String getItemName()
	{
		return itemName;
	}//end of getItemName;

	//get method
	//method that will Return the value of ItemPrice
	public double getItemPrice()
	{
		return itemPrice;
	}//end of getItemPrice

	//get method
	//method that will Return the value of itemCount
	public int[] getItemCounts()
	{
		return itemCount;
	}

	//get method
	//method that will Return the value of howMany
	public int getHowMany()
	{
		return howMany;
	}

	//get method
	//method that will Return the value of discountName
	public String getDiscountName()
	{
		return discountName;
	}
	//get method
	//method that will Return the value of discountName
	public double getDiscountRate()
	{
		return discountRate;
	}

	//get method
	//method that will Return the value of discountCount
	public int[] getDiscountCounts()
	{
		return discountCount;
	}

	//get method
	//method that will Return the value of discountName
	public double getDiscountAmt()
	{
		return itemPrice * discountRate;
	}

	//get method
	//method that will Return the value of discountPrice
	public double getDiscountPrice() 
	{
		return itemPrice - getDiscountAmt();
	}//end of getDiscountPrice

	public String getPrizeName()
	{
		return prizeName;
	}

	public int[] getPrizeCount()
	{
		return prizeCount;
	}

	public double getSubTotal() 
	{
		return howMany * getDiscountPrice();
	}//end of getSubTotal
	//get method
	//method that will Return the value of TAX RATE
	public double getTaxRate() 
	{
		return TAX_RATE;
	}//end of GetTaxRate

	//get method
	//method that will Return the value of taxAmount
	public double getTaxAmt() 
	{
		return getSubTotal() * TAX_RATE;
	}//end of getTaxAmt

	//get method
	//method that will Return the value of totalCost
	public double getTotalCost() 
	{
		if (discountType == ' ')
		{
			return ZERO_TOTAL;
		}
		else 
		{
			return getSubTotal() + getTaxAmt();
		}
	}//end of getTotalCost
}
