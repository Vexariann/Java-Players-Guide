import java.util.Scanner;

public class SimulaTest{
	
	public static enum ChestState{
		OPEN("open"),
		CLOSED("closed"),
		LOCKED("locked");
		
		public final String chestStateLabel;
		
		private ChestState (String chestStateLabel)
		{
			this.chestStateLabel = chestStateLabel;
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ChestState chestState = ChestState.OPEN;
		
		while(true){
			// I have a feeling that this string might be redundant, but not sure.
			String chestStateName = chestState.chestStateLabel;
			System.out.println("The chest is " + chestStateName + ". What do you want to do?");
			String command = input.nextLine();
			
			if(chestStateName.equals("open") && command.equals("close")){
				chestState = ChestState.CLOSED;
			}
			else if(chestStateName.equals("closed") && command.equals("open")){
				chestState = ChestState.OPEN;
			}
			else if(chestStateName.equals("closed") && command.equals("lock")){
				chestState = ChestState.LOCKED;
			}
			else if(chestStateName.equals("locked") && command.equals("unlock")){
				chestState = ChestState.CLOSED;
			}
			else if(command.equals("exit")){
				System.exit(0);
			}
			else {
				System.out.println("You cannot do that!");
			}
		}
	}
}