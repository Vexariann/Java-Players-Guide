import java.util.Scanner;

public class HuntingManticore
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
	
	static int manticoreLocation = -9999;
	static int cityHealth = 15;
	static int manticoreHealth = 10;
	static int currentRound = 1;
	
	static int cannonDamage = 1;
	static int fireCharge = 0;
	static int electricCharge = 0;
	
	
	public static void main(String[] args)
	{
		initializeGame();
		turn();
	}
	
	public static void initializeGame()
	{
		manticoreLocation = askForNumberInRange(ANSI_RED + "Oh almighty one, how far away from the city do you want to station the Manticore?" + ANSI_RESET, 0, 100);
		ClearScreen();
		System.out.println(ANSI_RED + "Defenders, it is your turn. You'll never hit me muahahahaha!" + ANSI_RESET);
	}
	
	public static void turn()
	{
		DetermineCannonDamage();
		ShowStatus();
		int target = askForNumberInRange("Enter desired cannon range:", 0, 100);
		calculateHit(target);
	}
	
	public static void calculateHit(int target)
	{
		if (target > manticoreLocation)
		{
			System.out.println("That round " + ANSI_RED + "OVERSHOT" + ANSI_RESET + " the target.");
		}
		else if(target < manticoreLocation)
		{
			System.out.println("that round " + ANSI_RED + "FELL SHORT" + ANSI_RESET + " of the target.");
		}
		else
		{
			System.out.println("That round was a " + ANSI_GREEN + "DIRECT HIT!" + ANSI_RESET);
			manticoreHealth = manticoreHealth - cannonDamage;
		}
		
		cityHealth--;
		currentRound++;
		
		if(CheckWinCondition() == true)
		{
			return;
		}
		else
		{
			turn();
		}
	}
	
	public static int askForNumberInRange(String text, int min, int max)
	{
		Scanner input = new Scanner(System.in);
		int numberInt = 0;
		
		System.out.println(text);
		String number = input.next();
		try
		{
			numberInt = Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			System.out.println(ANSI_RED + "\nERROR: your input was not a valid number. Please try again.\n\n" + ANSI_RESET);
			return askForNumberInRange(text, min, max);
		}
		
		if (numberInt > min && numberInt < max)
		{
			return numberInt;	
		}
		else
		{
			System.out.println(ANSI_RED + "\nERROR: your input is out of range. Please try again.\n\n" + ANSI_RESET);
			return askForNumberInRange(text, min, max);
		}
	}
	
	public static void ClearScreen()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println("");
		}
	}
	
	public static void ShowStatus()
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("STATUS: " + ANSI_CYAN + " Round: " + ANSI_RESET + currentRound + " " + ANSI_GREEN + "City: " + ANSI_RESET + cityHealth + "/15 " + ANSI_RED + "Manticore: " + ANSI_RESET + manticoreHealth + "/10");
		System.out.println("The cannon is expected to deal " + ANSI_CYAN + cannonDamage + " damage" + ANSI_RESET + " this round.");
	}
	
	public static void DetermineCannonDamage()
	{
		electricCharge++;
		fireCharge++;
		
		if(fireCharge == 3 && electricCharge == 5)
		{
			cannonDamage = 10;
			electricCharge = 0;
			fireCharge = 0;
		}
		else if(fireCharge == 3)
		{
			cannonDamage = 3;
			fireCharge = 0;
		}
		else if(electricCharge == 5)
		{
			cannonDamage = 3;
			electricCharge = 0;
		}
		else
		{
			cannonDamage = 1;
		}
	}
	
	public static boolean CheckWinCondition()
	{
		if (manticoreHealth <= 0 || cityHealth <= 0)
		{
			if(manticoreHealth <= 0)
			{
				System.out.println(ANSI_GREEN + "The Manticore has been destroyed! The city of Consolas has been saved!" + ANSI_RESET);
				return true;
			}
			else
			{
				System.out.println(ANSI_RED + "Unfortunately you were not able to stop the Manticore. The city of Consolas has been destroyed." + ANSI_RESET);
				return true;
			}
		}
		else
		{
			return false;
		}
	}
}