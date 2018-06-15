package assignments;

import java.util.Random;
import java.util.Scanner;

public class dice {

	int n;
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		diceRolling dc= new diceRolling();
		Random ab= new Random();
		while(true)
		{
			System.out.println("if you want to play then select the dice phase:-");
			System.out.println("press 2--for two face  4--for four face   6--for six face");
			int dicePhase= sc.nextInt();
			switch(dicePhase)
		{
		case 2:
			System.out.println("wait your dice is rolling now...");
			
			int value= ab.nextInt(2);
			System.out.println(value);
			System.out.println("");
			break;
		case 4:
			System.out.println("wait your dice is rolling now...");
			int value2= ab.nextInt(4);
			System.out.println(value2);
			System.out.println("");
			break;
		case 6:
			System.out.println("wait your dice is rolling now...");
			int value3= ab.nextInt(6);
			System.out.println(value3);
			System.out.println("");
			break; 
		default:
			System.out.println("we don't have this number of face of dice");
			break;
		}	
		}
}
}