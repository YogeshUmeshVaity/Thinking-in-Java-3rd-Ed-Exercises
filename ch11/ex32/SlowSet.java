import java.util.*;
import com.bruceeckel.util.*;

public class SlowSet extends AbstractSet {
	private List list = new ArrayList();
	@Override
	public boolean add(Object o) {
		if(!list.contains(o)) {
			list.add(o);
			return true;
		}
		else return false;
	}
	@Override
	public boolean remove(Object o) {
		if(list.contains(o)) {
			list.remove(o);
			return true;
		}
		else return false;
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			s.append(it.next());
			if(it.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}
	@Override
	public int size() {
		return list.size();
	}
	@Override
	public Iterator iterator() {
		return list.iterator();
	}
	public static void main(String[] args) {
		SlowSet s = new SlowSet();
		Collections2.fill(s, Collections2.countries, 9);
		System.out.println("\n" + s);
		//test iterator and remove
		Iterator it = s.iterator();
		Object o = it.next();
		s.remove(o);
		System.out.println("\n" + s);
		// add duplicates and non-duplicates
		s.add("BENIN");
		s.add("ABC");
		System.out.println("\n" + s);
	}
}