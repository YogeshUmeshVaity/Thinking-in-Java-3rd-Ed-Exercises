//: c11:Statistics.java
// Simple demonstration of HashMap.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

class Counter {
  int i = 1;
  public String toString() { return Integer.toString(i); }
}

public class Statistics {
  private static Random rand = new Random();
  public static void main(String[] args) {
	int reps = 99;
    Map hm2 = new TreeMap();
	for(int j = 0; j < reps; j++) {
	Map hm = new HashMap();
    for(int i = 0; i < 10000; i++) {
      // Produce a number between 0 and 20:
      Integer r = new Integer(rand.nextInt(20));
      if(hm.containsKey(r))
        ((Counter)hm.get(r)).i++;
      else
        hm.put(r, new Counter());
    }
	//System.out.println(hm);
    Collection c = hm.values();
	Object maxObject = Collections.max(c, new CounterComparator());
	Set s = hm.entrySet();
	// get iterator for set of entries, traverse and find
	// the match for maxObject and get that key and add to new map
	Iterator setIterator = s.iterator();
	while(setIterator.hasNext()) {
		Map.Entry e = (Map.Entry)setIterator.next();
		Object key = e.getKey();
		Object value = e.getValue();
		if(value.equals(maxObject)) {
			if(hm2.containsKey(key)) {
				((Counter)hm2.get(key)).i++;
			}
			else {
				hm2.put(key, new Counter());
			}
		}
	}
	}
	System.out.println(hm2);
  }
} ///:~

class CounterComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int i1 = ((Counter)o1).i;
		int i2 = ((Counter)o2).i;
		return i1 < i2 ? -1 : (i1 == i2 ? 0 :1);
	}
}