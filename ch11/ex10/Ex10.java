import java.util.*;
import com.bruceeckel.util.*;
public class Ex10 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		Collections2.fill(hs, Collections2.countries, 9);
		System.out.println(hs);
		Iterator it = hs.iterator();
		LinkedList l = new LinkedList();
		while(it.hasNext()) {
			l.add(it.next());
		}
		Collections.sort(l); // Sort the linked list
		System.out.println("\nInsertion Order : " + l);
		LinkedHashSet lhs = new LinkedHashSet();
		for (int i = 0; i < l.size(); i++) {
			lhs.add(l.get(i));
		}
		System.out.println("\n" + lhs);
	}
}