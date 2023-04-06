//RJ Allen
import java.util.Scanner;
public class Lab8 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Import Scanner
		int points = 0;
		Scanner input = new Scanner(System.in);
		//Allow user to input how many books
		System.out.println("How many books did you purchase at BN booksellers this month?");
		int books = input.nextInt();
		if(books >= 0)
		{
		//switch statement 
		switch(books)
		{
		case 0:
			points = 0;
			System.out.println("You have not earned any points yet. Make a book purchase to start earning points!");
			break;
		case 1:
			points = 5;
			System.out.println("Congratulations!!! You have earned "+points+" points! You may redeem these points on your next book purchase!");
			break;
		case 2:
			points = 15;
			System.out.println("Congratulations!!! You have earned "+points+" points! You may redeem these points on your next book purchase!");
			break;
		case 3:
			points = 30;
			System.out.println("Congratulations!!! You have earned "+points+" points! You may redeem these points on your next book purchase!");
			break;
		case 4:
			points = 60;
			System.out.println("Congratulations!!! You have earned "+points+" points! You may redeem these points on your next book purchase!");
		break;
		default:
			points = 60;
			System.out.println("Congratulations!!! You have earned "+points+" points! You may redeem these points on your next book purchase!");
	
		}
		}
		else
		{
			System.out.println("Invalid value entered! Exiting the program!");
			System.exit(0);
		}
	}

}
