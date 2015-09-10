class StaticStringTest {
	static String s = "Good Programer";
	static String s2;
	static {
		s2 = "Good Programer2";
	}
	static void printStatic() {
		System.out.println(s);
		System.out.println(s2);
	}
}

public class Ex17 {
	public static void main(String[] args) {
		StaticStringTest.printStatic();
	}
}