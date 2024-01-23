import java.util.Scanner;

public class TheReplicator
{
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Put in 5 numbers and this magical array will copy your inputs.");
		
		int[] intArray = new int[5];
		int[] magicalArray = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println("\n put in number " + (i + 1));
			String numberInput = input.next();
			try
			{
				int numberInt = Integer.parseInt(numberInput);
				intArray[i] = numberInt;
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nERROR: one of your inputs was not a valid number. Program will abort.");
			}
		}
			System.out.println("Contents of your array: " + intArray[0] + ", " + intArray[1] + ", " + intArray[2] + ", " + intArray[3] + ", " + intArray[4]);
			System.out.println("Now we'll clone the contents of this array in a for loop to the magical array\n");
			
		for (int i = 0; i < intArray.length; i++)
		{
			magicalArray[i] = intArray[i];
			System.out.println(magicalArray[i]);
		}
		
		System.out.println("Contents of the magical array is: " + magicalArray[0] + ", " + magicalArray[1] + ", " + magicalArray[2] + ", " + magicalArray[3] + ", " + magicalArray[4]);
	}
}