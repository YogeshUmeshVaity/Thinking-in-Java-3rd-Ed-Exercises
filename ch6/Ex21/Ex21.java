// final classes cannot be inherited.
final class FinalClass {
	float f = 3.66f;
}

// Compiler gives error: cannot inherit from final FinalClass
public class Ex21 extends FinalClass {
	public static void main(String[] args) {
		System.out.println("Ola!");
	}
}