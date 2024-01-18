import java.util.Scanner;
import java.awt.Toolkit;

public class ConsolasDefense
{
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println(ANSI_PURPLE + "Hello sarge, the city is under attack! Please choose where we should deploy in a target row and column." + ANSI_RESET);
		System.out.println("\nChoose a target row");
		String row = input.next();
		System.out.println("\nChoose a target column");
		String column = input.next();
		
		try
		{
			int rowInt = Integer.parseInt(row);
			int columnInt = Integer.parseInt(column);
			
			int rowPlus = rowInt +1;
			int rowMinus = rowInt -1;
			int columnPlus = columnInt + 1;
			int columnMinus = columnInt -1;
			
			System.out.println("\nGotcha sarge, the troops will de deploying at the follow coordinates:");
			System.out.println("Troop 1 will be deployed at: " + rowPlus + ", " + columnInt);
			System.out.println("Troop 2 will be deployed at: " + rowMinus + ", " + columnInt);
			System.out.println("Troop 3 will be deployed at: " + rowInt + ", " + columnPlus);
			System.out.println("Troop 4 will be deployed at: " + rowInt + ", " + columnMinus);
			System.out.println("The target will be at: " + rowInt + ", " + columnInt);
			
			Toolkit.getDefaultToolkit().beep();
		}
		catch(NumberFormatException e)
		{
			System.out.println(ANSI_RED + " \nERROR: one of your inputs was not a valid number. Please try again.\n\n" + ANSI_RESET);
			main(args);					
		}
	}
}