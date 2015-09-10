public class Ex8 {
	public static void main(String[] args) {
		int[] windows = new int[3];
		// produces array out of bound exception.
		try {
			System.out.println(windows[4]);
		} catch(ArrayIndexOutOfBoundsException ae) {
			System.err.println("Caught the exception : " + ae);
		} 
	}
}