interface Test {
	int x = 9;
}

public class Ex1 {
	public static void main(String[] args) {
		// access the field x of interface Test without creating its object
		// proves that x is static.
		System.out.println(Test.x);
		// try to change the value of x gives error :
		// cannot assign a value to final variable x
		//!Test.x = 5;
	}
}

// Proves that fields in interface are implicitly static and final.
