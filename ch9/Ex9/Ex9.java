import java.util.*;

public class Ex9 {
	public static void main(String[] args) {
		int[] windows = new int[60];
		Random rnd = new Random();
		// produces array out of bound exception.
		for(int i = 0; i < 60; i++) {
			windows[i] = rnd.nextInt(60);
		}
		// resumes after catching the exception
		while(true) {
			try {
			System.out.println(windows[rnd.nextInt(66)]);
			} catch(ArrayIndexOutOfBoundsException ae) {
			System.err.println("Caught the exception : " + ae);
			} 
			//!System.out.println(windows[rnd.nextInt(90)]);
		}
	}
}