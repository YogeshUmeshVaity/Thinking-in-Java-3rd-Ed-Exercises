class PrintPrime	{
	static void prime(int n1){
		if((n1 == 1) || (n1 == 0) || (n1 % 2 == 0))
			return;
		for(int i = n1 - 1; i > 1; i--)	{
			if(n1 % i == 0){
				return;
			}
		}
		System.out.println(n1);
	}
}

public class Ex9	{
	public static void main(String[] args)	{
		for(int inpt = 0; inpt < 1000; inpt++)	{
		PrintPrime.prime(inpt);
		}
	}
}