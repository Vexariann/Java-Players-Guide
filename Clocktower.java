import java.util.Scanner;

public class Clocktower
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Put in a number:");
		String number = input.next();
		
		try
		{
			int numberInt = Integer.parseInt(number);
			
			int result = numberInt % 2;
			
			if(result == 0)
			{
				System.out.println("Tick");
			}
			else
			{
				System.out.println("Tock");
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: one of your inputs was not a valid number. Please try again.\n\n");
			main(args);					
		}
	}
}
