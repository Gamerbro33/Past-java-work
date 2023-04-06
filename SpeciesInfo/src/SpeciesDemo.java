import java.util.Scanner;
public class SpeciesDemo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//create an object of type species
		Species sp1= new Species();
		Scanner key = new Scanner(System.in);
		sp1.readInput();
		
		sp1.writeOutPut();
		
		int futurePopulation = sp1.getPopulationIn10();
		
		System.out.println("Population in 10 years= "+futurePopulation);
		
		System.out.println("Enter the number of years for which you would like to forecast the population growth:");
		
		int years= key.nextInt();
		
		int futurePopulations = sp1.getPopulationGrowth(years);
		
		System.out.println("Future populationin in "+years+" years = "+futurePopulations);
		
		Species sp2 = new Species();
		
		sp2.name = "Killer Whale";
		sp2.foodSource = "Shrimp";
		sp2.population = 200;
		sp2.growthRate = 1.7;
		sp2.writeOutPut();
	}

}
