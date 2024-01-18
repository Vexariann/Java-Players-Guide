import java.util.Scanner;

public class ConsolasDefense
{
	
	public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello sarge, the city is under attack! Please choose where we should deploy in a target row and column.");
		System.out.println("\nChoose a row");
		String row = input.next();
		System.out.println("\nChoose a column");
		String column = input.next();
		
		try
		{
			var rowInt = Integer.parseInt(row);
			var columnInt = Integer.parseInt(column);
		}
		catch(NumberFormatException e)
		{
			System.out.println(RED + "\nERROR: one of your inputs was not a valid number. Please try again.\n\n" + RESET);
			main(args);					
		}
	}
}