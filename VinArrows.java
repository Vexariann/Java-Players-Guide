import java.util.Scanner;

enum ArrowHead{
	STEEL,
	WOOD,
	OBSIDIAN
}

enum Fletching{
	PLASTIC,
	TURKEY_FEATHERS,
	GOOSE_FEATHERS
}

public class VinArrows{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Vin Fletcher's Arrows. How can I help you today?");
		System.out.println("Select a arrow head of your liking.");
		System.out.println("1. 10 gold: " + ArrowHead.STEEL.name().toLowerCase() + " arrow head.");
		System.out.println("2. 3 gold: " + ArrowHead.WOOD.name().toLowerCase() + " arrow head.");
		System.out.println("3. 5 gold: " + ArrowHead.OBSIDIAN.name().toLowerCase() + " arrow head.");
		int arrowHead = askForNumberInRange("", 1, 3);
		
		int shaftLength = askForNumberInRange("How long do you want the shaft to be? You can choose between 60 and 100 cm.", 60, 100);
		
		System.out.println("And what fletching would you like on this arrow?");
		System.out.println("1. 10 gold: " + Fletching.PLASTIC.name().toLowerCase());
		System.out.println("2. 5 gold: " + Fletching.TURKEY_FEATHERS.name().toLowerCase().replace("_", " "));
		System.out.println("3. 3 gold: " + Fletching.GOOSE_FEATHERS.name().toLowerCase().replace("_", " "));
		int fletching = askForNumberInRange("", 1, 3);
		
		Arrow arrow = createNewArrow(arrowHead, shaftLength, fletching);
		double price = calculatePrice(arrow);
		
		System.out.println("Your order:");
		System.out.println("Arrow head: " + arrow.arrowHead.name().toLowerCase());
		System.out.println("Shaft length: " + arrow.shaftLength + "cm");
		System.out.println("Fletching: " + arrow.fletching.name().toLowerCase().replace("_", " "));
		System.out.println("Your total price will be: " + price + " gold.");
	}
	
	public static Arrow createNewArrow(int arrowHeadSelection, int shaftSizeSelection, int fletchingSelection){
		ArrowHead arrowHead = ArrowHead.values()[arrowHeadSelection - 1];
		Fletching fletching = Fletching.values()[fletchingSelection - 1];
		
		Arrow arrow = new Arrow(arrowHead, shaftSizeSelection, fletching);
		
		return arrow;
	}
	
	public static double calculatePrice(Arrow arrow){
		double price = 0;
		
		// get price for ArrowHead
		if(arrow.arrowHead == ArrowHead.STEEL){
			price = price + 10;
		}
		else if(arrow.arrowHead == ArrowHead.WOOD){
			price = price + 3;
		} else {
			price = price + 5;
		}
		
		// get price for Fletching
		if(arrow.fletching == Fletching.PLASTIC){
			price = price + 10;
		}
		else if(arrow.fletching == Fletching.TURKEY_FEATHERS){
			price = price + 5;
		} else {
			price = price + 3;
		}
		
		// get price for shaftLength
		price = price + (arrow.shaftLength * 0.05);
		
		return price;
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

class Arrow{
	ArrowHead arrowHead;
	int shaftLength;
	Fletching fletching;
	
	public Arrow(ArrowHead arrowHeadSelection, int shaftLengthSelection, Fletching fletchingSelection){
		arrowHead = arrowHeadSelection;
		shaftLength = shaftLengthSelection;
		fletching = fletchingSelection;
	}
}