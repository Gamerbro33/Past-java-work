//RJ Allen
import java.util.Scanner;
public class Lab10 {
	public static void main(String[] args)
	{
		//import Scanner
		Scanner input = new Scanner(System.in);
		
		
		
		
		
		System.out.println("How many dollars would you like to spend on chocolate from the vending machine:");
		int dollar = input.nextInt();
		int chocolate = dollar;
		int coupons = chocolate;
		//while loop
		while(coupons >=6)
		{
			coupons -=6;
			chocolate++;
			coupons++;
		}
		//print out how many coupons and chocolates they got
		System.out.println("You can buy "+chocolate+" and will have "+coupons+" coupons left");
	}
}
