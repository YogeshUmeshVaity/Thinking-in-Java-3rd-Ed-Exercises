//: c11:SlowMap.java
// A Map implemented with ArrayLists.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;
import com.bruceeckel.util.*;

public class SlowMap extends AbstractMap {
  private static Test monitor = new Test();
  /* private List
    keys = new ArrayList(),
    values = new ArrayList(); */
	private List mPairs = new ArrayList();
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
			return oldValue;
		}
	}
	if(!found) {
		mPairs.add(new MPair(key, value));
	}
	return null;
    /* Object result = get(key);
    if(!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else
      values.set(keys.indexOf(key), value);
    return result; */
  }
  public Object get(Object key) {
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		if((tempPair.getKey()).equals(key)) {
			return tempPair.getValue();
		}
	}
	return null;
    /* if(!keys.contains(key))
      return null;
    return values.get(keys.indexOf(key)); */
  }
  public Set entrySet() {
    Set entries = new HashSet();
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		entries.add(it.next());
	}
    /* Iterator
      ki = keys.iterator(),
      vi = values.iterator();
    while(ki.hasNext())
      entries.add(new MPair(ki.next(), vi.next())); */
    return entries;
  }
  public String toString() {
    StringBuffer s = new StringBuffer("{");
	Iterator it = mPairs.iterator();
	while(it.hasNext()) {
		MPair tempPair = (MPair)it.next();
		s.append(tempPair.getKey() + "=" + tempPair.getValue());
		if(it.hasNext()) s.append(", ");
	}
    /* Iterator
      ki = keys.iterator(),
      vi = values.iterator();
    while(ki.hasNext()) {
      s.append(ki.next() + "=" + vi.next());
      if(ki.hasNext()) s.append(", ");
    } */
    s.append("}");
    return s.toString();
  }
  public static void main(String[] args) {
    SlowMap m = new SlowMap();
    Collections2.fill(m, Collections2.geography, 15);
    System.out.println(m);
	System.out.println(m.entrySet());
	//System.out.println(m.get("ANGOLA"));
   /*  monitor.expect(new String[] {
      "{ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo,"+
      " BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, " +
      "BURUNDI=Bujumbura, CAMEROON=Yaounde, " +
      "CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui,"+
      " CHAD=N'djamena, COMOROS=Moroni, " +
      "CONGO=Brazzaville, DJIBOUTI=Dijibouti, " +
      "EGYPT=Cairo, EQUATORIAL GUINEA=Malabo}"
    }); */
  }
} ///:~
