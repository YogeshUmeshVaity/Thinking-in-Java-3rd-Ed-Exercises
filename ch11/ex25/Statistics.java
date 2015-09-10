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
	int load = 1000000;
    Map hm = new HashMap();
	System.out.println("\nProducing the HashMap...");
	long hmt1 = System.currentTimeMillis();
    for(int i = 0; i < load; i++) {
      // Produce a number between 0 and 20:
      Integer r = new Integer(rand.nextInt(20));
      if(hm.containsKey(r))
        ((Counter)hm.get(r)).i++;
      else
        hm.put(r, new Counter());
    }
	long hmt2 = System.currentTimeMillis();
	System.out.println("HashMap Time : " + (hmt2 - hmt1));
	Map tm = new TreeMap();
	System.out.println("\nProducing the TreeMap...");
	long tmt1 = System.currentTimeMillis();
	for(int i = 0; i < load; i++) {
      // Produce a number between 0 and 20:
      Integer r = new Integer(rand.nextInt(20));
      if(tm.containsKey(r))
        ((Counter)tm.get(r)).i++;
      else
        tm.put(r, new Counter());
    }
	long tmt2 = System.currentTimeMillis();
	System.out.println("TreeMap Time : " + (tmt2 - tmt1));
    System.out.println("\nHashMap : \n" + hm);
	System.out.println("\nTreeMap : \n" + tm);
  }
} ///:~

// for 10000 look ups and inserts TreeMap is about 4 times faster than HashMap
// for 1000000 look ups and inserts HashMap starts performing
// significantly faster than TreeMap.