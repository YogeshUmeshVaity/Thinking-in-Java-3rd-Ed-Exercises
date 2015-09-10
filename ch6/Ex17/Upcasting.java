class Amphibian {
	static void acceptsFrogToo(Amphibian a) {
		System.out.println("Accepted Frog from Amphibian");
		a.accept(3);
	}
	void accept(int a) {
		System.out.println(a + " accepted in amphibian");
	}
}

class Frog extends Amphibian {
	/*If a derived class defines a static method with same 
	signature as a static method in base class, the method 
	in the derived class hides the method in the base class. */
	static void acceptsFrogToo(Amphibian a) {
		System.out.println("Accepted Frog from Frog");
		a.accept(3);
	}
	@Override void accept(int a) {
		System.out.println(a + " accepted in frog");
	}
}

public class Upcasting {
	public static void main(String[] args) {
		Amphibian a = new Amphibian();
		Frog f = new Frog();
		//a.accept(3);
		//f.accept(6);
		Amphibian.acceptsFrogToo(f); //Calls the static method(which calls accept method in frog not in Amphibian) in Amphibian
		f.acceptsFrogToo(f); // Call the static method
		Frog.acceptsFrogToo(f);
		a.accept(9);
		
	}
}