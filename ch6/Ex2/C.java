class A {
	int ai;
	A(int ai) {
		this.ai = ai;
		System.out.println("Class A constructor: ai = " + ai);
	}
}

class B {
	int bi;
	B(int bi) {
		System.out.println("Class B constructor: bi = " + bi);
	}
}

public class C extends A {
	C() {
		super(3);
		B b = new B(6);
	}
	public static void main(String[] args) {
		C c = new C();
	}
}

// Ex 1 : When you create object of the derived class,
// the constructor of the base class is called first. 