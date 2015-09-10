// Final methods in base class cannot be overriden in derived class.
class ClassFinal {
	final void finalMethod() {
		System.out.println("finalMethod() of ClassFinal");
	}
}

public class FinalMethods extends ClassFinal {
	// Compiler gives an error : cannot override. overriden method is final.
	/*!
	void finalMethod() {
		System.out.println("finalMethod of ClassFinal");
	}
	*/
	public static void main(String[] args) {
		FinalMethods fn = new FinalMethods();
		fn.finalMethod();
	}
}