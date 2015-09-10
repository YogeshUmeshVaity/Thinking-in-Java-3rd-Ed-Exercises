abstract class Rodent {
	abstract void eat();
	abstract void play();
}

class Mouse extends Rodent {
	void eat() {
		System.out.println("Mouse eats");
	}
	void play() {
		System.out.println("Mouse plays");
	}
}

class Gerbil extends Rodent {
	void eat() {
		System.out.println("Gerbil eats");
	}
	void play() {
		System.out.println("Gerbil plays");
	}
}

class Hamster extends Rodent {
	void eat() {
		System.out.println("Hamster eats");
	}
	void play() {
		System.out.println("Hamster plays");
	}
}

public class Ex7 {
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