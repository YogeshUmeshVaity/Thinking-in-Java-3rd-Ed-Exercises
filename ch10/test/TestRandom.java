import java.util.*;
class TestRandom {
	public static void main(String[] args) {
		Random rnd = new Random();
		while(true) {
			int i = rnd.nextInt(6); // This only produces 0-5 not 6
			System.out.println(i);
			if(i == 6) break;
		}
	}
}