import java.util.Scanner;

public class DominionOfKings
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the royal kings score calculator!");
		System.out.println("This app is made to conclude once and for all who has the best kingdom.");
		System.out.println("The system will be counting points based on the following:");
		System.out.println("- Every estate is worth 1 point");
		System.out.println("- Every duchy is worth 3 points");
		System.out.println("- Every province is worth 6 points");
		System.out.println("\nHow many estates does your kingdom have?");
		String estates = input.next();
		System.out.println("\nHow many duchies does your kingdom have?");
		String duchies = input.next();
		System.out.println("\nHow many provinces does your kingdom have?");
		String provinces = input.next();
		
		try
		{
			int estatesInt = Integer.parseInt(estates);
			int duchiesInt = Integer.parseInt(duchies);
			int provincesInt = Integer.parseInt(provinces);
			
			int duchiesResult = duchiesInt * 3;
			int provincesResult = provincesInt * 6;
			
			int total = estatesInt + duchiesResult + provincesResult;
			
			System.out.println("\nYour kingdom has a total score of: " + total);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: one of your inputs was not a valid number. Please try again.\n\n");
			main(args);			
		}
	}
}