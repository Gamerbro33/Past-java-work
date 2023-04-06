//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help support the main class.
//DATE: January 20 2020
package edu.cpt187.allen.participation;

public class SodOrder 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final String[] ITEM_NAMES= {"Premium Sod", "Special Sod", "Basic Sod"};
	private final double[] ITEM_PRICES = {9.95, 5.95, 1.95};
	private final String[] DISCOUNT_NAMES = {"Member", "Senior", "No Discount"};
	private final double[] DISCOUNT_RATE = {0.25, 0.15, 0.0};
	private final double TAX_RATE = .075;

	//declare and initialize all nonCONSTANTS class attributes
	private int[] itemCount = new int[ITEM_NAMES.length];//counter for each item selection
	private int[] discountCount = new int[DISCOUNT_NAMES.length];//counter for each discount selection
	private char itemSelection = ' ';
	private char discountType = ' ';
	private String itemName = "";
	private double itemPrice = 0.0;
	private String discountName;
	private double discountRate = 0.0;
	private int howMany = 0;

	//The SodOrder class constructor
	public SodOrder() 
	{
	}//END of SodOrder constructor

	//set method
	//method that will Assign the value of itemSelection
	public void setItemSelection(char borrowedItemSelection)
	{
		borrowedItemSelection = itemSelection;
	}
	//set method
	//method that will Assign the value of itemName
	public void setItemName()
	{
		if(itemSelection=='A')
		{
			itemName = ITEM_NAMES[0];
			itemCount[0]++;

		}
		else if(itemSelection == 'B')
		{
			itemName = ITEM_NAMES[1];
			itemCount[1]++;
		}
		else 
		{
			itemName = ITEM_NAMES[2];
			itemCount[2]++;
		}

	}
	//set method
	//method that will Assign the value of itemPrice
	public void setItemPrice()
	{
		if(itemSelection =='A')
		{
			itemPrice = ITEM_PRICES[0];

		}
		else if(itemSelection == 'B')
		{
			itemPrice = ITEM_PRICES[1];
		}
		else
		{
			itemPrice = ITEM_PRICES[2];
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
		borrowedMenuSelection = discountType;
	}
	//set method
	//method that will Assign the value of discountName
	public void setDiscountName()
	{
		if(discountType == 'A') 
		{
			discountName = DISCOUNT_NAMES[0];
			discountCount[0]++;
		}
		else if(discountType == 'B') 
		{
			discountName = DISCOUNT_NAMES[1];
			discountCount[1]++;
		}
		else 
		{
			discountName = DISCOUNT_NAMES[2];
			discountCount[2]++;
		}
	}
	//set method
	//method that will Assign the value of discountRate
	public void setDiscountRate()
	{
		if(discountType == 'A') 
		{
			discountRate = DISCOUNT_RATE[0];

		}
		else if(discountType == 'B') 
		{
			discountRate = DISCOUNT_RATE[1];
		}
		else 
		{
			discountRate = DISCOUNT_RATE[2];
		}
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
	//get method
	//method that will Return the value of subTotal
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
		return getSubTotal() + getTaxAmt();
	}//end of getTotalCost
	public String[] getItemNames()
	{
		return ITEM_NAMES;
	}
	public double[] getItemPrices()
	{
		return ITEM_PRICES;
	}
	public String[] getDiscountNames()
	{
		return DISCOUNT_NAMES;
	}
	public double[] getDiscountRates()
	{
		return DISCOUNT_RATE;
	}
	public int[] getItemCount()
	{
		return itemCount;
	}
	public int[] getDiscountCount()
	{
		return discountCount;
	}
}
