import java.util.Scanner;

public class Shop
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello, welcome to my shop. What item would like to see?");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1. Rope");
		System.out.println("2. Torches");
		System.out.println("3. Climbing Equipment");
		System.out.println("4. Clean Water");
		System.out.println("5. Machete");
		System.out.println("6. Canoe");
		System.out.println("7. Food Supplies");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		String selection = input.next();
		System.out.println("\nAnd what's your name?");
		String name = input.next();
		
		try
		{
			int selectionInt = Integer.parseInt(selection);
			boolean isHero = false;
			int price;
			
			if(name.equals("Hero"))
			{
				System.out.println("\nOh! Welcome back Hero. Thanks again for your help. As a token of my gratitude i'll half all my prices just for you.\n");
				isHero = true;
			}
			
			switch(selectionInt)
			{
				case 1:
					price = 10;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Rope");
					System.out.println("Description: Very useful for getting out of sticky situations.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 2:
					price = 15;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Torches");
					System.out.println("Description: Very useful for seeing in dark caves or during the night.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 3:
					price = 25;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Climbing Equipment");
					System.out.println("Description: Scale the tallest mountains like no other with this climbing equipment set.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 4:
					price = 1;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Clean Water");
					System.out.println("Description: Restores 30 HP.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 5:
					price = 20;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Machete");
					System.out.println("Stats:");
					System.out.println("10 ATK");
					System.out.println("5% ATKSPD");
					System.out.println("Description: A ordinary machete that is capable of doing simple tasks.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 6:
					price = 200;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Canoe");
					System.out.println("Description: A key item to cross the lake of StackOverflow.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				case 7:
					price = 1;
					if(isHero == true)
					{
						price = price / 2;
					}
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("Item name: Food Supplies");
					System.out.println("Description: Gives a +5% ATK and DEF boost for 3 turns.");
					System.out.println("Cost: " + price + " gold");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
				default:
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("That item does not exist.");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nERROR: your input was not a valid number. Please try again.\n\n");
			main(args);					
		}
	}
}