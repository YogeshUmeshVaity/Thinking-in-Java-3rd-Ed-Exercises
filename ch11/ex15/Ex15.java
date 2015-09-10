import pack.*;
import java.util.*;
import com.bruceeckel.util.*;
public class Ex15 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		System.out.println("\nArrayList : ");
		MovieCharGenerator.fill(al, 27);
		System.out.println(al);
		LinkedList l = new LinkedList();
		System.out.println("\nLinkedList : ");
		MovieCharGenerator.fill(l, 27);
		System.out.println(l);
		Set hs = new HashSet();
		System.out.println("\nHashSet : ");
		MovieCharGenerator.fill(hs, 27);
		System.out.println(hs);
		Set ts = new TreeSet();
		System.out.println("\nTreeSet : ");
		MovieCharGenerator.fill(ts, 27);
		System.out.println(ts);
		String[] s = new String[27];
		System.out.println("\nArray : ");
		MovieCharGenerator.fill(s);
		System.out.println(Arrays2.toString(s));
	}
}