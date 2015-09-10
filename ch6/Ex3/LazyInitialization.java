class Simple {
	int i = 0;
	Simple(int si) {
		System.out.println("Simple constructor called.");
		i = si;
	}	
	public String toString() {
		return "i = " + i;
	}
}

class Second {
	Simple s;
	public void lazyInitialize() {
		s = new Simple(9);
		System.out.println(s);
	}
}

public class LazyInitialization {
	public static void main(String[] args) {
		Second second = new Second();
		second.lazyInitialize();
	}
}