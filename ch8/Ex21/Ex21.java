class AClass {
	int a = 6;
	void methodA(){}
	class NestedClass {
		int x = 3;
		void methodNestedClass(){}
	}
}

public class Ex21 {
	public static void main(String[] args) {
		// Can't create instance just with the name of inner class
		//!NestedClass nc = new NestedClass();
		// Must create the enclosing class' instace first.
		AClass a = new AClass();
		// and then must specify the outer class name and . and inner class' name
		AClass.NestedClass nc = a.new NestedClass();
	}
}
