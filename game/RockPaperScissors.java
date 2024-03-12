package game;

import java.util.Scanner;

enum GameAction{
	ROCK,
	PAPER,
	SCISSORS
}

public class RockPaperScissors{
	
	private static Player player1;
	private static Player player2;
	
	public static void main(String[] args){
		initiateGame();
		System.out.println("Player 1: " + player1.getPlayerName());
		System.out.println("Player 2: " + player2.getPlayerName());
		playRound();
	}
	
	private static void initiateGame(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Player 1, fill in your name!");
		String name1 = sc.nextLine();
		player1 = new Player(name1, false);
		
		System.out.println("Do you want to play against a human or an AI?");
		System.out.println("1. Human");
		System.out.println("2. AI");
			
		int selection = askForNumber();
		
		do {
			if (selection == 1){
				System.out.println("Player 2, fill in your name!");
				String name2 = sc.nextLine();
				player2 = new Player(name2, false);
				return;
			}
			else if (selection == 2){
				player2 = new Player("AI player", true);
				return;
			} else {
				System.out.println("Your selection is not valid!");
			}
		} while(true);
	}
	
	private static void playRound(){
		
		GameAction player1Action = setAction(player1);
		GameAction player2Action = setAction(player2);
		
		System.out.println("===================================================");
		System.out.println(player1.getPlayerName() + " plays " + player1Action.name().toLowerCase());
		System.out.println(player2.getPlayerName() + " plays " + player2Action.name().toLowerCase());
		System.out.println("===================================================");
		
		int winner = compareInputs(player1Action, player2Action);
		if (winner == 0){
			System.out.println("It's a tie!");
		}
		else if (winner == 1){
			System.out.println(player1.getPlayerName() + " wins!");
		} else {
			System.out.println(player2.getPlayerName() + " wins!");
		}
		
		System.out.println("===================================================");
	}
	
	public static int compareInputs(GameAction player1Action, GameAction player2Action){
		if (player1Action == player2Action){
			return 0;
		}		
		if (player1Action == GameAction.ROCK){
			if(player2Action == GameAction.PAPER){
				return 2;
			}
		}
		if (player1Action == GameAction.PAPER){
			if(player2Action == GameAction.SCISSORS){
				return 2;
			}
		}
		if(player1Action == GameAction.SCISSORS){
			if(player2Action == GameAction.ROCK){
				return 2;
			}
		}
		return 1;
	}
	
	private static GameAction setAction(Player currentPlayer){
		
		int selection;
		
		do{
			if(currentPlayer.getIsAI() == true){
				selection = AIActions.generateAction();
			} else {	
				System.out.println("===================================================");
				System.out.println(currentPlayer.getPlayerName() + ": What action do you want to take?");
				System.out.println("1. " + GameAction.ROCK.name().toLowerCase());
				System.out.println("2. " + GameAction.PAPER.name().toLowerCase());
				System.out.println("3. " + GameAction.SCISSORS.name().toLowerCase());
				System.out.println("===================================================");
				selection = askForNumber();
			}
			
			GameAction gameAction = switch(selection){
				case 1 -> GameAction.ROCK;
				case 2 -> GameAction.PAPER;
				case 3 -> GameAction.SCISSORS;
				default -> null;
			};
			
			if(gameAction == null){ continue; }
			
			return gameAction;
			
		} while(true);
	}
	
	private static int askForNumber(){
		Scanner sc = new Scanner(System.in);
		do
		{
			if(sc.hasNextInt()){
				int number = sc.nextInt();
				return number;
			} else {
				sc.nextLine();
				System.out.println("Your input is not a valid number!");
			}
		}
		while(true);		
	}
	
}

class Player{
	private final String playerName;
	private final boolean isAI;
	
	public Player(String playerName, boolean isAI){
		this.playerName = playerName;
		this.isAI = isAI;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public boolean getIsAI(){
		return isAI;
	}
}