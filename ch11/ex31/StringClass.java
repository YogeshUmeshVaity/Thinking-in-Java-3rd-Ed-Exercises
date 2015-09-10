import java.util.*;
import com.bruceeckel.util.*;

public class StringClass implements Comparable {
	public String str1;
	public String str2;
	StringClass(Pair p) {
		this.str1 = (String)p.key;
		this.str2 = (String)p.value;
	}
	// uses only str1 to compare(cares only about first str)
	public int compareTo(Object o) {
		return str1.compareTo(((StringClass)o).str1);
	}
	@Override
	public String toString() {
		return "(" + str1 + ", " + str2 + ")";
	}
	public static Generator generator() {
		return new Generator() {
			public Object next() {
				return new StringClass(Collections2.geography.next());
			}
		};
	}
	@Override
	public int hashCode() {
		int result = 15;
		result = result*37 + str1.hashCode();
		result = result*37 + str2.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o) {
		return (o instanceof StringClass)
		&& str1.equals(((StringClass)o).str1)
		&& str2.equals(((StringClass)o).str2);
	}
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		// Fill HashSet
		Collections2.fill(hs, generator(), 9);
		System.out.println(hs);
		// Add duplicate pairs to check if hashCode works
		Pair pr = new Pair("ABC", "xyz");
		Pair pr2 = new Pair("ABC", "xyz");
		hs.add(new StringClass(pr2));
		hs.add(new StringClass(pr));
		Pair pr1 = new Pair("CAMEROON", "Yaounde");
		//hs.add(new StringClass(Collections2.geography.));
		System.out.println("\n" + hs);
		HashMap m = new HashMap();
		// Fill HashMap
		m.put("ABC", "xyz");
		m.put("ABC", "xyz");
		m.put("PQR", "xyz");
		System.out.println("\nHashMap : \n" + m);
	}
}

// cares only about 2nd string(str2)
class StringClassComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		String s1 = ((StringClass)o1).str2;
		String s2 = ((StringClass)o2).str2;
		return s1.compareTo(s2);
	}
}