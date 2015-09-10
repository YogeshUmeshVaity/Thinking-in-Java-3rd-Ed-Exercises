import java.util.*;
import com.bruceeckel.util.*;

public class Ex18 {
	public static void main(String[] args) {
		//TreeSet<String> is by default sorted lexicographically
		//!Set s = new TreeSet();
		
		Set s = new TreeSet(new AlphabeticComparator());
		Collections2.fill(s, new Arrays2.RandStringGenerator(6), 9);
		System.out.println("TreeSet\n" + s);
	}
}

/* The algorithms used in TreeSet assume that the sort order
will not change after the TreeSet has been created, and they
intentionally do not offer you the option to change it.
(E.g. there's no setComparator(), because you might call that
when you shouldn't.) So once you create a TreeSet you can't sort it.
If you want to sort an already created TreeSet,
you can create a new TreeSet and load it from the old one like following :

Set newSet = new TreeSet(newComparator);
newSet.addAll(oldSet);

*/