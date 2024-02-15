enum Color{
	RED,
	GREEN,
	BLUE,
	YELLOW
}

enum Rank{
	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	DOLLAR,
	PERCENT,
	UPARROW,
	AMPERSAND
}

public class TheCard{
	public static void main(String[] args){
		
		int i = 1;
		
		for (Color color : Color.values()){
			for (Rank rank : Rank.values()){
				Card card = new Card(color, rank);
				
				System.out.println( i + ". The " + card.getColor().name().toLowerCase() + " " + card.getRank().name().toLowerCase());
				i++;
				
				if(CheckIfCardIsSymbol(card)){
					System.out.println("Symbol card");
				} else {
					System.out.println("Number card.");
				}
			}
		}
	}
	
	private static boolean CheckIfCardIsSymbol(Card card){
		if (Rank.valueOf(card.getRank().name()).ordinal() >= 10){
			return true;
		}
		return false;
	}
}

class Card{
	private Color color;
	private Rank rank;
	
	public Card(Color color, Rank rank){
		this.color = color;
		this.rank = rank;
	}
	
	public Color getColor(){
		return color;
	}
	
	public Rank getRank(){
		return rank;
	}
}