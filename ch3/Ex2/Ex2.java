class TernaryTest	{
	static int ternary(int i)	{
		return i < 10 ? i * 100 : i * 10;
	}
	static int alternative(int i)	{
		if(i < 10)
			return i * 100;
		else
			return i * 10;
	}
}

public class Ex2	{
	public static void main(String[] args)	{
		System.out.println("ternary 3 : " + TernaryTest.ternary(3));
		System.out.println("alternative 12 : " + TernaryTest.alternative(12));
	}
}