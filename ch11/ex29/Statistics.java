//: c11:Statistics.java
// Simple demonstration of HashMap.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

class SetCounter {
  int counterKey;
  int counterValue = 1;
  SetCounter(int a) {
	  counterKey = a;
  } 
  public String toString() { return "" + counterKey + "=" + counterValue; }
}

class Counter {
  int i = 1;
  public String toString() { return Integer.toString(i); }
}

public class Statistics {
  private static Random rand = new Random();
  public static void main(String[] args) {
	  int reps = 10000000;
	  System.out.println("Testing HashSet...");
	  long t1 = System.currentTimeMillis();
	  Set hs = new HashSet();
	  for(int i = 0; i < reps; i++) {
		  int r = rand.nextInt(20);
		  Iterator it = hs.iterator();
		  boolean found = false;
		  while(it.hasNext()) {
			  Object o = it.next();
			  SetCounter sc = (SetCounter)o;
			  if(sc.counterKey == r) {
				  found = true;
				  ((SetCounter)o).counterValue++;
				  break;
			  }
		  }
		  if(found == false) {
			  hs.add(new SetCounter(r));
		  }
	  }
	  long t2 = System.currentTimeMillis();
	  System.out.println("\nHashSet Time : " + (t2 - t1));
		System.out.println("\n" + hs);
	System.out.println("Testing HashMap...");
	long t3 = System.currentTimeMillis();
    Map hm = new HashMap();
    for(int i = 0; i < reps; i++) {
      // Produce a number between 0 and 20:
      Integer r = new Integer(rand.nextInt(20));
      if(hm.containsKey(r))
        ((Counter)hm.get(r)).i++;
      else
        hm.put(r, new Counter());
    }
	long t4 = System.currentTimeMillis();
	System.out.println("\nHashMap Time : " + (t4 - t3));
    System.out.println("\n" + hm);
  }
} ///:~
// HashMap is significantly faster(3 times) than HashSet
// So HashMap implementation is better.