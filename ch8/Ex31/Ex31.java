// An inner class has access
// to the private elements of its outer class
// and an outer class has access to the private elements of
// inner class.
class OuterClass {
	private int outerVariable = 3;
	private void showOuterVar() {
		System.out.println("outerVariable = " + outerVariable);
	}
	class InnerClass {
		private int innerVariable = 6;
		private void showInnerVar() {
			System.out.println("innerVariable = " + innerVariable);
		}
		// Accessing and changing private elements of outer class
		void accessOuterElements() {
			outerVariable = 12;
			showOuterVar();
		}
	}
	// Outer class can even access private members of it's inner class
	// using the instance of the inner class(ic in this case)
	InnerClass ic = new InnerClass();
	void accessInnerElements() {
		ic.innerVariable = 24;
		ic.showInnerVar();
	}
}

class Ex31 {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.accessInnerElements();
		OuterClass.InnerClass i = o.new InnerClass();
		i.accessOuterElements();
		
	}
}