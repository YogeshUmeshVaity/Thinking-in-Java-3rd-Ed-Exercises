abstract class ProgrammingLanguage {
	abstract void compile();
}

class Java extends ProgrammingLanguage {
	void compile() {
		System.out.println("Java is compiling");
	}
	static void display() {
		ProgrammingLanguage pl = new Java();
		// This works also when there
		// is no abstract method in base class.
		((Java)pl).compile(); 
		// For this to work,
		// there should be the abstract method in base class.
		pl.compile();
	}
}

public class Ex14 {
	public static void main(String[] args) {
		Java.display();
	}
}