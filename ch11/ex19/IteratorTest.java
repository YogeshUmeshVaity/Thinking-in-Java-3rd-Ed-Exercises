import java.util.*;
import com.bruceeckel.util.*;

public class IteratorTest {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		Collections2.fill(l1, Collections2.capitals, 9);
		Iterator it1 = l1.iterator();
		System.out.println("\nArrayList printed using ordinary Iterator...\n");
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
		List l2 = new LinkedList();
		Collections2.fill(l2, Collections2.capitals, 9);
		Iterator it2 = l2.iterator();
		System.out.println("\nLinkedList printed using ordinary Iterator...\n");
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		// copy l1 before modifying it
		List l3 = new ArrayList();
		l3.addAll(l1);
		// forward insertion
		ListIterator lt1 = l1.listIterator();
		ListIterator lt2 = l2.listIterator();
		while(lt1.hasNext()) {
			//lt1.next();
			while(lt2.hasNext()) {
				lt1.add(lt2.next());
				lt1.next();
			}
		}
		System.out.println("\nLinkedList added to ArrayList(forward) : \n" + l1);
		// backward insertion
		ListIterator lt3 = l3.listIterator();
		lt2 = l2.listIterator(l2.size());
		while(lt3.hasNext()) {
			while(lt2.hasPrevious()) {
				lt3.add(lt2.previous());
				lt3.next();
				//System.out.println("......");
			}
			//System.out.println("...");
		}
		System.out.println("\nLinkedList added to ArrayList(backward) : \n" + l3);
		
	}
}