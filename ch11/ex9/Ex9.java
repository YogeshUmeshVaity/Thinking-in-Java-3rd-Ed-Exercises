import java.util.*;
import com.bruceeckel.util.*;
public class Ex9 {
	public static void main(String[] args) {
		Map hm = new HashMap();
		Collections2.fill(hm, Collections2.geography, 9);
		System.out.println(hm);
		Set s = hm.entrySet();
		Iterator it = hm.keySet().iterator();
		List l = new LinkedList();
		while(it.hasNext()) {
			l.add(it.next());
		}
		//System.out.println(l);
		Collections.sort(l);
		System.out.println();
		System.out.println("Insertion Order : " + l);
		Map lhm = new LinkedHashMap();
		for(int i = 0; i < l.size(); i++) {
			Object o = l.get(i);
			lhm.put(o, hm.get(o));
		}
		System.out.println();
		System.out.println(lhm);
	}
}