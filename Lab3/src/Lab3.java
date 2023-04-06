//RJ Allen
import java.util.Scanner;
public class Lab3 {
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		//User is ask inputs 7 words
		System.out.println("Eneter a sentence containing 7 word");
		
		//show the result of what the user inputs
		System.out.println("Inserting an asterisk and printing the words in reverse order:");
		
		//will read all users inputs in the seven words
		String wordOne = key.next();
		String wordTwo = key.next();
		String wordThree = key.next();
		String wordFour = key.next();
		String wordFive = key.next();
		String wordSix = key.next();
		String wordSeven = key.next();
		
		// will display the users sentence backwards
		System.out.println("Inserting an asterisk and Printing the words in reverse order");
		
		System.out.println(""+wordSeven+" * "+wordSix+" * "+wordFive+" * "+wordFour+" * "+wordThree+" * "+wordTwo+" * "+wordOne);
	}
}
