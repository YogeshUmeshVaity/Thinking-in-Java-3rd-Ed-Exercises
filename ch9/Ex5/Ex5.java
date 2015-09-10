class NewTypeException extends Exception {}
class SecondTypeException extends Exception {}

public class Ex5 {
	void f() throws SecondTypeException {
		try {
			g();
		} catch(NewTypeException nt) {
			throw new SecondTypeException();
		}
	}
	void g() throws NewTypeException {
		throw new NewTypeException();
	}
	public static void main(String[] args) throws SecondTypeException {
		Ex5 ex5 = new Ex5();
		ex5.f();
	}
}