class NumberPrinting	{
	static void Nu()	{
		for(int i = 1; i <= 100; i++)	{
			System.out.println(i);
			if(i == 47)
				return;
		}
	}
}

public class Ex4	{
	public static void main(String[] args)	{
		NumberPrinting.Nu();
	}
}