package puzzle15.game;

public class Main{
	public static void main(String[] args){
		generateNewGame();
	}
	
	public static void generateNewGame(){
		GameLogic gameLogic = new GameLogic();
		gameLogic.generateGame();
	}
}