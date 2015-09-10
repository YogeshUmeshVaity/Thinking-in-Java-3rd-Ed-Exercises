class A {
	A(int x) {}
	void method() {
		System.out.println("BassA Method");
	}
	
}

class B {
	A anyMethod(int y){
		return new A(y) {
			int x = 3;
			void method(){ System.out.println("innerA Method"); }
		};
	}
}

public class Ex18 {
	public static void main(String[] args) {
		B b = new B();
		A a = b.anyMethod(9);
		a.method();
	}
}