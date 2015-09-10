class ExplainFinalize {
	int i = 33;
	float f = 4.56f;
	double d = 5.5;
	String s = "Good Programer";
	char c = 'c';
	boolean b = true;
	void changeValue() {
		b = false;
	}
	public void finalize() {
		if(b)
		System.out.println("Object was finalized.");
	}
}

public class Ex11 {
	public static void main(String[] args) {
		new ExplainFinalize();
		System.gc();
	}
}