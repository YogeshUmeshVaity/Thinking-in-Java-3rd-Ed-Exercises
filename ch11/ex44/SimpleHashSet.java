import java.util.*;
import com.bruceeckel.util.*;
public class SimpleHashSet extends AbstractSet {
	private static int capacity = 997;
	private LinkedList[] bucket = new LinkedList[capacity];
	public boolean add(Object o) {
		int index = o.hashCode() % capacity;
		if(index < 0) index = -index;
		if(bucket[index] == null) {
			bucket[index] = new LinkedList();
		}
		boolean found = false;
		//search if the element already exists
			LinkedList element = bucket[index];
			ListIterator it = element.listIterator();
			while(it.hasNext()) {
				Object tempObject = it.next();
				if(tempObject.equals(o)) {
					found = true;
					break;
				}
			}
		    if(!found) {
				//System.out.println("index" + index);
				bucket[index].add(o);
				return true;
			}
			else return false;
	}
	public int size() {
	  int sz = 0;
	  for(int i = 0; i < bucket.length; i++) {
		  if(bucket[i] == null) continue;
		  sz = sz + bucket[i].size();
	  }
	  return sz;
	}
	public Iterator iterator() {
		// it.remove won't work
		Set s = new HashSet();
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null) continue;
			ListIterator it = bucket[i].listIterator();
			while(it.hasNext()) {
				s.add(it.next());
			}
		}
		return s.iterator();
	}
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null) continue;
			ListIterator it = bucket[i].listIterator();
			while(it.hasNext()) {
				s.append(it.next() + ", ");
			}
		}
		// remove the comma and space of the last element
		s.deleteCharAt(s.length() - 2);
		s.deleteCharAt(s.length() - 1);
		s.append("]");
		return s.toString();
	}
	public static void main(String[] args) {
		SimpleHashSet s = new SimpleHashSet();
		s.add("ABC");
		s.add("XYZ");
		s.add("PQR");
		s.add("ABC");
		//Collections2.fill(s, Collections2.countries, 9999);
		System.out.println(s);
		System.out.println("\nSize : " + s.size());
		Iterator it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it.remove();
		System.out.println(s);
	}
}