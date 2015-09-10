abstract class AbstractTest {
	private int c = 5;
}

public class Ex8 {
	public static void main(String[] args) {
		// error: AbstractTest is abstract; cannot be instantiated
		AbstractTest at = new AbstractTest();
	}
}