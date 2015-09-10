import java.util.*;

class Rodent {
	void eat() {
		System.out.println("Rodent eats");
	}
	void play() {
		System.out.println("Rodent plays");
	}
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

public class Ex6 {
	public static void main(String[] args) {
		List rodentList = new ArrayList();
		rodentList.add(new Hamster());
		rodentList.add(new Gerbil());
		rodentList.add(new Mouse());
		Iterator it = rodentList.iterator();
		while(it.hasNext()) {
			Rodent r = (Rodent)it.next();
			r.eat();
			r.play();
		}
	}
}