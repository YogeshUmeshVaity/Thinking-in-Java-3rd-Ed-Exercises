//: c11:SlowMap.java
// A Map implemented with ArrayLists.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;
import com.bruceeckel.util.*;

public class SlowMap extends AbstractMap {
  private static Test monitor = new Test();
  private List
    keys = new ArrayList(),
    values = new ArrayList();
  public Object put(Object key, Object value) {
    Object result = get(key);
    if(!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else
      values.set(keys.indexOf(key), value);
    return result;
  }
  public Object get(Object key) {
    if(!keys.contains(key))
      return null;
    return values.get(keys.indexOf(key));
  }
  public Set entrySet() {
    Set entries = new HashSet();
    Iterator
      ki = keys.iterator(),
      vi = values.iterator();
    while(ki.hasNext())
      entries.add(new MPair(ki.next(), vi.next()));
    return entries;
  }
  @Override
  public void clear() {
	  keys.clear();
	  values.clear();
  }
  @Override
  public boolean containsKey(Object o) {
	  return keys.contains(o);
  }
  @Override
  public boolean containsValue(Object o) {
	  return values.contains(o);
  }
  @Override
  public boolean isEmpty() {
	  return keys.isEmpty() && values.isEmpty();
  }
  @Override
  public Set keySet() {
	  // get entrySet and extract the keys
	  Set s = entrySet();
	  Set returnableSet = new HashSet();
	  Iterator it = s.iterator();
	  while(it.hasNext()) {
		  MPair mp = ((MPair)(it.next()));
		  returnableSet.add(mp.getKey());
	  }
	  return returnableSet;
  }
  @Override
  public void putAll(Map m) {
	  Set s = m.entrySet();
	  Iterator it = s.iterator();
	  while(it.hasNext()) {
		  Map.Entry entry = (Map.Entry)(it.next());
		  put(entry.getKey(), entry.getValue());
	  }
  }
  @Override
  public Collection values() {
	  Collection returnableCollection = new ArrayList();
	  Set s = entrySet();
	  Iterator it = s.iterator();
	  while(it.hasNext()) {
		  MPair mp = (MPair)it.next();
		  returnableCollection.add(mp.getValue());
	  }
	  return returnableCollection;
  }
  public String toString() {
    StringBuffer s = new StringBuffer("{");
    Iterator
      ki = keys.iterator(),
      vi = values.iterator();
    while(ki.hasNext()) {
      s.append(ki.next() + "=" + vi.next());
      if(ki.hasNext()) s.append(", ");
    }
    s.append("}");
    return s.toString();
  }
  public static void main(String[] args) {
    SlowMap m = new SlowMap();
    Collections2.fill(m, Collections2.geography, 15);
    System.out.println(m);
	// Test clear()
	m.clear();
	System.out.println("\nm.clear() : \n" + m);
	// Test containsKey()
	Collections2.fill(m, Collections2.geography, 15);
	System.out.println("\nm.containsKey() : \n" + m.containsKey(m.keys.get(3)));
	// Test containsValue
	System.out.println("\nm.containsValue() : \n" + m.containsValue(m.values.get(3)));
	// Test isEmpty()
	m.clear();
	System.out.println("\nm.isEmpty() : " + m.isEmpty());
	// Test keySet()
	Collections2.fill(m, Collections2.geography.reset(), 15);
	System.out.println("\nm.keySet() : \n" + m.keySet());
	// Test putAll
	// create new map
	SlowMap m2 = new SlowMap();
	m2.put("BBQ", "hello");
    m.putAll(m2);
	System.out.println(m);
	// Test values()
	System.out.println("\nm.values() : \n" + m.values());
  }
} ///:~
