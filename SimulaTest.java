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
		ChestState chestState = ChestState.LOCKED;
		
		while(true){
			System.out.println("The chest is " + chestState.chestStateLabel + ". What do you want to do?");
			String command = input.nextLine();
			
			if(chestState.chestStateLabel.equals("open") && command.equals("close")){
				chestState = ChestState.CLOSED;
			}
			else if(chestState.chestStateLabel.equals("closed") && command.equals("open")){
				chestState = ChestState.OPEN;
			}
			else if(chestState.chestStateLabel.equals("closed") && command.equals("lock")){
				chestState = ChestState.LOCKED;
			}
			else if(chestState.chestStateLabel.equals("locked") && command.equals("unlock")){
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