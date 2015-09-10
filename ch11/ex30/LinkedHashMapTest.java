import java.util.*;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap lhm = new LinkedHashMap();
		lhm.put("RAM", new Ibm(1));
		lhm.put("Hard Disk", new Ibm(2));
		lhm.put("Processor", new Ibm(3));
		System.out.println("\nLHM before sort : \n\n" + lhm);
		LinkedList pairs = new LinkedList(lhm.entrySet());
		// sort the linked list based on keys using comparator
		Collections.sort(pairs, new Comparator() {
			public int compare(Object o1, Object o2) {
				Map.Entry me1 = (Map.Entry)o1;
				Map.Entry me2 = (Map.Entry)o2;
				String s1 = (String)me1.getKey();
				String s2 = (String)me2.getKey();
				return s1.compareTo(s2);
			}
		});
		// insert the linked list back into the map
		lhm = new LinkedHashMap();
		Iterator it = pairs.iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			Object key = pair.getKey();
			Object value = pair.getValue();
			lhm.put(key, value);
		}
		System.out.println("\nLHM after sort : \n\n" + lhm);
	}
}

class Ibm {
	int a;
	Ibm(int a) {
		this.a = a;
	}
	public String toString() {
		return "IBM " + a;
	}
}