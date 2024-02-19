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
					int newPassCode = checkForInt("\nSet your new 4 digit passcode: ", 0000, 9999);
					door.setPassCode(newPassCode);
					
					//convert the new passcode int to string and checks it's length so it can properly display the passcode as a 4 digit number in the console. For example 0001
					String newPassCodeString = Integer.toString(newPassCode);
					int newPassCodeLength = newPassCodeString.length();
					switch(newPassCodeLength){
						case 1:
							newPassCodeString = "000" + newPassCodeString;
							break;
						case 2:
							newPassCodeString = "00" + newPassCodeString;
							break;
						case 3:
							newPassCodeString = "0" + newPassCodeString;
					}		
					System.out.println("Your new passCode is: " + newPassCodeString);
				}
			} else {
				checkInput(input, door);
			}
		}
		
	}
	
	public static void checkInput(String command, Door door){
		if(door.getDoorState() == DoorState.OPEN && command.toLowerCase().equals("close")){
			door.setDoorState(DoorState.CLOSED);
		} 
		else if(door.getDoorState() == DoorState.CLOSED && command.toLowerCase().equals("open")){
			door.setDoorState(DoorState.OPEN);
		}
		else if(door.getDoorState() == DoorState.CLOSED && command.toLowerCase().equals("lock")){
			door.setDoorState(DoorState.LOCKED);
		}
		else if(door.getDoorState() == DoorState.LOCKED && command.toLowerCase().equals("unlock")){
			if(askForPassCode(door) == true){
				door.setDoorState(DoorState.CLOSED);
			}
		} else {
			System.out.println("Your command was not valid. Please try again.");
		}
	}
	
	public static boolean askForPassCode(Door door){
		
		Scanner sc = new Scanner(System.in);
			
		int codeInputAsNumber = checkForInt("It appears the door has a secret passcode, please fill in a 4 numeric number", 0000, 9999);
		
		return door.checkPassCode(codeInputAsNumber);
	}
	
	public static int checkForInt(String prompt, int min, int max){
		
		Scanner sc = new Scanner(System.in);
		
		while (true){
			System.out.println(prompt);
			if(sc.hasNextLine()){
				
				String numberInput = sc.nextLine();
				
				if(!isValidNumber(numberInput)){
					System.out.println("ERROR: input is not a number, please try again!");
					continue;
				}
				
				if(numberInput.length() != 4){
					System.out.println("ERROR: your input does not meet the required length, please try again.");
					continue;
				}

				int number = Integer.parseInt(numberInput);
				
				if (number >= min && number <= max){
					return number;	
				} 
			}
		}
	}
	
	public static boolean isValidNumber(String input){
		for(char c : input.toCharArray()){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		return true;
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