class TestClass {
	int i = 9;
	void printTC(TestClass tc) {
		System.out.println(tc);
	}
}

public class StaticFinalField {
	// A field that is both static and final has only one piece of storage that cannot be changed.
	static final TestClass tc1 = new TestClass();
	final TestClass tc2 = new TestClass();
	public static void main(String[] args) {
		StaticFinalField sff1 = new StaticFinalField();
		StaticFinalField sff2 = new StaticFinalField();
		StaticFinalField sff3 = new StaticFinalField();
		System.out.println(sff1.tc1);
		System.out.println(sff1.tc2);
		System.out.println(sff2.tc1);
		System.out.println(sff2.tc2);
		System.out.println(sff3.tc1);
		System.out.println(sff3.tc2);
	}
}