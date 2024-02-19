import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

enum DoorState{
	OPEN,
	CLOSED,
	LOCKED
}

public class TheDoor{
	public static void main(String[] args){
		int randomPassCode = ThreadLocalRandom.current().nextInt(1000, 9999);
		System.out.println("DEBUG: Your randomly generated passcode: " + randomPassCode);
		
		Scanner sc = new Scanner(System.in);
		Door door = new Door(DoorState.LOCKED, randomPassCode);
		
		while(true){			
			System.out.println("\nThe door is currently " + door.getDoorState().name().toLowerCase() + ". What would you like to do?");
			String input = sc.nextLine();
			if(input.toLowerCase().equals("exit")){
				break;
			} 
			else if(input.toLowerCase().equals("iwanttochangemypasscode")){
				if(askForPassCode(door) == true){
					int newPassCode = checkForInt("\nSet your new 4 digit passcode: ", 1000, 9999);
					door.setPassCode(newPassCode);
					System.out.println("Your new passCode is: " + door.getPassCode());
				}
			} else {
				checkInput(input, door);
			}
		}
		
	}
	
	public static void checkInput(String command, Door door){
		if(door.getDoorState() == DoorState.OPEN && command.toLowerCase().equals("close")){
			door.setDoorState(DoorState.CLOSED);
			return;
		} 
		else if(door.getDoorState() == DoorState.CLOSED && command.toLowerCase().equals("open")){
			door.setDoorState(DoorState.OPEN);
			return;
		}
		else if(door.getDoorState() == DoorState.CLOSED && command.toLowerCase().equals("lock")){
			door.setDoorState(DoorState.LOCKED);
			return;
		}
		else if(door.getDoorState() == DoorState.LOCKED && command.toLowerCase().equals("unlock")){
			if(askForPassCode(door) == true){
				door.setDoorState(DoorState.CLOSED);
				return;
			}
		} else {
			System.out.println("Your command was not valid. Please try again.");
			return;
		}
	}
	
	public static boolean askForPassCode(Door door){
		
		Scanner sc = new Scanner(System.in);
			
		int codeInput = checkForInt("It appears the door has a secret passcode, please fill in a 4 numeric number", 1000, 9999);
		
		if(codeInput == door.getPassCode()){
			System.out.println("Correct passcode!");
			return true;
		} else {
			System.out.println("That is not the correct passcode!");
			return false;
		}
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
					System.out.println("ERROR: your input is out of range. Please try again.");
				}
			} else {
				sc.nextLine();
				System.out.println("ERROR: input is not a number, please try again!");
			}
		}
	}
}

class Door{
	private DoorState doorState;
	private int passCode;
	
	public Door(DoorState doorState, int passCode){
		this.doorState = doorState;
		this.passCode = passCode;
	}
	
	public void setDoorState(DoorState doorState){
		this.doorState = doorState;
	}
	
	public void setPassCode(int passCode){
		this.passCode = passCode;
	}
	
	public DoorState getDoorState(){
		return doorState;
	}
	
	public int getPassCode(){
		return passCode;
	}
}