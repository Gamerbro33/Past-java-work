//RJ Allen
import java.util.Scanner;
public class Lab9 {
	// set value for the first character
	public static final int ZERO = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//user enter word
		System.out.println("Enter your word to see if it is special or not:");

		String word = input.next();
		int x = ZERO;

		String restLetter = word.substring(1,word.length());

		String back = new String();

		//while loop

		while(x < word.length()-1)
		{


			back =  restLetter.charAt(x) + back ;
			x++;
		}
		//if the the word does have a special property
		if(restLetter.equalsIgnoreCase(back))
		{
			System.out.println("Success!!! You entered a special word!");


		}
		else
		{
			System.out.println("Failure! You entered an ordinary word.");


		}

	}

}
