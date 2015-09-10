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
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		StringClass[] ar = new StringClass[9];
		Arrays2.fill(ar, generator());
		// To show array is un-sorted after fill()
		ar[6] = new StringClass(new Pair("ABC", "xyz"));
		System.out.println(Arrays.asList(ar));
		Arrays.sort(ar);
		System.out.println("\nArray after sorting(str1) : ");
		System.out.println(Arrays.asList(ar));
		System.out.println("\nArray after sorting(str2) : ");
		Arrays.sort(ar, new StringClassComparator());
		System.out.println(Arrays.asList(ar));
		int binResult1 = Arrays.binarySearch(ar, ar[2], new StringClassComparator());
		System.out.println("\nArrays.binarySearch() for BURUNDI : " + binResult1);
		// Fill ArrayList
		Collections2.fill(al, generator(), 9);
		System.out.println();
		// To show that al is un-sorted after fill()
		al.add(6, new StringClass(new Pair("ABC", "xyz")));
		System.out.println(al);
		System.out.println("\nArrayList after sorting(str1) : ");
		Collections.sort(al);
		System.out.println(al);
		System.out.println("\nArrayList after sorting(str2) : ");
		Collections.sort(al, new StringClassComparator());
		System.out.println(al);
		// binary search the third element in the ArrayList
		int binResult2 =  Collections.binarySearch(al, al.get(3), new StringClassComparator());
		System.out.println("\nCollections.binarySearch() for CONGO : " + binResult2);
		
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