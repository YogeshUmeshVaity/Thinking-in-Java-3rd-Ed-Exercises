// static clause is executed only once i.e. when the class loads.
class A {
	static {
		System.out.println("Class A loaded.");
	}
	static int x = 3;
}

class B extends A {
	static {
		System.out.println("Class B loaded.");
	}
	static int x = 6;
}

class C extends B {
	static {
		System.out.println("Class C loaded.");
	}
	static int x = 9;
}

public class ClassLoading  {
	public static void main(String[] args) {
		// Create multiple instances of Class C.
		// The Class loaded message for each class will be shown only once.
		// That proves that the classes are loaded only once.
		A a = new A(); // at this point it only loads class A
		System.out.println("A.x = " + A.x); // called the static x without creating object.
		B b = new B();
		System.out.println("B.x = " + B.x);
		C c1 = new C(); // Loading the C, also loads B and A
		C c2 = new C();
		C c3 = new C();
		C c4 = new C();
		C c5 = new C();
		C c6 = new C();
		System.out.println("C.x = " + C.x);
		//* All the above lines call the Classes A, B and C only once.
	}
}