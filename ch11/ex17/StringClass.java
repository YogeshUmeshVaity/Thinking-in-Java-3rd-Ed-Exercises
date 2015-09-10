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
		return str1.toLowerCase().compareTo(((StringClass)o).str1.toLowerCase());
	}
	public String toString() {
		return "(" + str1 + " = " + str2 + ")";
	}
	public static Generator generator() {
		return new Generator() {
			public Object next() {
				return new StringClass(Collections2.geography.next());
			}
		};
	}
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		StringClass[] ar = new StringClass[9];
		Arrays2.fill(ar, generator());
		// To show array is un-sorted after fill()
		ar[6] = new StringClass(new Pair("abc", "xyz"));
		System.out.println(Arrays.asList(ar));
		Arrays.sort(ar);
		System.out.println("\nArray after sorting(str1) : ");
		System.out.println(Arrays.asList(ar));
		System.out.println("\nArray after sorting(str2) : ");
		Arrays.sort(ar, new StringClassAlphabeticComparator());
		System.out.println(Arrays.asList(ar));
		// Fill ArrayList
		Collections2.fill(al, generator(), 9);
		System.out.println();
		// To show that al is un-sorted after fill()
		// aBC appears last because it's Lexicographical sort
		// Lexicographical = All capitals letters first and then small letters
		// Alphabetic sort doesn't care about upper or lower case, it keeps upper and lower cases together
		//al.add(6, new StringClass(new Pair("aBC", "xyz")));
		al.add(new StringClass(new Pair("abc", "eyz")));
		//al.add(11, new StringClass(new Pair("abc", "xyz")));
		System.out.println(al);
		System.out.println("\nArrayList after sorting(str1) : ");
		Collections.sort(al);
		System.out.println(al);
		System.out.println("\nArrayList after sorting(str2) : ");
		Collections.sort(al, new StringClassAlphabeticComparator());
		System.out.println(al);
	}
}

// cares only about 2nd string(str2)
class StringClassAlphabeticComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		String s1 = ((StringClass)o1).str2;
		s1 = s1.toLowerCase();
		String s2 = ((StringClass)o2).str2;
		s2 = s2.toLowerCase();
		return s1.compareTo(s2);
	}
}