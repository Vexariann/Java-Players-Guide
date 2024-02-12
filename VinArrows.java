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
		System.out.println("1. I'd like to purchase a prebuilt arrow.");
		System.out.println("2. I'd like to build a custom arrow.");
		int menuSelection = askForNumberInRange("", 1, 2);
		if(menuSelection == 1){
			System.out.println("You can choose one of the following arrows:");
			System.out.println("1. Elite Arrow");
			System.out.println("2. Beginner Arrow");
			System.out.println("3. Marksman Arrow");
			int arrowSelection = askForNumberInRange("", 1, 3);
			
			Arrow arrow;
			String arrowName;
			
			if(arrowSelection == 1){
				arrow = Arrow.createEliteArrow();
				arrowName = "Elite arrow";
			}
			else if(arrowSelection == 2){
				arrow = Arrow.createBeginnerArrow();
				arrowName = "Beginner arrow";
			} else {
				arrow = Arrow.createMarksmanArrow();
				arrowName = "Marksman arrow";
			}
			
			double price = calculatePrice(arrow);
			
			System.out.println("You've bought a " + arrowName + " which is worth " + price + " gold.");
			
		} else {
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
			System.out.println("Arrow head: " + arrow.getArrowHead().name().toLowerCase());
			System.out.println("Shaft length: " + arrow.getShaftLength() + "cm");
			System.out.println("Fletching: " + arrow.getFletching().name().toLowerCase().replace("_", " "));
			System.out.println("Your total price will be: " + price + " gold.");
		}
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
		if(arrow.getArrowHead() == ArrowHead.STEEL){
			price = price + 10;
		}
		else if(arrow.getArrowHead() == ArrowHead.WOOD){
			price = price + 3;
		} else {
			price = price + 5;
		}
		
		// get price for Fletching
		if(arrow.getFletching() == Fletching.PLASTIC){
			price = price + 10;
		}
		else if(arrow.getFletching() == Fletching.TURKEY_FEATHERS){
			price = price + 5;
		} else {
			price = price + 3;
		}
		
		// get price for shaftLength
		price = price + (arrow.getShaftLength() * 0.05);
		
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
	private final ArrowHead arrowHead;
	private final int shaftLength;
	private final Fletching fletching;
	
	public Arrow(ArrowHead arrowHeadSelection, int shaftLengthSelection, Fletching fletchingSelection){
		arrowHead = arrowHeadSelection;
		shaftLength = shaftLengthSelection;
		fletching = fletchingSelection;
	}
	
	public ArrowHead getArrowHead() {
		return arrowHead;
	}
	
	public int getShaftLength() {
		return shaftLength;
	}
	
	public Fletching getFletching() {
		return fletching;
	}
	
	public static Arrow createEliteArrow(){
		Arrow arrow = new Arrow(ArrowHead.STEEL, 95, Fletching.PLASTIC);
		return arrow;
	}
	
	public static Arrow createBeginnerArrow(){
		Arrow arrow = new Arrow(ArrowHead.WOOD, 75, Fletching.GOOSE_FEATHERS);
		return arrow;
	}
	
	public static Arrow createMarksmanArrow(){
		Arrow arrow = new Arrow(ArrowHead.STEEL, 65, Fletching.GOOSE_FEATHERS);
		return arrow;
	}
}