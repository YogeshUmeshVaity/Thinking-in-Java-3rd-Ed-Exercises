import java.util.*;

public class Deque {
	private LinkedList ll = new LinkedList();
	public void putFirst(Object o) {
		ll.addFirst(o);
	}
	public void putLast(Object o) {
		ll.addLast(o);
	}
	public Object getFirst() {
		return ll.removeFirst();
	}
	public void getLast() {
		ll.removeLast();
	}
	public boolean isEmpty() {
		return ll.isEmpty();
	}
	public String toString() {
		return "" + ll;
	}
	public static void main(String[] args) {
		Deque deque = new Deque();
		for(int i = 0; i < 3; i++) {
			deque.putFirst(Integer.toString(i));
		}
		System.out.println("\nDeque after putFirst \"0, 1, 2\"\n" + deque);
		for(int i = 0; i < 6; i++) {
			deque.putLast(Integer.toString(i));
		}
		System.out.println("\nDeque after putLast \"0, 1, 2, 3, 4, 5\"\n" + deque);
		deque.getFirst();
		System.out.println("\nDeque after getFirst\n" + deque);
		deque.getLast();
		deque.getLast();
		System.out.println("\nDeque after getLast twice\n" + deque);
		
	}
}