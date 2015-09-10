class Head {
	Head(String typeName) { System.out.println("Head Constructed for " + typeName); }
}

class Leg {
	Leg(String typeName) { System.out.println("Leg Constructed for " + typeName); }
}

class Tail {
	Tail(String typeName) { System.out.println("Tail Constructed for " + typeName); }
}

class Rodent {
	Head h = new Head("Rodent");
	Leg l = new Leg("Rodent");
	Tail t = new Tail("Rodent");
	Rodent() {
		System.out.println("Rodent Constructed\n");
	}
	void eat() {
		System.out.println("Rodent eats");
	}
	void play() {
		System.out.println("Rodent plays");
	}
}

class Mouse extends Rodent {
	Head h = new Head("Mouse");
	Leg l = new Leg("Mouse");
	Tail t = new Tail("Mouse");
	Mouse() {
		System.out.println("Mouse Constructed\n");
	}
	void eat() {
		System.out.println("Mouse eats");
	}
	void play() {
		System.out.println("Mouse plays");
	}
}

class Gerbil extends Rodent {
	Head h = new Head("Gerbil");
	Leg l = new Leg("Gerbil");
	Tail t = new Tail("Gerbil");
	Gerbil() {
		System.out.println("Gerbil Constructed\n");
	}
	void eat() {
		System.out.println("Gerbil eats");
	}
	void play() {
		System.out.println("Gerbil plays");
	}
}

class Hamster extends Rodent {
	Head h = new Head("Hamster");
	Leg l = new Leg("Hamster");
	Tail t = new Tail("Hamster");
	Hamster() {
		System.out.println("Hamster Constructed\n");
	}
	void eat() {
		System.out.println("Hamster eats");
	}
	void play() {
		System.out.println("Hamster plays");
	}
}

public class Ex10 {
	public static void main(String[] args) {
		Rodent[] r = { // upcasting happens at this point
		new Hamster(),
		new Gerbil(),
		new Mouse()
		};
		for(int i = 0; i < r.length; i++) {
			r[i].eat();
			r[i].play();
		}
		
	}
}
// Output explains the order of construction.