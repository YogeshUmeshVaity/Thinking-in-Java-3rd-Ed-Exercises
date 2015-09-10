class NewTypeException extends Exception {}
class SecondTypeException extends Exception {}

public class Ex6 {
	void f() throws SecondTypeException {
		try {
			g();
		} catch(NewTypeException nt) {
			throw new RuntimeException(nt);
		}
	}
	void g() throws NewTypeException {
		throw new NewTypeException();
	}
	public static void main(String[] args) throws SecondTypeException {
		Ex6 ex6 = new Ex6();
		ex6.f();
	}
}