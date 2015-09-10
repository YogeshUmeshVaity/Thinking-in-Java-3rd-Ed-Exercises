import java.util.*;
import com.bruceeckel.util.*;
public class Ex5 {
	public static void main(String[] args) {
		//List list = new ArrayList();
		List list = new LinkedList();
		Collections2.fill(list, Collections2.countries, 9);
		list.add("BRAZIL");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println("shuffle() 1 : ");
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println("shuffle() 2 : ");
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println("shuffle() 3 : ");
		Collections.shuffle(list);
		System.out.println(list);
	}
}