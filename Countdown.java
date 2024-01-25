public class Countdown
{
	public static void main(String[] args)
	{
		int number = 10;
		looping(number);
		System.out.println("Looping has finished");
	}
	
	public static void looping(int number)
	{
		if (number > 0)
		{
			System.out.println(number);
			number--;
			looping(number);
		}
		else
		{
			return;
		}
	}
}