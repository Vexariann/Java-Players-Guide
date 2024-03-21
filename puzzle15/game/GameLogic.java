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
	ArrayList<ArrayList<Integer>> finalBoard = new ArrayList<>();
	static final String[] movementOptions = {"up", "down", "left", "right"};
	
	private int currentxCoordinate = 0;
	private int currentyCoordinate = 0;
		
	private int newxCoordinate = 0;
	private int newyCoordinate = 0;
	
	private int moveCount = 1;
	
	Random rand = new Random();
	Scanner scanner = new Scanner(System.in);
	
	//this bool is here to prevent the console from being spammed with error messages while the board is automatically shuffling the numbers.
	boolean isAutoGenerating = false;
		
	public void generateGame(){		
		
		// generate rows
		for (int i = 0; i < 4; i++){
			board.add(new ArrayList<Integer>());
			finalBoard.add(new ArrayList<Integer>());
		}
		
		int index = 0;
		
		// column
		for (int column = 0; column < 4; column++){
			//row
			for (int row = 0; row < 4; row++){
				board.get(column).add(index);
				finalBoard.get(column).add(index);
				index++;
			}
		}
		
		System.out.println("Try to get this board together in the least turns possible!");
		System.out.println(finalBoard.get(0));
		System.out.println(finalBoard.get(1));
		System.out.println(finalBoard.get(2));
		System.out.println(finalBoard.get(3));
		System.out.println("");
		
		isAutoGenerating = true;
		
		for (int i = 0; i < 5000; i++){
			int randomCommand = rand.nextInt(movementOptions.length);
			movement(movementOptions[randomCommand]);
		}
		
		isAutoGenerating = false;
	}
	
	public void turn(){
		while(true){
			
			System.out.println("Turn " + moveCount);
			System.out.println("The empty space is at: " + currentxCoordinate + ", " + currentyCoordinate);
			System.out.println(board.get(0));
			System.out.println(board.get(1));
			System.out.println(board.get(2));
			System.out.println(board.get(3));
			System.out.println("============================================");
			
			String command = scanner.nextLine();
			
			commands(command);
			
			moveCount++;
			
			if (checkWinCondition()){
				System.out.println("Turn " + moveCount);
				System.out.println("The empty space is at: " + currentxCoordinate + ", " + currentyCoordinate);
				System.out.println(board.get(0));
				System.out.println(board.get(1));
				System.out.println(board.get(2));
				System.out.println(board.get(3));
				System.out.println("============================================");
				System.out.println("Congratulations! You've won the game!");
				System.exit(0);
			}
		}
	}
	
	public void commands(String command){
		if (command.equalsIgnoreCase("up") || command.equalsIgnoreCase("down") || command.equalsIgnoreCase("left") || command.equalsIgnoreCase("right")){
			movement(command);
		}
		else if (command.equalsIgnoreCase("quit")){
			System.exit(0);
		} else {
			System.out.println("Invalid command, please try again!");
		}
	}
	
	private void movement(String direction){		
		direction = direction.toLowerCase();
		
		switch(direction) {
			case "up":
				newyCoordinate  = currentyCoordinate - 1;
				break;
			case "down":
				newyCoordinate = currentyCoordinate + 1;
				break;
			case "left":
				newxCoordinate = currentxCoordinate - 1;
				break;
			case "right":
				newxCoordinate = currentxCoordinate + 1;
				break;
		}
		
		try{
			int adjacentTileNumber = board.get(newyCoordinate).get(newxCoordinate);
			board.get(currentyCoordinate).set(currentxCoordinate, adjacentTileNumber);
			board.get(newyCoordinate).set(newxCoordinate, 0);
			currentxCoordinate = newxCoordinate;
			currentyCoordinate = newyCoordinate;
		}
		catch (Exception ex){
			if (!isAutoGenerating){System.out.println("Cannot move outside of the playing field!");}
			newxCoordinate = currentxCoordinate;
			newyCoordinate = currentyCoordinate;
			return;
		}
	}
	
	private boolean checkWinCondition(){
		if(board.get(0).equals(finalBoard.get(0)) && board.get(1).equals(finalBoard.get(1)) && board.get(2).equals(finalBoard.get(2)) && board.get(3).equals(finalBoard.get(3))){return true;}
		return false;
	}
}