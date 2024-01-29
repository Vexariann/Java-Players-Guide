import java.util.Scanner;

public class Watchtower
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int xcoordinate = askForNumber("\nWhat's the X coordinate?");
		int ycoordinate = askForNumber("\nWhat's the Y coordinate?");
			
		String directionX = "";
		String directionY = "";
		
		if (ycoordinate == 0 && xcoordinate == 0)
		{
			System.out.println("\nThe enemy is here!");
			return;
		}
		
		// x coordinate
		if(xcoordinate > 0)
		{
			directionX = "east";
		}
		else if (xcoordinate < 0)
		{
			directionX = "west";
		}
		
		// y coordinate
		if(ycoordinate > 0)
		{
			directionY = "north";
		}
		else if (ycoordinate < 0)
		{
			directionY = "south";
		}
		
		System.out.println("The enemy is to the " + directionY + directionX = "!");
	}
	
	public static int askForNumber(String text)
	{
		Scanner input = new Scanner(System.in);
		int number = 0;
		
		System.out.println(text);
		String numberAsText = input.next();
		try
		{
			return number = Integer.parseInt(numberAsText);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: your input was not a valid number. Please try again.\n\n");
			return askForNumber(text);
		}
	}
}