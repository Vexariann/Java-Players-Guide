import java.util.Scanner;

enum FoodTypes{
	SOUP,
	STEW,
	GUMBO
}

enum Ingredients{
	MUSHROOM,
	CHICKEN,
	CARROT,
	POTATOES
}
	
enum Seasoning{
	HOT,
	SALTY,
	SWEET
}

public class SimulaSoup{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Let's make a new brew!");
		System.out.println("Choose a Food type of your choice:");
		System.out.println("1. " + FoodTypes.SOUP.name().toLowerCase());
		System.out.println("2. " + FoodTypes.STEW.name().toLowerCase());
		System.out.println("3. " + FoodTypes.GUMBO.name().toLowerCase());
		int choice1 = askForNumberInRange("", 1, 3);
		
		System.out.println("Choose a ingredient of your choice:");
		System.out.println("1. " + Ingredients.MUSHROOM.name().toLowerCase());
		System.out.println("2. " + Ingredients.CHICKEN.name().toLowerCase());
		System.out.println("3. " + Ingredients.CARROT.name().toLowerCase());
		System.out.println("4. " + Ingredients.POTATOES.name().toLowerCase());
		int choice2 = askForNumberInRange("", 1, 4);
		
		System.out.println("Choose a seasoning of your choice:");
		System.out.println("1. " + Seasoning.HOT.name().toLowerCase());
		System.out.println("2. " + Seasoning.SALTY.name().toLowerCase());
		System.out.println("3. " + Seasoning.SWEET.name().toLowerCase());
		int choice3 = askForNumberInRange("", 1, 3);
		
		
		Soup soup1 = new Soup(choice1, choice2, choice3);
		System.out.println("You made: " + soup1.seasoning.name().toLowerCase() +" "+ soup1.ingredients.name().toLowerCase() +" "+ soup1.foodTypes.name().toLowerCase());
	}
	
	public static int askForNumberInRange(String text, int min, int max)
	{
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println(text);
			if(input.hasNextInt()){
				int number = input.nextInt();
				input.nextLine();
				if (number >= min && number <= max){
					return number;	
				} else {
					System.out.println("\nERROR: your input is out of range. Please try again.\n\n");
				}
			} else {
				input.nextLine();
				System.out.println("\nERROR: your input was not a valid number. Please try again.\n\n");
			}
		}
		while(true);
	}
}

class Soup {
	public FoodTypes foodTypes;
	public Ingredients ingredients;
	public Seasoning seasoning;
	
	public Soup(int choice1, int choice2, int choice3){
		
		/* Not entirely happy with the solution below. Possible ways to refactor this:
		 * 1. Set the choices over to enum values before calling new Soup
		 * 2. look into ways to call enum value based off int rather than using if else statements
		 */
		
		// set foodtype
		if(choice1 == 1){
			this.foodTypes = FoodTypes.SOUP;
		}
		else if(choice1 == 2){
			this.foodTypes = FoodTypes.STEW;
		} else {
			this.foodTypes = FoodTypes.GUMBO;
		}
		
		// set ingredients
		if(choice2 == 1){
			this.ingredients = Ingredients.MUSHROOM;
		}
		else if(choice2 == 2){
			this.ingredients = Ingredients.CHICKEN;
		}
		else if(choice2 == 3){
			this.ingredients = Ingredients.CARROT;
		} else {
			this.ingredients = Ingredients.POTATOES;
		}
		
		//set seasoning
		if(choice3 == 1){
			this.seasoning = Seasoning.HOT;
		}
		else if(choice3 == 2){
			this.seasoning = Seasoning.SALTY;
		} else {
			this.seasoning = Seasoning.SWEET;
		}
	}
}