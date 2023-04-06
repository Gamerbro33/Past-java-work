import java.util.Scanner;
public class ProductDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product();
		Scanner key = new Scanner(System.in);
		
		System.out.println("First object value\n"+p1.toString());
		
		Product p2 = new Product(1200,"Laptop", 2);
		
		System.out.println("Values of the Second object:\n"+p2.toString());

		//create a third object
		Product p3 = new Product(p2);
		
		System.out.println("The values of the third object:\n"+p3.toString());
		
		if(p2.equals(p3))
		{
			
			System.out.println("Objects p2 and p3 are equal!");
		}
		else
		{
			System.out.println("Objects p2 and p3 are not equal!");
		}
		
		System.out.println("Total Cost: $"+p2.totalCost());
		
		System.out.println("Enter the new price of the laptop");
		double newPrice = key.nextDouble();
		System.out.println("totalCost:$"+p2.totalCost(newPrice));
		
		System.out.println("Enter the latest price of the laptop:");
		
		double latestPrice = key.nextDouble();
		
		System.out.println("Enter the count of laptops:");
		
		int laptopCount = key.nextInt();
		System.out.println("Total Cost using the 3rd overloading method "+p2.totalCost(latestPrice,laptopCount));
	}

}
