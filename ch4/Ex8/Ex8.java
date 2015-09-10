class AnyClass	{
	void displayMsg()	{
		System.out.println("Good Programer");
	}
}

public class Ex8	{
	public static void main(String[] args) {
		AnyClass ac = new AnyClass();
		ac.displayMsg();
		//Point is without the default constructor, we would have no method to call to create object.
	}
}