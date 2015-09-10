class Component1 {
	Component1(int com1) {System.out.println("Component1 Constructor com1 = " + com1);}
	void dispose() { System.out.println("Component1 disposed");}
}

class Component2 {
	Component2(int com2) {System.out.println("Component1 Constructor com2 = " + com2);}
	void dispose() { System.out.println("Component2 disposed");}
}

class Component3 {
	Component3(int com3) {System.out.println("Component1 Constructor com3 = " + com3);}
	void dispose() { System.out.println("Component3 disposed");}
}

class Root {
	Component1 c1;
	Component2 c2;
	Component3 c3;
	Root(int r) {
		System.out.println("Root Constructor");
		c1 = new Component1(r);
		c2 = new Component2(r);
		c3 = new Component3(r);
	}
	void dispose() {
		c3.dispose();
		c2.dispose();
		c1.dispose();
		System.out.println("Root Disposed");
	}
}

class Stem extends Root {
	Component1 s1;
	Component2 s2;
	Component3 s3;
	Stem(int ss) {
		super(ss);
		System.out.println("Stem Constructor");
		s1 = new Component1(ss);
		s2 = new Component2(ss);
		s3 = new Component3(ss);
	}
	void dispose() {
		s3.dispose();
		s2.dispose();
		s1.dispose();
		System.out.println("Stem Disposed");
		super.dispose();
	}
}

public class Ex12 {
	public static void main(String[] args) {
		Stem s = new Stem(30);
		try {
			// Code and exception handling...
		} finally {
			s.dispose();
		}
	}
}