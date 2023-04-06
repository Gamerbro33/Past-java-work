import java.util.Scanner;
public class TacoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		
		TacosDB tdb = new TacosDB();
		System.out.println("Welcome to the tacos Demo! ");
		boolean quit = false;
		
		
		while(quit == false)
		{
		System.out.println("\nEnter 1 to add a taco \nEnter 2 to remove a taco \nEnter 3 to view the taco database \nEnter 9 to quit:");
		int userInput = key.nextInt();
		
		switch(userInput)
		{
		case 1:
			System.out.println("Enter the name of the taco:");
			String name = key.nextLine();
			
			System.out.println("Enter taco price:");
			double price = key.nextDouble();
			
			tdb.addTaco(name, price);
			break;
		case 2:
			System.out.println("Enter the taco name");
			name = key.nextLine();
			
			System.out.println("Enter the tac o price");
			price = key.nextDouble();
			
			tdb.removeTaco(new Taco(name, price));
			break;
		case 3:
			System.out.println(tdb.toString());
			break;
		case 9:
			quit = true;
			break;
			default:
				System.out.println("Invalid entry");
		}
		}
	}

}
