import java.util.Scanner;

public class ThingNamer
{
	public static void main(String[] args)
	{
		System.out.println("What kind of thing are we talking about?");
		Scanner input = new Scanner(System.in);
		// a stores the input from the user
		String a = input.next();
		System.out.println("How would you describe it? Big? Azure? Tattered?");
		/* b also stores the input from the user
		 * c stores a string with the text "of Doom"
		 * d stores a string with the text "3000"
		 */
		String b = input.next();
		String c = "of Doom";
		String d = "3000";
		System.out.println("The " + b + " " + a + " " + c + " " + d + "!");
	}
}