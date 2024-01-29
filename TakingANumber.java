import java.util.Scanner;

public class TakingANumber
{
	public static void main(String[] args)
	{
		int number1 = askForNumber("Fill in a number to display on screen");
		System.out.println(number1);
		
		int number2 = askForNumberInRange("Fill in a number between 1 and 10 to display on screen", 1, 10);
		System.out.println(number2);
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
	
	public static int askForNumberInRange(String text, int min, int max)
	{
		Scanner input = new Scanner(System.in);
		int numberInt = 0;
		
		System.out.println(text);
		String number = input.nextLine();
		try
		{
			numberInt = Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: your input was not a valid number. Please try again.\n\n");
			return askForNumberInRange(text, min, max);
		}
		
		if (numberInt > min && numberInt < max)
		{
			return numberInt;	
		}
		else
		{
			System.out.println("\nERROR: your input is out of range. Please try again.\n\n");
			return askForNumberInRange(text, min, max);
		}
	}
}