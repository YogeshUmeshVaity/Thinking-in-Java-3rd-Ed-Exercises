/**Java performs default initialization only in class. Not in methods.*/
class DemoAutoInitialize {
	int i;
	char c;
}

public class Ex14 {
	public static void main(String[] args) {
		DemoAutoInitialize dai = new DemoAutoInitialize();
		// Print the automatically initialized values.
		System.out.println("i = " + dai.i);
		System.out.println("c = " + dai.c);
	}
}