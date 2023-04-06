package edu.cpt167.robertAllen.participation;
import java.util.Scanner;
public class robertAllenSodNotZod 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
 Scanner input  = new Scanner(System.in);
 String userName = "";
  String itemName = "";
  double originalPrice = 0.0;
  int howMany = 0;
  double totalCost = 0.0;
  double discountAmount = 0.0;
  double discountPrice = 0.0;
  final double DISCOUNT_RATE = 0.25;
  
 
  System.out.println("hello whats your name");
  userName = input.nextLine();
  
  System.out.println("Hello "+userName);
  
  System.out.println("what is the name of the product you would like to buy");
  itemName = input.nextLine();
  System.out.println("how much is the sticker price of the product");
  originalPrice = input.nextDouble();
  System.out.println("How many of the product are you wanting to purchase today");
  howMany = input.nextInt();
  
  discountAmount = originalPrice * DISCOUNT_RATE;
  discountPrice = originalPrice - discountAmount;
  totalCost = discountPrice * howMany;
  
  System.out.println("\nORDER REPORT");
  System.out.println("Item Purchase: "+itemName);
  System.out.println("Discount: 25.0%");
  System.out.println("Original Price: "+originalPrice);
  System.out.println("Discount Amount: $"+discountAmount);
  System.out.println("Discount Price: $"+discountPrice);
  System.out.println("Number of items: "+howMany);
  System.out.println("Order Total: $"+totalCost+"\n");
  System.out.println("We Thank you for your business and we hope you have a great day");
  input.close();
	}

}
