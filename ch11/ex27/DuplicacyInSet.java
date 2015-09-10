import java.util.*;
import com.bruceeckel.util.*;

public class DuplicacyInSet {
	public static void test(Set s) {
		System.out.println(s.getClass().getSimpleName() + " : ");
		//fill the set
		s.add("ABC");
		s.add("abc");
		s.add("ABC"); // try adding duplicate
		s.add("abc");
		s.add("XYZ");
		s.add("xyz");
		s.add("XYZ");
		// display set to verify that
		// Set ends up with only one of each instance
		System.out.println(s);
	}
	public static void main(String[] args) {
		// test both kinds of Set
		test(new HashSet());
		test(new TreeSet());
	}
}