public class MagicCannon
{
	public static void main(String[] args)
	{
		int fireCharge = 0;
		int electricCharge = 0;
		
		for (int i = 1; i <= 100; i++)
		{
				fireCharge++;
				electricCharge++;
				
				if(fireCharge == 3 && electricCharge == 5)
				{
					System.out.println(i + ": Potent");
					fireCharge = 0;
					electricCharge = 0;
				}
				else if (fireCharge == 3 || electricCharge == 5)
				{
					if(fireCharge == 3)
					{
						System.out.println(i + ": Fire");
						fireCharge = 0;
					}
					if(electricCharge == 5)
					{
						System.out.println(i + ": Electric");
						electricCharge = 0;
					}
				}
				else
				{
					System.out.println(i + ": Normal");
				}
		}
	}
}