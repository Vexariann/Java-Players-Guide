package hangman.game;

import java.util.*;

public class TextUI{
	
	Scanner scanner = new Scanner(System.in);
	GameLogic gameLogic = new GameLogic();
	String finalWord;
	ArrayList<String> guesses;
	
	public static void main(String[] args){
		finalWord = gameLogic.generateWord();
	}
	
	public static void turn(){
		while(true){
			String guess = scanner.nextLine();
			if (guess.length() > 1){ System.out.println("only single letters are accepted!"); continue; }
			if (guesses.contains(guess)){ System.out.println("You already guessed this letter!"); continue; }
			
			guesses.add(guess);
			gameLogic.guess(guess);
		}
	}
}