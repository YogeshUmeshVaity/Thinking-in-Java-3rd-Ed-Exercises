class Device {
	Device(int size) {
		System.out.println("Device size = " + size + " inches.");
	}
}

class Cellphone extends Device {
	Cellphone() {
		super(5);
		System.out.println("Cellphone with default size = 5 inches.");
	}
	Cellphone(int size) {
		super(size);
		System.out.println("Cellphone size = " + size + " inches.");
	}
}

public class DefaultNoDefault {
	public static void main(String[] args) {
		Cellphone c1 = new Cellphone();
		Cellphone c2 = new Cellphone(6);
	}
}