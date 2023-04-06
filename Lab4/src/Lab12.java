//RJ Allen
import java.util.Scanner;
public class Lab12 {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
	
		// TODO Auto-generated method stub
		//Array list of days
		int[] days = {1,2,3,4,5,6,7};
		double average = 0;
		double sum =0;
		double[] priceArray = new double[7];
		//for loop for users input of gas prices
		for(int i=0; i < days.length; i++)
		{
			
			System.out.println("Enter the gas price(per gallon) on Day "+days[i]);
			
			priceArray[i] = input.nextDouble();
			if(priceArray[i] >=0)
			{
				
			sum += priceArray[i];
			}
			else
			{
				System.out.println("error exiting program");
				System.exit(0);
			}
			
		}
		//calulate the average
		average += sum/days.length;
		System.out.println("The average price for 1 gallon of gas during the last 7 days = $"+average);
		
		
		System.out.println("The price was above average on ");
		//for loop for the the days higher than average
		for(int i = 0; i < days.length; i++)
		{
			if(priceArray[i] > average)
			System.out.println("Day "+days[i]+": "+priceArray[i]);
		}
	}

}
