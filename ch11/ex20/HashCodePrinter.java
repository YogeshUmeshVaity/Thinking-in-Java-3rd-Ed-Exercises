import java.util.*;
import com.bruceeckel.util.*;

public class HashCodePrinter {
	public static void print(Collection c) {
		Iterator it = c.iterator();
		int index = 0;
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println("Object " + index + " hash code = " + o.hashCode());
			index++;
		}
	}
	public static void main(String[] args) {
		Collection al = new ArrayList();
		Collections2.fill(al, Collections2.countries, 3);
		System.out.println("\nArrayList : ");
		print(al);
		
		Collection ll = new LinkedList();
		Collections2.fill(ll, Collections2.countries, 3);
		System.out.println("\nLinkedList : ");
		print(ll);
		
		Collection hs = new HashSet();
		Collections2.fill(hs, Collections2.countries, 3);
		System.out.println("\nHashSet : ");
		print(hs);
		
		Collection ts = new TreeSet();
		Collections2.fill(ts, Collections2.countries, 3);
		System.out.println("\nTreeSet : ");
		print(ts);
	}
}