import java.util.*;
import com.bruceeckel.util.*;

public class Regex {
	public static void main(String[] args) {
		Map m = new HashMap();
		Collections2.fill(m, Collections2.geography, 90);
		Set keySet = m.keySet();
		Set specifiedCountries = new HashSet();
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			String s = (String)o;
			if(s.startsWith("A")) {
				specifiedCountries.add(o);
			}
		}
		System.out.println("\n(Set)Countries starting with A : \n" + specifiedCountries);
		// Changing the keySet of the Map makes changes in the Map
		keySet.retainAll(specifiedCountries);
		System.out.println("\n(Map)nCountries start with A : \n" + m);
	}
}