//RJ Allen
import java.util.Arrays;
import java.util.Scanner;
public class BoxSorter {
	public static final int BOX_SIZE = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//import scanner and the box object
		Scanner input = new Scanner(System.in);
		Box[] box;
		box =  new Box[BOX_SIZE];

		int counter = 0;

		System.out.println("Welcome of the box sorter!");
		System.out.println("Enter the information about boxes and I'll sort them!");
		System.out.println("Enter the label, Length, width and height(in feet) of Box "+counter+":");
		String label = input.nextLine();

		double length = input.nextDouble();
		double width = input.nextDouble();
		double height = input.nextDouble();
		box[counter] = new Box(label, length, width, height);
		++counter;
		
		//while loop
		while(counter < 5)
		{
			System.out.println("Enter the label, Length, width and height(in feet) of Box "+counter+":");
			input.nextLine();
			label = input.nextLine();
			length = input.nextDouble();
			width = input.nextDouble();
			height = input.nextDouble();
			box[counter] = new Box(label, length, width, height);
			++counter;
		}

		//for loop for sorting
		 for (int i = 0; i <box.length; i++) {     
	          for (int j = i+1; j <box.length; j++) {     
	              if(box[i].getVolume() >box[j].getVolume()) {      //swap elements if not in order
	                 Box temp = box[i];    
	                 box[i] = box[j];    
	                 box[j] = temp;    
	               }     
	            }     
	        }    
		System.out.println("Sorted boxes");

		for(int i = 0; i < box.length; i++)
		{
			if(box[i] != null)
			{
				System.out.println(box[i].toString());

			}
		}
	}

}
