interface A {
	void a1();
	void a2();
}

interface B {
	void b1();
	void b2();
}

interface C {
	void c1();
	void c2();
}

interface ABC extends A, B, C {
	void abc();
}

class D { //Concrete class
	
}

class EClass extends D implements ABC {
	void ea(A a) {
		System.out.println("Reference to interface A accepted.");
	}
	void eb(B b) {
		System.out.println("Reference to interface B accepted.");
	}
	void ec(A a) {
		System.out.println("Reference to interface C accepted.");
	}
	void eabc(ABC abc) {
		System.out.println("Reference to interface ABC accepted.");
	}
	public void a1() {
		System.out.println("a1() of EClass");
	}
	public void a2() {
		System.out.println("a2() of EClass");
	}
	public void b1() {
		System.out.println("b1() of EClass");
	}
	public void b2() {
		System.out.println("b2() of EClass");
	}
	public void c1() {
		System.out.println("c1() of EClass");
	}
	public void c2() {
		System.out.println("c2() of EClass");
	}
	public void abc() {
		System.out.println("abc() of EClass");
	}
	
}

public class Ex5 {
	public static void main(String[] args) {
		EClass eObject = new EClass();
		eObject.ea(eObject);
		eObject.eb(eObject);
		eObject.ec(eObject);
		eObject.eabc(eObject);
		eObject.ea(new EClass());
		eObject.eb(new EClass());
		eObject.ec(new EClass());
		eObject.eabc(new EClass());
	}
}