class StaticStringTest {
	String s = "Good Programer";
	String s2;
	{
		s2 = "Good Programer2";
		// Instance initialization can also be used to call methods.
		// It is also used in the situation when the intializer code must handle exceptions.
		// Also used to perform calculations that can't be expressed with an instance variable initializer.
		System.out.println(s);
		System.out.println(s2);
	}
}

public class Ex17a {
	public static void main(String[] args) {
		StaticStringTest sst = new StaticStringTest();
	}
}