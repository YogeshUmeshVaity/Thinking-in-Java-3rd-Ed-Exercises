public class Ex1 {
	public static void main(String[] args) {
		try {
			throw new Exception("First Exception Test");
		} catch(Exception e) {
			System.err.println("Caught the Exception ->" + e);
		} finally {
			System.out.println("You were in 'finally'");
		}
	}
}