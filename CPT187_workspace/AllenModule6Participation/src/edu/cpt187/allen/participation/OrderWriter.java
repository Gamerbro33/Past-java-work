//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: Help support the main class.
//DATE: February 17 2020
package edu.cpt187.allen.participation;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderWriter 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final int NOT_FOUND = -1;
	private final int RESET_VALUE = 0;
	
	//declare and initialize all nonCONSTANTS class attributes
	private String masterFileName = "";
	private boolean fileFoundFlag = false;
	private int recordCount = 0;
	
	//OrderWriter class Constructor
	public OrderWriter(String borrowedFileName)
	{
		masterFileName = borrowedFileName;
	}//end of class constructor
	
	//set method 
	public void setWriteOrder(int borrowedItemID, String borrowedItemName, double borrowedItemPrice, int borrowedQuantity, double borrowedOrderCost)
	{
		recordCount = RESET_VALUE;
		try
		{
			PrintWriter filePW = new PrintWriter (new FileWriter(masterFileName, true));
			filePW.printf("%d\t%s\t%f\t%d\t%f\r", borrowedItemID, borrowedItemName, borrowedItemPrice, borrowedQuantity, borrowedOrderCost);
			fileFoundFlag = true;
			recordCount++;
			//close the file
			filePW.close();
		}//END of try
		catch(IOException ex)
		{
			recordCount = NOT_FOUND;
			fileFoundFlag = false;
		}//END of catch 
	}//end of setWriterOrder
	
	//get method
	// this method return the value of masterFileName
	public String getFileName()
	{
		return masterFileName;
	}//end of getFileName
	
	//get method
	//this method return the value of fileFoundFlag
	public boolean getFileFoundFlag()
	{
		return fileFoundFlag;
	}//end of getfileFoundFlag
	
	public int getRecordCount()
	{
		return recordCount;
	}
}
