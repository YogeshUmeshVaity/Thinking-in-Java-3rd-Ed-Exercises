class A {
	A() {
		System.out.println("Class A constructor");
	}
}

class B {
	B() {
		System.out.println("Class B constructor");
	}
}

public class C extends A {
	B b = new B();
	public static void main(String[] args) {
		C c = new C();
		
	}
}