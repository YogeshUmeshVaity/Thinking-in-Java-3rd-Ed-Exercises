class PrintPrime	{
	static void prime()	{
		for(int n1 = 3; n1 < 100; n1++)	{
			//if((n1 == 1) || (n1 == 0) || (n1 % 2 == 0))
			//	break;
			for(int i = n1 - 1; i > 1; i--)	{
				if(n1 % i == 0)
					break;
			}
			System.out.println(n1);
		}
		
	}
}

public class Ex9a	{
	public static void main(String[] args)	{
		PrintPrime.prime();
	}
}