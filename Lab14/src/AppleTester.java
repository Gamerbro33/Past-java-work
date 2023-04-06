//RJ Allen
import java.util.Scanner;

public class AppleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//display the default apples for incorrect inputs
		System.out.println("Welcome to the Apple Tester!!!");
		System.out.println("Creating the first apple!");
		System.out.println("Default values of the first apple object:");
		Apple ap1 = new Apple();
		ap1.writeOutput();
		
		//user inputs second apple
		System.out.println("Creating the Second apple!");
		System.out.println("Enter the type of the second apple");
		
		String type = input.nextLine();
		input.nextLine();
		ap1.setType(type);
		
		System.out.println("Enter the weight of the second apple object:");
		double weight = input.nextDouble();
		ap1.setWeight(weight);
		
		System.out.println("Enter the price of the second apple object:");
		double price = input.nextDouble();
		ap1.setPrice(price);
		
		//display second apples
		ap1.writeOutput();
		
		//users input third apple
		System.out.println("Creating the third apple!");
		System.out.println("Enter the type of the third apple");
		type = input.nextLine();
		input.nextLine();
		ap1.setType(type);
		
		System.out.println("Enter the weight of the third apple object:");
		weight = input.nextDouble();
		ap1.setWeight(weight);
		
		System.out.println("Enter the price of the third apple object:");
		price = input.nextDouble();
		ap1.setPrice(price);
		//display third apple
		ap1.writeOutput();
	}

}
