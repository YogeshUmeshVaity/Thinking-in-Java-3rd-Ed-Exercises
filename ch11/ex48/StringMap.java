package tijex.ch11.ex48;
import java.util.*;
import com.bruceeckel.util.*;
import tijex.ch11.ex48.*;
public class StringMap {
	private int capacity = 457;
	private AssociativeArray[] bucket = new AssociativeArray[capacity];
	public String put(String key, String value) {
		String result = "";
		int index = key.hashCode() % capacity;
		if(index < 0) index = -index;
		if(bucket[index] == null)
			bucket[index] = new AssociativeArray(3);
		AssociativeArray list = bucket[index];
		boolean found = false;
		for(int i = 0; i < list.pairs.length; i++) {
			if(list.pairs[i][0] == null) continue;
			if(list.pairs[i][0].equals(key)) {
				result = list.pairs[i][1];
				list.pairs[i][1] = value;
				found = true;
				break;
			}
		}
		if(!found) {
			list.put(key, value);
		}
		return result;
	}
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null) continue;
			AssociativeArray list = bucket[i];
			for(int j = 0; j < list.pairs.length; j++) {
				if(list.pairs[j][0] != null) 
					s.append(list.pairs[j][0] + "=" + list.pairs[j][1] + ", ");
			}
		}
		s.append("}");
		return s.toString();
	}
	public String get(String key) {
		int index = key.hashCode() % capacity;
		if(index < 0) index = -index;
		if(bucket[index] == null) return null;
		AssociativeArray list = bucket[index];
		for(int i = 0; i < list.pairs.length; i++) {
			if(list.pairs[i][0] == null) continue;
			if(list.pairs[i][0].equals(key)) {
				return list.pairs[i][1];
			}
		}
		return "";
	}
	public Set entrySet() {
		HashSet s = new HashSet();
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null) continue;
			AssociativeArray list = bucket[i];
			for(int j = 0; j < list.pairs.length; j++) {
				if(list.pairs[j][0] != null) {
					MPair pair = new MPair(list.pairs[j][0], list.pairs[j][1]);
					s.add(pair);
				}
			}
		}
		return s;
	}
	public void clear() {
		//bucket = new AssociativeArray[capacity];
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null) continue;
			bucket[i] = null;
		}
	}
	/* public static void main(String[] args) {
		StringMap m = new StringMap();
		Collections2.fill(m, Collections2.geography2, 1000);
		//m.put("ABC", "abc");
		//m.put("XYZ", "xyz");
		//m.put("PQR", "pqr");
		//System.out.println(m);
		//System.out.println("Search XYZ : " + m.get("PQR"));
		//m.put("ABC", "ac");
		System.out.println(m);
		//System.out.println("entrySet : " + m.entrySet());
		m.clear();
		System.out.println(m);
		Collections2.fill(m, Collections2.geography2.reset(), 6);
		System.out.println(m);
	} */
}
