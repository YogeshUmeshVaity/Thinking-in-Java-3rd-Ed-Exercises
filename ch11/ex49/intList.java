package ex49;
import java.util.*;

public interface intList {
    boolean isEmpty();
	
    boolean contains(int i);
	
    Iterator iterator();
	
    int[] toArray();
	
    boolean add(int i);

    boolean remove(int i);

    boolean containsAll(int[] c);

    boolean addAll(int[] c);

    boolean addAll(int index, int[] c);

    boolean removeAll(int[] c);

    boolean retainAll(int[] c);

    void clear();

    boolean equals(int i);
	
    int hashCode();

    int get(int index);

    int set(int index, int element);

    void add(int index, int element);

    int indexOf(int o);

    int lastIndexOf(int o);

    ListIterator listIterator();

    ListIterator listIterator(int index);

    intList subList(int fromIndex, int toIndex);
}

/**
 * To make a special List for all primitive types we'll
 * need to overload the methods for each primitive types.
 */
 
 /**
  * If we want to make a linked list class that works with
  * all the primitive types, we'll need to write the definitions
  * of each overloaded method for each primitive types.
  */

