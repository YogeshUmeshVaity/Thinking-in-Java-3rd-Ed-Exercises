class Amphibian {
	void acceptsFrogToo(Amphibian a) {
		System.out.println("Accepted Frog.");
	}
}

class Frog extends Amphibian {
	
}

public class Upcasting {
	public static void main(String[] args) {
		Amphibian a = new Amphibian();
		a.acceptsFrogToo(new Frog());
	}
}