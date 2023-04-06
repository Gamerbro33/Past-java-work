//RJ Allen
import java.util.Scanner;
public class Lab11 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the height of the triangle");
		int ans = input.nextInt();
		//for loop building up
		for (int i = 0; i <= ans; i++) {
		    for (int j = 0; j < i; j++) {
		    	
		        System.out.print("*");
		        
		    }
		    System.out.println("");
		    
		}
		//for loop building down
		for (int i = ans -1; i !=0 ; i--) {
		    for (int j = i; j != 0; j--) {
		    	
		        System.out.print("*");
		        
		    }
		    System.out.println("");
		    
		}
		
	}

}
