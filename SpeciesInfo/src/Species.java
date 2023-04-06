import java.util.Scanner;
public class Species {
	
	public String name;
	public String foodSource;
	public int population;
	public double growthRate;

	//storing user input
	public void readInput()
	{
		Scanner key = new Scanner(System.in);
		
		System.out.println("Enter the name of the species: ");
		
		name = key.nextLine();
		
		System.out.println("Enter food source:");
		foodSource = key.nextLine();
		
		System.out.println("Enter species population:");
		population = key.nextInt();
		
		System.out.println("Enter the annual growth rate(%):");
		growthRate = key.nextDouble();
		
	}
	/*
	 * Pre-Condition: calling object contains values
	 * Post-condition: The value are displayed on the console of a particular species 
	 */
	public void writeOutPut()
	{
		System.out.println("Species name=" +name);
		System.out.println("Food Source="+foodSource);
		System.out.println("Population= "+population);
		System.out.println("Annual Growth Rate="+growthRate+"%");
	}
	
	public int getPopulationIn10()
	{
		int result = 0;
		int count;
		double populationAmount = population;
		
		
		for(count=10; count > 0 && populationAmount > 0; count--)
		{
			populationAmount += populationAmount * (growthRate/100);
		}
		
		if(populationAmount > 0)
		{
			result = (int)populationAmount;
		}
		
		return result;
	}
	
	public int getPopulationGrowth(int years)
	{
		int result = 0;
		
		int count = years;
		
		double populationAmount = population;
		
		while(count > 0 && populationAmount > 0)
		{
			populationAmount += populationAmount * (growthRate/100);
			count--;
		}
		
		if(populationAmount > 0)
		{
			result = (int)populationAmount;
		}
		return result;
		
	}
}
