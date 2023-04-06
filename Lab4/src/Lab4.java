//RJ Allen
import java.util.Scanner;

public class Lab4 {

	public static final double ACCELERATION = 9.8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		//scanner
		Scanner input = new Scanner(System.in);
		
		//user enters intial velocity
		System.out.println("Enter the Intial velocity of the ball (in meter per second) at point A:");
		double intialVelocity = input.nextDouble();
		//user enters the time taken
		System.out.println("How Munch time(in Seconds) does the ball take to reach point B");
		int time = input.nextInt();
		
		//calculate equation
		double velocity = intialVelocity + (ACCELERATION * time);
		double totalDistance = (intialVelocity * time ) + 0.5 * ACCELERATION * Math.pow(time, 2);
		
		//display the outcome
		System.out.println("Final velocity of the ball = "+velocity+" m/s");
		System.out.println("Distance traveled by the ball(S) = "+totalDistance+" meters");
		
		
	}

}
