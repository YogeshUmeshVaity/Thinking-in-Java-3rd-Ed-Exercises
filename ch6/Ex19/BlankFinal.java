class TestClass {
	
}

public class BlankFinal {
	final TestClass tc1;
	final int i;
	TestClass tc2;
	//!final int x;
	//!final TestClass tc3;
	
	BlankFinal() {
		tc1 = new TestClass();
		i = 6;
	}
	public static void main(String[] args) {
		BlankFinal bf = new BlankFinal();
		// if you compile the program without initializing the tc2,
		// compiler will not complain because it's not final.
		// But if you compile tc3 without initializing the compiler will complian,
		// error: variable tc3 might not have been initialized
		// The following line tries to change the already initialized tc1
		
		//!bf.tc1 = new TestClass();
		//!bf.i = 16;
		// above lines pop errors: cannot assign a value to final variable.
	}
}