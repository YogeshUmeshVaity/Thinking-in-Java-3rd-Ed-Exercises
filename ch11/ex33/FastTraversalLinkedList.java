import java.util.*;

public class FastTraversalLinkedList extends AbstractList {
	//private List al = new ArrayList();
	//private List ll = new LinkedList();
	private List currentList = new ArrayList();
	public void toArr() {
		if(currentList instanceof LinkedList) {
			currentList = new ArrayList(currentList);
		}
	}
	public void toLinked() {
		if(currentList instanceof ArrayList) {
			currentList = new LinkedList(currentList);
		}
	}
	public boolean add(Object o) {
			toLinked();
			return currentList.add(o);
	}
	public ListIterator listIterator() {
		toArr();
		return currentList.listIterator();
	}
	public ListIterator listIterator(int i) {
		return currentList.listIterator(i);
	}
	public Object get(int index) {
		toArr();
		return currentList.get(index);
	}
	public boolean remove(Object o) {
		toLinked();
		return currentList.remove(o);
	}
	public int size() {
		toArr();
		return currentList.size();
	}
	public List subList(int fromIndex, int toIndex) {
		return currentList.subList(fromIndex, toIndex);
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		//toArr();
		ListIterator lit = currentList.listIterator();
		while(lit.hasNext()) {
			s.append(lit.next());
			if(lit.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}
	public static void main(String[] args) {
		FastTraversalLinkedList fl = new FastTraversalLinkedList();
		fl.add("XYZ");
		fl.add("ABC");
		System.out.println(fl);
	}
}