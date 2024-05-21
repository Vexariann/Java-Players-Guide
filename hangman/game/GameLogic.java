package hangman.game;

import java.util.*;

/*

hangman game flow:

create a list of words in a string array, from there use the random function to grab a random word
from that list to be the word for that game.
when guessing the letter should be compared to ALL characters in the string.
if correct display the letter properly and no penalty is applied
when none of the letters in the string match the guessed letter the player gets penalized
with 1 strike. They may have 5 incorrect guesses before game over.

The player wins if all letters have been guessed. This can be done by checking if there are no
more empty spaces within the guessing string

keep track of the letters checked to see if the player tries to guess the letter again.
if the letter is already guessed try again.

compare the list of guessed letters to the word

*/

public class GameLogic{
	
	Random rand = new Random();
	
	private String[] words = {"kingdom", "midisti", "bovisti", "tordisti", "jenava", "malino", "magnos", "platos", "Theros", "phaxios", "hellios", "elementos", "empire", "atla", "calici", "entropia", "fenrin", "kantatribo", "ljord", "malzan", "midusa", "mura", "tyksa", "vystara", "zera"};
	private int randomWord;
	private int wrongGuesses = 5;
	private arrayList<String> guesses;
	
	public String generateWord(){
		randomWord = rand.nextInt(words.length);
		System.out.println("DEBUG: random generated word " + words[randomWord]);
		return randomWord;
	}
	
	public boolean guess(String guess){
		if(randomWord.contains(guess)){ return true; }
		wrongGuesses - 1;
		return false;
	}
	
	public int checkWinCondition(){
		
	}
}