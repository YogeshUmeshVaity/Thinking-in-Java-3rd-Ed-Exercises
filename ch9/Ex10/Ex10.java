class LevelOneException extends Exception {}
class LevelTwoException extends LevelOneException {}
class LevelThreeException extends LevelTwoException {}

class A {
	void throwException() throws LevelOneException {
		throw new LevelOneException();
	}
}

class B extends A {
	void throwException() throws LevelTwoException {
		throw new LevelTwoException();
	}
}

class C extends B {
	void throwException() throws LevelThreeException {
		throw new LevelThreeException();
	}
}

public class Ex10 {
	// Since LevelOneException is at the base, it's ok to
	// specify it for the LevelThreeException throw here.
	// you cannot specify LevelTwoException because
	// When you override a method, you can throw only the
	// exceptions that have been specified in the base-class
	// version of the method(or the exceptions that are derived
	// from the base class' exceptions or in other words,
	// overridden methods can throw inherited exceptions).
	public static void main(String[] args) throws LevelOneException {
		A a = new C();
		// throws exception(LevelThreeException)
		// derived from the base class' exception
		try {
			a.throwException();
		} catch(LevelThreeException l3) {
			System.err.println("Caught Exception is : " + l3);
		}
		a.throwException();
	}
}