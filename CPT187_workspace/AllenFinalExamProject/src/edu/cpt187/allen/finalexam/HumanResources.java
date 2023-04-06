//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Load sort and search all the employees in the uploaded file.
//DATE: February 25 2020
package edu.cpt187.allen.finalexam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class HumanResources 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final int RESET = 0;
	private final int NOT_FOUND = -1;
	private final int MAXIMUM_RECORDS = 200;

	//declare and initialize all nonCONSTANTS class attributes
	private String[] employeeID = new String [MAXIMUM_RECORDS];
	private String[] employeeName = new String [MAXIMUM_RECORDS];
	private double[] bonusPerSale = new double [MAXIMUM_RECORDS];
	private int[] orderQuantity = new int [MAXIMUM_RECORDS];
	private double[] orderTotal = new double [MAXIMUM_RECORDS];
	private int recordCount = 0;
	private int searchedIndex = 0;
	private int howMany = 0;
	private int fileCount = 0;
	private int filesFound = 0;
	private int searchCount = 0;
	private int searchesFound = 0;

	//ProductInventory class constructor
	public HumanResources()
	{
	}//END of class constructor

	//set Method
	public void setLoadArrays(String borrowedFileName)
	{
		recordCount = RESET;
		searchCount = RESET;
		searchesFound = RESET;
		fileCount++;

		try
		{
			Scanner infile = new Scanner(new FileInputStream(borrowedFileName));

			while(infile.hasNext() == true && recordCount < MAXIMUM_RECORDS)
			{
				employeeID[recordCount] = infile.next();
				employeeName[recordCount] = infile.next();
				bonusPerSale[recordCount] = infile.nextDouble();
				recordCount++;
				filesFound++;
			}//end of while

			//close file
			infile.close();

			//set
			setBubbleSort();
		}//end of try

		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
		}
	}
	//end of setLoadArrays


	//set Method
	public void setLoadArrays(String borrowedFileName, int borrowedSize)
	{
		recordCount = RESET;
		searchCount = RESET;
		searchesFound = RESET;
		fileCount++;

		try
		{
			Scanner infile = new Scanner(new FileInputStream(borrowedFileName));

			while(infile.hasNext() == true && recordCount < borrowedSize  && recordCount < MAXIMUM_RECORDS)
			{
				employeeID[recordCount] = infile.next();
				employeeName[recordCount] = infile.next();
				bonusPerSale[recordCount] = infile.nextDouble();
				orderQuantity[recordCount] = infile.nextInt();
				orderTotal[recordCount] = infile.nextDouble();
				recordCount++;
				filesFound++;
			}//end of while

			//close file
			infile.close();

		}//end of try

		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
		}//end of catch
	}
	//end of setLoadArrays

	//set method
	public void setBubbleSort()
	{
		int last = 0;
		int index = 0;
		boolean swap;

		last = recordCount - 1;

		while(last > RESET)
		{
			index = RESET;
			swap = false;

			while(index < last)
			{
				if (Integer.valueOf(employeeID[index]) > Integer.valueOf(employeeID[index + 1]))
				{
					setSwapArrayElements(index);
					swap = true;
				}//end of if

				index++;
			}//end of while

			if (swap == false)
			{
				last = RESET;
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
		String localStringHolder = "";
		double localDoubleHolder = 0.0;

		//Employee ID
		localStringHolder = employeeID[borrowedIndex + 1];
		employeeID[borrowedIndex + 1] = employeeID[borrowedIndex];
		employeeID[borrowedIndex] = localStringHolder;

		//Employee name
		localStringHolder = employeeName[borrowedIndex + 1];
		employeeName[borrowedIndex + 1] = employeeName[borrowedIndex];
		employeeName[borrowedIndex] = localStringHolder;

		//BonusPerSale
		localDoubleHolder = bonusPerSale[borrowedIndex + 1];
		bonusPerSale[borrowedIndex + 1] = bonusPerSale[borrowedIndex];
		bonusPerSale[borrowedIndex] = localDoubleHolder;

	}//end of setSwapArrayElements

	//set method
	public void setSearchIndex(int borrowedID)
	{
		searchCount++;
		searchedIndex = getBinSearch(borrowedID);
		if(searchedIndex > NOT_FOUND)
		{
			searchesFound++;
		}//end of if
	}//end of setSearchIndex

	//set method
	public void setHowMany(int borrowedHowMany)
	{
		howMany = borrowedHowMany;
	}//end of setHowMany

	//get method
	public int getBinSearch(int borrowedBorrowedID)
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

			if (Integer.valueOf(employeeID[mid]) == borrowedBorrowedID)
			{
				found = true;
			}
			else
			{
				if(Integer.valueOf(employeeID[mid]) < borrowedBorrowedID)
				{
					first = mid + 1;
				}
				else
				{
					last = mid - 1;
				}
			}

		}//end of while
		if(found == false)
		{
			mid = NOT_FOUND;
		}

		return mid;
	}//end of getBinSearch

	//get method
	//method that will return the value of EmployeeID
	public String getEmployeeID()
	{
		return employeeID[searchedIndex];
	}//end of getEmployeeID

	//get method
	//method that will return productTitle
	public String getEmployeeName()
	{
		return employeeName[searchedIndex];
	}//end of getProductTitles

	//get method
	//method that will return productPrices
	public double getBonusPerSale()
	{	
		return bonusPerSale[searchedIndex];
	}//end of getProductPrice

	//get method
	//method that will return productID
	public String[] getEmployeeIDs()
	{
		return employeeID;
	}//end of getProductID

	//get method
	//method that will return productTitle
	public String[] getEmployeeNames()
	{
		return employeeName;
	}//end of getProductTitles

	//get method
	//method that will return productPrices
	public double[] getBonusPerSales()
	{
		return bonusPerSale;
	}//end of getProductPrice

	//get method
	//method that will return orderQuantity
	public int[] getOrderQuantitys()
	{
		return orderQuantity;
	}//end of getOrderQuantity

	//get method 
	//method that returns the value of orderTotal
	public double[] getOrderTotals()
	{
		return orderTotal;
	}//end of getOrderTotal

	//get method
	//method that will return fileCount
	public int getFileCount()
	{
		return fileCount;
	}//end of getFileCount

	//get method
	//method that will return fileFound
	public int getFilesFound()
	{
		return filesFound;
	}//end of getFileFound

	//get method
	public int getFilesNotFound()
	{
		return   filesFound - fileCount;
	}//end of getFileCount

	//get method
	//method that will return searchedIndex
	public int getSearchedIndex()
	{
		return searchedIndex;
	}//end of getSearchedIndex

	//get method
	//method that will return recordCount
	public int getRecordCount()
	{
		return recordCount;
	}//end of getRecordCount

	//get method
	//method that will return searchCount
	public int getSearchCount()
	{
		return searchCount;
	}//end of getSearchCount

	//get method
	//method that will return searchFound
	public int getSearchesFound()
	{
		return searchesFound;
	}//end of getSearchFound

	//get method
	public int getSearchesNotFound()
	{
		return searchCount - searchesFound;
	}//end of getSeachesNotFound

	//get method
	//method that will return the value for howMany
	public int getHowMany()
	{
		return howMany;
	}//end of getHowMany

	//get method 
	public double getTotalCost()
	{
		return bonusPerSale[searchedIndex] *  howMany; 
	}//end of getTotalCost

	//get method
	public int getWrittenOrderQuantity()
	{
		int localCount = 0;
		while(localCount < recordCount)
		{
			orderQuantity[recordCount] = orderQuantity[localCount] + orderQuantity[recordCount];
			localCount++;
		}
		return orderQuantity[recordCount];
	}//end of getWrittenQuantity

	//get method
	public double getWrittenOrderTotalCost()
	{

		int localCount = 0;
		while(localCount < recordCount)
		{
			orderTotal[recordCount] = orderTotal[localCount] + orderTotal[recordCount];
			localCount++;
		}
		return orderTotal[recordCount];
	}//end of getWrittenOrderTotalCost

}
