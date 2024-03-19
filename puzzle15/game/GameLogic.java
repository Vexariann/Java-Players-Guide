package puzzle15.game;

import java.util.*;

// 15 puzzle program flow:

// randomly scramble numbers from 1 to 15 in a 4x4 board.

// the scramble can be done with an arraylist, this is probably the easiest way, so I have to look
// into arraylist and how to scramble that. iirc you cannot scramble in a regular array

// empty tile will ALWAYS be on the top left.
// This can be done with 2d array/arraylist
// in the console the player will have to choose a direction where they want to rearrange the numbers.

// The program will then check which number is in that slot and put it in the previous slot.
// The empty space will move and that will be the new starting point

// after every move, check if the game array is equal to the answer array

// also add 1 to the move counter to track the amount of moves a player has made

// bonus: highscore

// 	IMPORTANT!!!
// zie het als een rubix cube: begin de game in complete state en randomize de zetten in het begin

public class GameLogic{
		
	ArrayList<ArrayList<Integer>> board = new ArrayList<>();
		
	public void generateGame(){		
		
		// generate rows
		for (int i = 0; i < 4; i++){
			board.add(new ArrayList<Integer>());
		}
		
		int index = 0;
		
		// column
		for (int column = 0; column < 4; column++){
			//row
			for (int row = 0; row < 4; row++){
				board.get(column).add(index);
				index++;
			}
		}
		
		System.out.println(board.get(0));
		System.out.println(board.get(1));
		System.out.println(board.get(2));
		System.out.println(board.get(3));
	}
	
	public void commands(String command){
		if (command.equalsIgnoreCase("up") || command.equalsIgnoreCase("down") || command.equalsIgnoreCase("left") || command.equalsIgnoreCase("right")){
			movement(command);
		}
		else if (command.equalsIgnoreCase("quit")){
			System.exit(0);
		}
	}
	
	private void movement(String direction){
		private int xCoordinate = 0;
		private int yCoordinate = 0;
	}
}