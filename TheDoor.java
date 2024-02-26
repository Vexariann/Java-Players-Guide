import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

enum DoorState{
	OPEN,
	CLOSED,
	LOCKED
}

public class TheDoor{
	public static void main(String[] args){
		int randomPassCode = ThreadLocalRandom.current().nextInt(0000, 9999);
		System.out.println("DEBUG: Your randomly generated passcode: " + randomPassCode);
		
		DoorState doorState = DoorState.LOCKED;
		
		Scanner sc = new Scanner(System.in);
		Door door = new Door(randomPassCode);
		
		while(true){			
			System.out.println("\nThe door is currently " + doorState.name().toLowerCase() + ". What would you like to do?");
			String input = sc.nextLine();
			if(input.toLowerCase().equals("exit")){
				break;
			} 
			else if(input.toLowerCase().equals("iwanttochangemypasscode")){
				if(askForPassCode(door) == true){
					int newPassCode = checkForInt("\nSet a new passcode of your choice: ", 0000, 9999);
					door.setPassCode(newPassCode);
				
					System.out.println("Your new passCode is: " + newPassCode);
				}
			} else {
				doorState = changeDoorState(input, doorState, door);
			}
		}
		
	}
	
	public static DoorState changeDoorState(String command, DoorState doorState, Door door){
		if(doorState == DoorState.OPEN && command.toLowerCase().equals("close")){
			return doorState.CLOSED;
		} 
		else if(doorState == DoorState.CLOSED && command.toLowerCase().equals("open")){
			return doorState.OPEN;
		}
		else if(doorState == DoorState.CLOSED && command.toLowerCase().equals("lock")){
			return doorState.LOCKED;
		}
		else if(doorState == DoorState.LOCKED && command.toLowerCase().equals("unlock")){
			if(askForPassCode(door) == true){
				return doorState.CLOSED;
			}
			return doorState;
		} else {
			System.out.println("Your command was not valid. Please try again.");
			return doorState;
		}
	}
	
	public static boolean askForPassCode(Door door){
			
		int codeInputAsNumber = checkForInt("It appears the door has a secret passcode, please fill in a number between 1 and 10000", 0, 9999);
		
		return door.checkPassCode(codeInputAsNumber);
	}
	
	public static int checkForInt(String prompt, int min, int max){
		
		Scanner sc = new Scanner(System.in);
		
		while (true){
			System.out.println(prompt);
			if(sc.hasNextInt()){

				int number = sc.nextInt();
				sc.nextLine();
				
				if (number >= min && number <= max){
					return number;	
				} else {
					System.out.println("ERROR: input is out of range");
				} 
			} else {
				sc.nextLine();
				System.out.println("ERROR: input is not a number, please try again!");
			}
		}
	}
}


class Door{
	private int passCode;
	
	public Door(int passCode){
		this.passCode = passCode;
	}
	
	public void setPassCode(int passCode){
		this.passCode = passCode;
	}
	
	public boolean checkPassCode(int input){
		if(input == passCode){
			System.out.println("Correct passcode!");
			return true;
		} else {
			System.out.println("That is not the correct passcode!");
			return false;
		}
	}
}