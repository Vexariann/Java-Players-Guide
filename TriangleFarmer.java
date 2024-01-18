import java.util.Scanner;

public class TriangleFarmer
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the triangle area calculator.");
		System.out.println("\nWhat's the base of the triangle?");
		String base = input.next();
		System.out.println("\nAnd what's the height of the triangle?");
		String height = input.next();
		
		try
		{
			int baseInt = Integer.parseInt(base);
			int heightInt = Integer.parseInt(height);
			
			int area = baseInt * heightInt / 2;
			
			System.out.println("\nThe area of the triangle is: " + area);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: one of your inputs was not a valid number. Please try again.\n\n");
			main(args);
		}
	}
 }