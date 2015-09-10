public class Ex4 {
	public static void main(String[] args) {
		Object o = new Object(); // define an object reference
		o = null; // initialize it to null
		try {
			o.hashCode(); // hashCode is method of Object
		} catch(NullPointerException ne) {
			System.err.println("Caught the exception");
		}
		
	}
}