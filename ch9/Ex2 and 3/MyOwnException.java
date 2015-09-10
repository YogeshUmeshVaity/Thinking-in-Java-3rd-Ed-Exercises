public class MyOwnException extends Exception {
	String s;
	MyOwnException(String s) {
		this.s = s;
	}
	void printString() {
		System.out.println("The string is : " + s);
	}
	public static void main(String[] args) throws MyOwnException{
		TryClass tc = new TryClass();
		try {
			throw new MyOwnException("ANSI C");
		} catch(MyOwnException m) {
			System.err.println("Caught MyOwnException");
			m.printString();
		}
		try {
			tc.throwException();
		} catch(MyOwnException m) {
			System.err.println("Caught MyOwnException");
			m.printString();
		}
		/* Without exception specification the compiler gives
		error: unreported exception MyOwnException;
		must be caught or declared to be thrown*/
	}
}

class TryClass {
	void throwException() throws MyOwnException {
		throw new MyOwnException("PASCAL");
	}
}
