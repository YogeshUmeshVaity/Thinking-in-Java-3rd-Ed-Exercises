class Component1 {
	Component1(int com1) {System.out.println("Component1 Constructor com1 = " + com1);}
}

class Component2 {
	Component2(int com2) {System.out.println("Component1 Constructor com2 = " + com2);}
}

class Component3 {
	Component3(int com3) {System.out.println("Component1 Constructor com3 = " + com3);}
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
}

public class Ex11 {
	public static void main(String[] args) {
		Stem s = new Stem(30);
	}
}