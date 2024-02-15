public class TheColor{
	final static Color White = new Color(255, 255, 255);
	final static Color Black = new Color(0, 0, 0);
	final static Color Red = new Color(255, 0, 0);
	final static Color Orange = new Color(255, 165, 0);
	final static Color Yellow = new Color(255, 255, 0);
	final static Color Green = new Color(0, 128, 0);
	final static Color blue = new Color(0, 0, 255);
	final static Color purple = new Color(128, 0, 128);
	
	public static void main(String[] args){
		Color color1 = new Color(150,0,255);
		System.out.println("Your own color: " + color1.getRed() + " " + color1.getGreen() + " " + color1.getBlue());
		
		Color color2 = Orange;
		System.out.println("Premade color: " + color2.getRed() + " " + color2.getGreen() + " " + color2.getBlue());
	}
}

class Color{
	private final int red;
	private final int green;
	private final int blue;
	
	public Color(int r, int g, int b){
		red = r;
		green = g;
		blue = b;
	}
	
	public int getRed(){
		return red;
	}
	
	public int getGreen(){
		return green;
	}
	
	public int getBlue(){
		return blue;
	}
}