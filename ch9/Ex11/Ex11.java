class BaseClass {
	BaseClass() throws Exception {
		throw new Exception();
	}
}

class DerivedClass extends BaseClass {
	DerivedClass() {
		// error: call to super must be first statement in constructor
		// here try is the first statement so derived-class constructor
		// cannot catch exceptions thrown by its base-class constructor
		try {
			super();
		} catch(Exception e) {
			System.err.println("Exception caught in derived class");
		}
	}
}

public class Ex11 {
	public static void main(String[] args) {
		DerivedClass d = new DerivedClass();
	}
}