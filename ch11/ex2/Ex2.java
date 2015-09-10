/* Create a new class called Gerbil with an int
 gerbilNumber that’s initialized in the constructor
 (similar to the Mouse example in this chapter).
 Give it a method called hop( ) that prints out which
 gerbil number this is, and that it’s hopping. Create
 an ArrayList and add a bunch of Gerbil objects to the List.
 Now use the get( ) method to move through the List and call
 hop( ) for each Gerbil. */
import java.util.*;
class Gerbil {
	private int gerbilNumber;
	public Gerbil(int num) {
		gerbilNumber = num;
	}
	void hop() {
		System.out.println("Gerbil " + gerbilNumber + " is hopping");
	}
}

public class Ex2 {
	public static void main(String[] args) {
		List gerbilList = new ArrayList();
		for(int i = 0; i < 9; i++) {
			gerbilList.add(new Gerbil(i));
		}
		for(int i = 0; i < gerbilList.size(); i++) {
		((Gerbil)gerbilList.get(i)).hop();
		}
	}
}