interface Rodent {
	void eat();
	void play();
}

class Mouse implements Rodent {
	public void eat() {
		System.out.println("Mouse eats");
	}
	public void play() {
		System.out.println("Mouse plays");
	}
}

class Gerbil implements Rodent {
	public void eat() {
		System.out.println("Gerbil eats");
	}
	public void play() {
		System.out.println("Gerbil plays");
	}
}

class Hamster implements Rodent {
	public void eat() {
		System.out.println("Hamster eats");
	}
	public void play() {
		System.out.println("Hamster plays");
	}
}

public class Ex8 {
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