//: c11:SimpleHashMap.java
// A demonstration hashed Map.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class SimpleHashMap extends AbstractMap {
  // Choose a prime number for the hash table
  // size, to achieve a uniform distribution:
  private static final int SZ = 997;
  private LinkedList[] bucket = new LinkedList[SZ];
  public Object put(Object key, Object value) {
    Object result = null;
	//System.out.println("hash code = " + key.hashCode());
    int index = key.hashCode() % SZ;
	//System.out.println("index before sign force = " + index);
    if(index < 0) index = -index;
	//System.out.println("index after sign force = " + index);
    if(bucket[index] == null)
      bucket[index] = new LinkedList();
    LinkedList pairs = bucket[index];
    MPair pair = new MPair(key, value);
    ListIterator it = pairs.listIterator();
    boolean found = false;
    while(it.hasNext()) {
      Object iPair = it.next();
      if(iPair.equals(pair)) {
        result = ((MPair)iPair).getValue();
        it.set(pair); // Replace old with new
        found = true;
        break;
      }
    }
    if(!found)
      bucket[index].add(pair);
    return result;
  }
  public Object get(Object key) {
    int index = key.hashCode() % SZ;
    if(index < 0) index = -index;
    if(bucket[index] == null) return null;
    LinkedList pairs = bucket[index];
    MPair match = new MPair(key, null);
    ListIterator it = pairs.listIterator();
    while(it.hasNext()) {
      Object iPair = it.next();
      if(iPair.equals(match))
        return ((MPair)iPair).getValue();
    }
    return null;
  }
  // The string representation of the map consists of a list 
  // of key-value mappings in the order returned by
  // the map's entrySet view's iterator,
  // enclosed in braces ("{}")
  public Set entrySet() {
    Set entries = new HashSet();
    for(int i = 0; i < bucket.length; i++) {
      if(bucket[i] == null) continue;
      Iterator it = bucket[i].iterator();
      while(it.hasNext())
        entries.add(it.next());
    }
    return entries;
  }
  // since the collisions are entries with same indices and
  // they will be store in same LinkedList of that index,
  // the sizes of the LinkedLists will be considered collisions
  public int reportCollisions() {
	  int collisions = 0;
	  List collisionList = new ArrayList();
	  for(int i = 0; i < bucket.length; i++) {
		  if(bucket[i] == null) continue;
		  if(bucket[i].size() > 1) {
			  collisions = collisions + bucket[i].size();
			  Iterator it = bucket[i].iterator();
			  while(it.hasNext()) {
				  collisionList.add(it.next());
			  }
		  }
	  }
	  //make map of hashcodes and indices of collisions
	  Map m = new HashMap();
	  Iterator it = collisionList.iterator();
	  while(it.hasNext()) {
		  MPair mpair = (MPair)it.next();
		  m.put((mpair.getKey()).hashCode(), (mpair.getKey()).hashCode() % SZ);
	  }
	  System.out.println("\nCollisions hashcodes and indices : \n" + m);
	  System.out.println("\nNumber of collisions : \n" + collisionList);
	  return collisions;
  }
  public static void main(String[] args) {
    SimpleHashMap m = new SimpleHashMap();
    Collections2.fill(m, Collections2.geography, 25);
	System.out.println("\n" + m);
	Collections2.fill(m, Collections2.geography, 25);
    System.out.println(m);
	Collections2.fill(m, Collections2.geography, 25);
	System.out.println("\n" + m);
	System.out.println("\nCollisions : " + m.reportCollisions());
  }
} ///:~
