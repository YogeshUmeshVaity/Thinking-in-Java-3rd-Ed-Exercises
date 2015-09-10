class FirstException extends Exception {}
class SecondException extends Exception {}
class ThirdException extends Exception {}

public class Ex14 {
	void throwExceptions(int selectException)
		throws FirstException, SecondException, ThirdException {
			switch(selectException) {
				case 1 : throw new FirstException();
				case 2 : throw new SecondException();
				case 3 : throw new ThirdException();
				default : return;
			}
	}
	public static void main(String[] args) {
		Ex14 ex14 = new Ex14();
		try {
			ex14.throwExceptions(3);
			// since all three exceptions are derived from Exception class
			// Just catching Exception works for all three
		} catch(Exception e) {
			System.err.println("Exception caught");
			throw new NullPointerException();
		} finally {
			System.err.println("Finally still executes");
		}
	}
}