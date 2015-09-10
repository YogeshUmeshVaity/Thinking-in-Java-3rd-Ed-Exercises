class OverloadedMethods {
	//method with no arguments
	void method() {
		System.out.println("method()");
	}
	void method(int i) {
		System.out.println("method(" + i + ")");
	}
	void method(float f) {
		System.out.println("method(" + f + ")");
	}
}

class InheritedClassWithOverloadedMethods extends OverloadedMethods {
	void method(char c) {
		System.out.println("method('" + c + "')");
	}
}

public class Ex13 {
	public static void main(String[] args) {
	InheritedClassWithOverloadedMethods ic = new InheritedClassWithOverloadedMethods();
	ic.method('f');
	ic.method(3.6912f);
	ic.method(6);
	ic.method();
	}
}