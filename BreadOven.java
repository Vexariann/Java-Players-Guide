import java.util.Scanner;

public class BreadOven
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Bread is ready.");
		System.out.println("Who is the bread for?");
		String receiver = input.nextLine();
		System.out.println("Noted: " + receiver + " got bread.");
	}
}