class Component1 {
	Component1() {System.out.println("Component1 Constructor");}
}

class Component2 {
	Component2() {System.out.println("Component2 Constructor");}
}

class Component3 {
	Component3() {System.out.println("Component3 Constructor");}
}

class Root {
	Component1 c1;
	Component2 c2;
	Component3 c3;
	Root() {
		System.out.println("Root Constructor");
		c1 = new Component1();
		c2 = new Component2();
		c3 = new Component3();
	}
}

class Stem extends Root {
	Component1 s1;
	Component2 s2;
	Component3 s3;
	Stem() {
		System.out.println("Stem Constructor");
		s1 = new Component1();
		s2 = new Component2();
		s3 = new Component3();
	}
}

public class Ex10 {
	public static void main(String[] args) {
		Stem s = new Stem();
	}
}