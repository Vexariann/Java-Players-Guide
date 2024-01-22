import java.util.Scanner;

public class ThePrototype
{
	public static void main(String[] args)
	{
		int targetNumber;
		Scanner input = new Scanner(System.in);
		
		System.out.println("User 1, enter a number between 0 and 100");
		String number = input.next();
		
		try
		{
			targetNumber = Integer.parseInt(number);
			int guess = -9999;
			
			ClearScreen();
			
			System.out.println("User 2, Guess the number.");
			do
			{
				System.out.println("\nWhat is your next guess?");
				String guessInput = input.next();
				guess = Integer.parseInt(guessInput);
				if (guess > targetNumber)
				{
					System.out.println("Number is too high.");
				}
				else if (guess < targetNumber)
				{
					System.out.println("Number is too low.");
				}
				else
				{
					System.out.println("\nYou guessed the number! It was " + targetNumber);
				}
			}
			while(guess != targetNumber);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: your input was not a valid number. Program will abort.");
		}
	}
	
	public static void ClearScreen()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println("");
		}
	}
}