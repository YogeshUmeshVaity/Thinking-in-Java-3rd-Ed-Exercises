/* Implement the Collection interface in a class called 
 * CloningCollection by using a private ArrayList to provide the 
 * container functionality. Override the clone( ) method so that 
 * CloningCollection performs a “conditional deep copy”; it 
 * attempts to clone( ) all the elements it contains, but if it 
 * cannot it leaves the reference(s) aliased.
 */

import java.util.*;

class Int2 implements Cloneable {
  private int i;
  public Int2(int ii) { i = ii; }
  public void increment() { i++; }
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Int2 can't clone");
    }
    return o;
  }
}

class Int3 {
  private int i;
  public Int3(int ii) { i = ii; }
  public void increment() { i++; }
}

public class CloningCollection implements Cloneable, Collection {
  private ArrayList list = new ArrayList();
  
  @Override
  public boolean add(Object o) {
    return list.add(o);
  }
  
  @Override
  public void clear() {}
  @Override
  public boolean retainAll(Collection c) { return true;}
  @Override
  public boolean removeAll(Collection c) { return false; }
  @Override 
  public boolean addAll(Collection c) { return false; }
  @Override
  public boolean containsAll(Collection c) { return false; }
  @Override
  public boolean remove(Object o) { return false; }
  @Override
  public boolean contains(Object o) { return false; }
  @Override
  public Object[] toArray(Object[] o) { return new Object[9]; }
  @Override
  public Object[] toArray() { return new Object[9]; }
  @Override
  public Iterator iterator() { return list.iterator(); }
  @Override
  public boolean isEmpty() { return false; }
  @Override
  public int size() { return list.size(); }
  
  @Override
  public Object clone() {
    CloningCollection o = null;
    try {
      o = (CloningCollection)super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Cannot clone CloningCollection");
    }
    o.list = (ArrayList)o.list.clone();
    for(int i = 0; i < o.list.size(); i++) {
      Object obj = o.list.get(i);
      if(obj instanceof Cloneable) {
        Int2 addable = (Int2)obj;
        Int2 cloned = (Int2)addable.clone();
        o.list.set(i, cloned);
      } // else leave it as it is
    }
    return o;
  }
  
  @Override
  public String toString() {
    return "" + list;
  }
  
  public static void main(String[] args) {
    CloningCollection cc = new CloningCollection();
    cc.add(new Int2(9));
    cc.add(new Int3(6));
    System.out.println("cc " + cc);
    CloningCollection cc2 = (CloningCollection)cc.clone();
    System.out.println("cc2 " + cc2);
    // cc[1] and cc2[1] are same because they are references to 
    // the same object.
  }
}
