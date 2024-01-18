import java.util.Scanner;

public class Duckbear
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the chocolate eggs equalizer.");
		System.out.println("\nHow many eggs were gathered today?");
		String amount = input.next();
		
		try
		{
			int amountInt = Integer.parseInt(amount);
			
			int resultSisters = amountInt / 4;
			int resultDuckbear = amountInt % 4;
			
			System.out.println("\nThe sisters will each receive " + resultSisters + " eggs.");
			System.out.println("The Duckbear will receive " + resultDuckbear + " eggs.");
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: Your input was not a valid number. Please try again.\n\n");
			main(args);
		}
	}
 }