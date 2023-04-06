//AUTHOR: Robert Allen
//COURSE: CPT 187
//Purpose: create a record for the main class
//DATE: February 25 2020
package edu.cpt187.allen.finalexam;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RecordWriter 
{
	//declare and initialize class CONSTANTS
	//constants are REQUIRED with object attributes
	private final int FAILED_VALUE = -1;
	private final int RESET_VALUE = 0;

	//declare and initialize all nonCONSTANTS class attributes
	private String masterFileName = "";
	private boolean fileFoundFlag = false;
	private int recordCount = 0;

	//WritePurchaseOrder class constructor
	public RecordWriter(String borrowedFileName)
	{
		masterFileName = borrowedFileName;
	}//end of class constructor

	//set method
	public void setSaveOneRecord(String borrowedID, String borrowedName, double borrowedBonus, int borrowedQty, double borrowedTotal)
	{
		recordCount = RESET_VALUE;
		try
		{
			PrintWriter filePW = new PrintWriter (new FileWriter(masterFileName, true));
			filePW.printf("%s\t%s\t%.2f\t%d\t%.2f\r", borrowedID, borrowedName, borrowedBonus, borrowedQty, borrowedTotal);
			fileFoundFlag = true;
			recordCount++;
			//close the file
			filePW.close();
		}//END of try
		catch(IOException ex)
		{
			recordCount = FAILED_VALUE;
			fileFoundFlag = false;
		}//END of catch 
	}//end of setWriteOneRecord

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

	//get method 
	//method that return the value of recordCount
	public int getRecordCount()
	{
		return recordCount;
	}//end of getRecorCount
}
