class ProtectedData {
	protected float f = 3.14519f;
	ProtectedData() { System.out.println("Initial value of f is " + f);}
}

class ForManipulate extends ProtectedData {
	float manipulate() {
		return f = 3.14f;
	}
}

public class Ex6 {
	public static void main(String[] args) {
		ForManipulate fm = new ForManipulate();
		System.out.println("Changed value of f is " + fm.manipulate());
	}
}