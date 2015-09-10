class PrecedenceDemo	{
	double a, x = 2, y = 5, z = 7;
}

public class Ex1a	{
	public static void main(String[] args)	{
		PrecedenceDemo pd = new PrecedenceDemo();
		pd.a = pd.x + pd.y - 2/2 + pd.z;
		System.out.println("a = x + y - 2 / 2 + z = " + pd.a);
		pd.a = pd.x + (pd.y - 2) / (2 + pd.z);
		System.out.println("a = x + ( y - 2 ) / ( 2 + z) = " + pd.a);
	}
	 
}