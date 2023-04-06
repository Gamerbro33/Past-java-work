package edu.cpt167.RobertAllen.program1;
import java.util.Scanner;
public class PropertyConstruct 

{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);

String userName ="";
double backyardLength = 0.0;
double backyardWidth= 0.0;
double backyardSquareFootage = 0.0;
double playhouseLength = 0.0;
double playhouseWidth =0.0;
double playhouseSquareFootage=0.0;
double treehouseLength =0.0;
double treehouseWidth = 0.0;
double treehouseSquareFootage=0.0;
double coveredSquaredFootage=0.0;
double uncoveredSquaredFootage=0.0;

System.out.println("Let us get started with your name");
userName = input.next();
System.out.println("");

System.out.println("Thanks, " +userName+".");
System.out.println("The first thing we need to know your back yard info?");
System.out.println("");

System.out.println("First question, what is the length of your backyard in feet?");
backyardLength = input.nextDouble();
System.out.println("");

System.out.println("whats the width of your backyard in feet?");
backyardWidth = input.nextDouble();
System.out.println("");

System.out.println("Second question, how long or the length do you want the playhouse in feet?");
playhouseLength = input.nextDouble();
System.out.println("");

System.out.println("How Wide do you want the playhouse in feet?");
playhouseWidth = input.nextDouble();
System.out.println("");

System.out.println("Final question, How long do you want the tree house to be in feet");
treehouseLength = input.nextDouble();
System.out.println("");


System.out.println("And the width of the treehouse in feet");
treehouseWidth = input.nextDouble();
System.out.println("");

backyardSquareFootage = backyardLength * backyardWidth;
playhouseSquareFootage = playhouseLength * playhouseWidth;
treehouseSquareFootage = treehouseLength * treehouseWidth;
coveredSquaredFootage = backyardSquareFootage + playhouseSquareFootage;
uncoveredSquaredFootage = backyardSquareFootage - coveredSquaredFootage;

System.out.println("Thank you "+userName+".");
System.out.println("the following is the description of you your backyard design details");
System.out.println("");
System.out.println("results");
System.out.println("Backyard length: "+backyardLength+"feet");
System.out.println("Backyard width: "+backyardWidth+"feet");
System.out.println("Backyard Square footage: "+backyardSquareFootage+"feet");
System.out.println("");
System.out.println("Playhouse length: "+playhouseLength+"feet");
System.out.println("Playhouse width: "+playhouseWidth+"feet");
System.out.println("playhouse Square footage: "+playhouseSquareFootage+"feet");
System.out.println("");
System.out.println("Treehouse length: "+treehouseLength+"feet");
System.out.println("Treehouse width: "+treehouseWidth+"feet");
System.out.println("Treehouse Square footage: "+treehouseSquareFootage+"feet");
System.out.println("");
System.out.println("Covered Square footage: "+coveredSquaredFootage+"feet");
System.out.println("uncovered Square footage: "+uncoveredSquaredFootage+"feet");
System.out.println("");

input.close();



	}

}
