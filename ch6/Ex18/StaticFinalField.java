class TestClass {
	int i = 9;
	void printTC(TestClass tc) {
		System.out.println(tc);
	}
}

public class StaticFinalField {
	// A field that is both static and final has only one piece of storage that cannot be changed.
	// It is easier to prove this by using objects as fields.
	static final TestClass tc1 = new TestClass(); 
	final TestClass tc2 = new TestClass();
	public static void main(String[] args) {
		StaticFinalField sff1 = new StaticFinalField();
		StaticFinalField sff2 = new StaticFinalField();
		StaticFinalField sff3 = new StaticFinalField();
		System.out.println("static final : " + sff1.tc1);
		System.out.println("final : " + sff1.tc2);
		System.out.println("static final : " + sff2.tc1);
		System.out.println("final : " + sff2.tc2);
		System.out.println("static final : " + sff3.tc1);
		System.out.println("final : " + sff3.tc2);
		
		// tc2 of sff1, sff2, sff3 have different memory locations. 
	}
}