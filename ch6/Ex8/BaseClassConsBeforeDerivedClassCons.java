class BaseClass {
	BaseClass() {
		System.out.println("Inside BaseClass Constructor.");
	}
}

class DerivedClass extends BaseClass {
	DerivedClass() {
		System.out.println("Inside DerivedClass Constructor.");
	}
}

class DerivedClass2 extends DerivedClass {
	DerivedClass2() {
		System.out.println("Inside DerivedClass2 Constructor.");
	}
}

public class BaseClassConsBeforeDerivedClassCons {
	public static void main(String[] args) {
		DerivedClass2 dc2 = new DerivedClass2();
	}
}

// The message from BaseClass is displayed first. Then message from DerivedClass and next DerivedClass2.
// That proves that the constructors for the BaseClass are always called.
// and they are called before the constructors for the derived class.