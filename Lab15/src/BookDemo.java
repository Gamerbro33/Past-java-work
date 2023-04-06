//RJ Allen
import java.util.Scanner;
public class BookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Book b1 = new Book();
		
		System.out.println("Creating the first Book object");
		System.out.println("Printing the default values of the first book object");
		System.out.println(b1.toString());
		System.out.println("");

		//user inputs the values of the first books
		System.out.println("Enter the title of the first book:");
		String title = input.nextLine();
		b1.setTitle(title);

		System.out.println("Enter the Author of the first book:");
		String author = input.nextLine();
		b1.setAuthor(author);

		System.out.println("Enter the Publisher of the first book:");
		String publish = input.nextLine();
		b1.setPublisher(publish);

		System.out.println("Enter the number of copies sold:");
		int copies = input.nextInt();
		b1.setCopies(copies);

		System.out.println("Enter the year of release of the first book:");
		int year = input.nextInt();
		b1.setYear(year);

		System.out.println("The updated values of the first book are:");
		System.out.println(b1.toString());
		
		Book b2 = new Book();

		//user inputs the values of the second books
		System.out.println("Enter the title of the second book:");
		input.nextLine();
		title = input.nextLine();
		b2.setTitle(title);

		System.out.println("Enter the Author of the second book:");
		author = input.nextLine();
		b2.setAuthor(author);

		System.out.println("Enter the Publisher of the second book:");
		publish = input.nextLine();
		b2.setPublisher(publish);

		System.out.println("Enter the number of copies sold:");
		copies = input.nextInt();
		b2.setCopies(copies);

		System.out.println("Enter the year of release of the second book:");
		year = input.nextInt();
		b2.setYear(year);
		
		System.out.println("the details of the second book are:");
		System.out.println(b2.toString());
		
		//if all the values of the first book are the same as the second
		if(b1.equals(b2))
		{
			
			System.out.println("the first book is same as the second book");
		}
		else
		{
			System.out.println("the first book is different as the second book");
		}
	}

}
