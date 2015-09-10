class FirstException extends Exception {}
class SecondException extends Exception {}
class ThirdException extends Exception {}

public class Ex7 {
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
		Ex7 ex7 = new Ex7();
		try {
			ex7.throwExceptions(3);
			// since all three exceptions are derived from Exception class
			// Just catching Exception works for all three
		} catch(Exception e) {
			System.err.println("Exception caught");
		}
	}
}