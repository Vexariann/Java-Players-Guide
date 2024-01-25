import java.util.Scanner;

public class Watchtower
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		// System.out.println("Hello sarge, i've heard you received coordinates of the closest enemy camp?");
		// System.out.println("\nWhat's the X coordinate?");
		// String xcoordinate = input.next();
		// System.out.println("\nWhat's the Y coordinate?");
		// String ycoordinate = input.next();
		
		int xcoordinateInt = askForNumber("\nWhat's the X coordinate?");
		int ycoordinateInt = askForNumber("\nWhat's the Y coordinate?");
		
		try
		{
			// int xcoordinateInt = Integer.parseInt(xcoordinate);
			// int ycoordinateInt = Integer.parseInt(ycoordinate);
			
			String DirectionX = "";
			String DirectionY = "";
			
			if (ycoordinateInt == 0 && xcoordinateInt == 0)
			{
				System.out.println("\nThat's the location of our watchtower you dummy!");
				return;
			}
			
			// x coordinate
			if(xcoordinateInt > 0)
			{
				DirectionX = "east";
			}
			else if (xcoordinateInt < 0)
			{
				DirectionX = "west";
			}
			else
			{
				DirectionX = "";
			}
			
			// y coordinate
			if(ycoordinateInt > 0)
			{
				DirectionY = "north";
			}
			else if (ycoordinateInt < 0)
			{
				DirectionY = "south";
			}
			else
			{
				DirectionY = "";
			}
			
			System.out.println("The enemy appears to be coming from " + DirectionY + DirectionX);
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: one of your inputs was not a valid number. Please try again.\n\n");
			main(args);					
		}
	}
	
	public static int askForNumber(String text)
	{
		Scanner input = new Scanner(System.in);
		int numberInt = 0;
		
		System.out.println(text);
		String number = input.next();
		try
		{
			return numberInt = Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: your input was not a valid number. Please try again.\n\n");
			return askForNumber(text);
		}
	}
}