class Dog	{
	void bark (int i, char c)	{
		System.out.println("Barking");
	}
	void bark(char c, int i)	{
		System.out.println("Howling");
	}
	void bark(long l)	{
		System.out.println("Kuikuikui");
	}
	void bark(double d)	{
		System.out.println("Doudoudou");
	}
	void bark(float f)	{
		System.out.println("FlouFlouFlou");
	}
	void bark(String s)	{
		System.out.println("Shoushoushou");
	}
}

public class Ex6	{
	public static void main(String[] args)	{
		Dog d1 = new Dog();
		d1.bark((int)3, 'x');
		//d1.bark("Hello");
		d1.bark('z', 6);
		//d1.bark((float)5);
		//d1.bark((double)6);
		//d1.bark((long)7);
	}
}