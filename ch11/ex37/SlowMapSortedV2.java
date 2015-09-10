//: c11:SlowMap.java
// A Map implemented with ArrayLists.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;
import com.bruceeckel.util.*;
import java.lang.*;

public class SlowMapSortedV2 extends AbstractMap {
  private static Test monitor = new Test();
	private List mPairs = new ArrayList();
	@Override
    public Object put(Object key, Object value) {
	boolean found = false;
	//iterate through the mPairs to see if the key already exists
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		if((tempPair.getKey()).equals(key)) {
			Object oldValue = tempPair.getValue();
			tempPair.setValue(value);
			found = true;
			sortMap();
			return oldValue;
		}
	}
	if(!found) {
		mPairs.add(new MPair(key, value));
		sortMap();
	}
	return null;
  }
  @Override
  public Object get(Object key) {
	List s = sortedKeyList();
	if(!s.contains(key)) {
		return null;
	}
	int index = Collections.binarySearch(s, key);
	//System.out.println("index = " + index);
	MPair pair = ((MPair)mPairs.get(index));
	return pair.getValue();
	/* Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		if((tempPair.getKey()).equals(key)) {
			return tempPair.getValue();
		}
	}
	return null; */
  }
  private Object getNoSort(Object key) {
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		if((tempPair.getKey()).equals(key)) {
			return tempPair.getValue();
		}
	}
	return null;
  }
  public Set entrySet() {
    Set entries = new HashSet();
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		entries.add(it.next());
	}
    return entries;
  }
  private void sortMap() {
	  List s = sortedKeyList();
	  List tempMPairs = new ArrayList();
	  Iterator it = s.iterator();
	  while(it.hasNext()) {
		  Object mpair = it.next();
		  tempMPairs.add(new MPair(mpair, getNoSort(mpair)));
	  }
	  mPairs = new ArrayList(tempMPairs);
  }
  public List sortedKeyList() {
	  List s = new ArrayList();
	  Iterator it = mPairs.iterator();
	  while(it.hasNext()) {
		  MPair tempPair = (MPair)it.next();
		  s.add(tempPair.getKey());
	  }
	  Collections.sort(s, String.CASE_INSENSITIVE_ORDER);
	  return s;
  }
  public String toString() {
    StringBuffer s = new StringBuffer("{");
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		s.append(tempPair.getKey() + "=" + tempPair.getValue());
		if(it.hasNext()) s.append(", ");
	}
    s.append("}");
    return s.toString();
  }
  public static void main(String[] args) {
    SlowMapSortedV2 m = new SlowMapSortedV2();
    Collections2.fill(m, Collections2.geography, 15);
    System.out.println(m);
	System.out.println("Digibouti : " + m.get("DJIBOUTI"));
	m.put("ABC", "xyz");
	System.out.println("\n" + m);
	System.out.println(m.get("ABC"));
  }
} ///:~
