public class ThePoint{
	public static void main(String[] args){
		Point point1 = new Point(2, 3);
		System.out.println("Point x: " + point1.getX() + " Point y: " + point1.getY());
		
		Point point2 = new Point(-4, 0);
		System.out.println("Point x: " + point2.getX() + " Point y: " + point2.getY());
	}
}

class Point{
	private final int xLocation;
	private final int yLocation;
	
	public Point(){
		this(0, 0);
	}
	
	public Point(int x, int y){
		xLocation = x;
		yLocation = y;
	}
	
	public int getX(){
		return xLocation;
	}
	
	public int getY(){
		return yLocation;
	}
}