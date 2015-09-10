abstract class BaseClass {
	BaseClass() { print(); }
	abstract void print();
}

class DerivedClass extends BaseClass {
	int x = 5;
	void print() {
		System.out.println("int x = " + x);
	}
}

public class Ex12 {
	public static void main(String[] args) {
		DerivedClass dc = new DerivedClass();
		dc.print();
	}
}

// When a reference to the derived class in created(new DerivedClass here),
// Before base class constructors are called, the storage allocated
// for the object is initialized to binary zero.
// that's why x shows value 0 initially.