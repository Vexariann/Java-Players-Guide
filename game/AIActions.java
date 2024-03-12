package game;

import java.util.Random;

public class AIActions{
	public static int generateAction(){
		Random random = new Random();
		int randomSelection = random.nextInt(3)+1;
		return randomSelection;
	}
}