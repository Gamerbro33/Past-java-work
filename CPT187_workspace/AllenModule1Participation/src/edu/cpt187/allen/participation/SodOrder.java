//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help support the main class.
//DATE: January 13 2020
package edu.cpt187.allen.participation;

public class SodOrder 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final String ITEM_NAME_PREMIUM = "Premium Sod";
	private final String ITEM_NAME_SPECIAL = "Special Sod";
	private final String ITEM_NAME_BASIC = "BASIC Sod";
	private final double ITEM_PRICE_PREMIUM = 9.95;
	private final double ITEM_PRICE_SPECIAL = 5.95;
	private final double ITEM_PRICE_BASIC = 1.95;
	private final String DISCOUNT_NAME_MEMBER = "Member";
	private final String DISCOUNT_NAME_SENIOR = "Senior";
	private final String DISCOUNT_NAME_NONE = "No Discount";
	private final double DISCOUNT_RATE_MEMBER = 0.25;
	private final double DISCOUNT_RATE_SENIOR = 0.15;
	private final double DISCOUNT_RATE_NONE = 0.0;
	private final double TAX_RATE = .075;

	//declare and initialize all nonCONSTANTS class attributes
	private String itemName = "";
	private double itemPrice = 0;
	private double discountRate ;
	private int howMany = 0;

	//The SodOrder class constructor
	public SodOrder() 
	{
	}//END of SodOrder constructor

	//set method
	//method that will Assign the value of menuSelection
	public void setItemName(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			itemName = ITEM_NAME_PREMIUM;
		}
		else if(borrowedMenuSelection == 'B') 
		{
			itemName = ITEM_NAME_SPECIAL;
		}
		else 
		{
			itemName = ITEM_NAME_BASIC;
		}

	}//end of setItemName

	//set method
	//method that will Assign the value of menuSelection
	public void setItemPrice(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			itemPrice = ITEM_PRICE_PREMIUM;
		}
		else if(borrowedMenuSelection == 'B') 
		{
			itemPrice = ITEM_PRICE_SPECIAL;
		}
		else 
		{
			itemPrice = ITEM_PRICE_BASIC;
		}

	}//end of setItemPrice

	//set method
	//method that will Assign the value of howMany
	public void setHowMany(int borrowedHowMany) 
	{
		howMany = borrowedHowMany;
	}//end of setHowMany

	//set method
	//method that will Assign the value of menuSelection
	public void setDiscountRate(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			discountRate = DISCOUNT_RATE_MEMBER;
		}
		else if(borrowedMenuSelection == 'B') 
		{
			discountRate = DISCOUNT_RATE_SENIOR;
		}
		else 
		{
			discountRate = DISCOUNT_RATE_NONE;
		}
	}//end of setDiscountRate

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
	}//end of getItemName;

	//get method
	//method that will Return the value of howMany
	public int getHowMany()
	{
		return howMany;
	}//end of getHowMany;

	//get method
	//method that will Return the value of discountRate
	public double getDiscountRate()
	{
		return discountRate;
	}//end of getDiscountRate;

	//get method
	//method that will Return the value of discountAmt
	public double getDiscountAmt() 
	{
		return itemPrice * discountRate;
	}//end of getDiscountAmt

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

	//get method
	//method that will Return the value of ITEM_NAME_PREMIUM
	public String getItemNamePremium()
	{
		return ITEM_NAME_PREMIUM;
	}//end of getItemNamePremium

	//get method
	//method that will Return the value of ITEM_NAME_SPECIAL
	public String getItemNameSpecial()
	{
		return ITEM_NAME_SPECIAL;
	}//end of getItemNameSpecial

	//get method
	//method that will Return the value of ITEM_NAME_BASIC
	public String getItemNameBasic()
	{
		return ITEM_NAME_BASIC;
	}//end of getItemNameBasic

	//get method
	//method that will Return the value of ITEM_PRICE_PREMIUM
	public double getItemPricePremium()
	{
		return ITEM_PRICE_PREMIUM;
	}//end of getItemPricePremium

	//get method
	//method that will Return the value of ITEM_PRICE_SPECIAL
	public double getItemPriceSpecial()
	{
		return ITEM_PRICE_SPECIAL;
	}//end of getItemPriceSpecial

	//get method
	//method that will Return the value of ITEM_PRICE_BASIC
	public double getItemPriceBasic()
	{
		return ITEM_PRICE_BASIC;
	}//end of getItemPriceBasic

	//get method
	//method that will Return the value of DISCOUNT_NAME_MEMBER
	public String getDiscountNameMember()
	{
		return DISCOUNT_NAME_MEMBER;
	}//end of getDiscountNameMember

	//get method
	//method that will Return the value of DISCOUNT_NAME_SENIOR
	public String getDiscountNameSenior()
	{
		return DISCOUNT_NAME_SENIOR;
	}//end of getDiscountNameSenior

	//get method
	//method that will Return the value of DISCOUNT_NAME_NONE
	public String getDiscountNameNone()
	{
		return DISCOUNT_NAME_NONE;
	}//end of getDiscountNameNone

	//get method
	//method that will Return the value of DISCOUNT_RATE_MEMBER
	public double getDiscountRateMember()
	{
		return DISCOUNT_RATE_MEMBER;
	}//end of getDiscountRateMember

	//get method
	//method that will Return the value of DISCOUNT_RATE_SENIOR
	public double getDiscountRateSenior()
	{
		return DISCOUNT_RATE_SENIOR;
	}//end of getDiscountRateSenior

	//get method
	//method that will Return the value of DISCOUNT_RATE_NONE
	public double getDiscountRateNone()
	{
		return DISCOUNT_RATE_NONE;
	}//end of getDiscountRateNone
}//end of supportive class
