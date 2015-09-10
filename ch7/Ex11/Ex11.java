class A {
	void method1() {
		System.out.println("method1() of A called");
		method2();
	}
	void method2() {
		System.out.println("method2() of A called");
	}
}

class B extends A {
	void method2() {
		System.out.println("method2() of B called");
	}
}

public class Ex11 {
	public static void main(String[] args) {
		A a = new B(); // Upcasted
		a.method1();
	}
}

// Explanation
/** When the object is upcasted, 
the methods of the lower class(derived class or reference object) of the hierarchy
are prefered. That is, JVM looks for method1 in B,
if the the method1 doesn't exist in B, it calls the method1 of A.
and since, the reference is of B, the method2 of B is called.
*/