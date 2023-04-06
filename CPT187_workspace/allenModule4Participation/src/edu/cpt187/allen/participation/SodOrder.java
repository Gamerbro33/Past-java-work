//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help support the main class.
//DATE: February 4 2020
package edu.cpt187.allen.participation;

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
	private char itemSelection = ' ';
	private char discountType = ' ';
	private String itemName = "";
	private double itemPrice = 0.0;
	private String discountName;
	private double discountRate = 0.0;
	private int howMany = 0;
	private int lastItemSelectedIndex = 0;
	private String prizeName = "";
	
	//The SodOrder class constructor
	public SodOrder() 
	{
	}//END of SodOrder constructor
	

	//set method
	//method that will Assign the value of itemSelection
	public void setItemSelection(char borrowedItemSelection)
	{
		itemSelection = borrowedItemSelection;
	}
	
	//set method
	//method that will Assign the value of itemName
	public void setItemName(String[] borrowedItemNames)
	{
		if(itemCount == null)
		{
			itemCount = new int[borrowedItemNames.length];
		}
		if(itemSelection=='A')
		{
			itemName = borrowedItemNames[0];
			itemCount[0]++;

		}
		else if(itemSelection == 'B')
		{
			itemName = borrowedItemNames[1];
			itemCount[1]++;
		}
		else 
		{
			itemName = borrowedItemNames[2];
			itemCount[2]++;
		}

	}
	
	//set method
	//method that will Assign the value of itemSelection
	public void setItemPrice(double[] borrowedItemPrice)
	{
		if(itemSelection =='A')
		{
			itemPrice = borrowedItemPrice[0];

		}
		else if(itemSelection == 'B')
		{
			itemPrice = borrowedItemPrice[1];
		}
		else 
		{
			itemPrice = borrowedItemPrice[2];
		}
	}
	
	//set method
	//method that will Assign the value of howMany
	public void setHowMany(int borrowedHowMany)
	{
		howMany = borrowedHowMany;
	}
	
	//set method
	//method that will Assign the value of discountType
	public void setDiscountType(char borrowedMenuSelection)
	{
		discountType = borrowedMenuSelection;
	}
	
	//set method
	//method that will Assign the value of discountName
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
	}
	
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
	//method that will Assign the value of prizeName
	public void setPrizeName(String[] borrowedPrizeNames, int borrowedPrizeIndex)
	{
		if(prizeCount == null)
		{
			prizeCount = new int[borrowedPrizeNames.length];
		}
		prizeName = borrowedPrizeNames[borrowedPrizeIndex];
		
		if(prizeName.contentEquals(borrowedPrizeNames[0]))
		{
			prizeCount[0]++;
		}
		else if(prizeName.contentEquals(borrowedPrizeNames[1]))
		{
			prizeCount[1]++;
		}
		else
		{
			prizeCount[2]++;
		}
	}

	//set method
	public void setDecreaseInStock(Inventory borrowedInventoryObject)
	{
			borrowedInventoryObject.setReduceStock(getHowMany(), lastItemSelectedIndex);
	}
	
	//get method
	public int getInStockCount(int[] borrowedInStockCounts)
	{
		return borrowedInStockCounts[lastItemSelectedIndex];
	}
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
