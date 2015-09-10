//: c11:SimpleHashMap.java
// A demonstration hashed Map.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class SimpleHashMapAL extends AbstractMap {
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
  public static void main(String[] args) {
    SimpleHashMapAL m = new SimpleHashMapAL();
    Collections2.fill(m, Collections2.geography, 25);
    System.out.println(m);
  }
} ///:~
