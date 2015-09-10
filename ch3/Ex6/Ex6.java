class CompareStrings	{
	void cmpr(String a, String b)	{
		if(a == b)
			System.out.println("The strings are equal.");
		else
			System.out.println("The strings are not equal.");
		if(a.equals(b))
			System.out.println("The strings are equal");
		else
			System.out.println("The strings are not equal");
	}
}

public class Ex6	{
	public static void main(String[] args)	{
	CompareStrings cs = new CompareStrings();
	cs.cmpr("abcd", "abcd");
	}
}