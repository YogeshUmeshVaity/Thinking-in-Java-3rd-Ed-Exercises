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
  //public String toString() { return Integer.toString(i); }
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
  //public String toString() { return Integer.toString(i); }
}

public class CloningCollection implements Cloneable {
  private ArrayList list = new ArrayList();
  
  public boolean add(Object o) {
    return list.add(o);
  }
  
  public void add(int index, Object o) {
    list.set(index, o);
  }
  
  public Object get(int index) {
    return list.get(index);
  }
  
  
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
      //Class klass = obj.getClass();
      if(obj instanceof Cloneable) {
        Int2 addable = (Int2)obj;
        o.list.set(i, addable);
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
    System.out.println("cc before modifying cc2" + cc);
    CloningCollection cc2 = (CloningCollection)cc.clone();
    System.out.println("cc2 before modifying" + cc2);
//    Int2 ob1 = (Int2)cc2.get(0);
//    ob1.increment();
//    Int3 ob2 = (Int3)cc2.get(1);
//    ob2.increment();
//    Int2 ob1 = (Int2)cc.get(0);
//    ob1.increment();
//    Int3 ob2 = (Int3)cc.get(1);
//    ob2.increment();
    cc2.add(0, new Int2(12));
    cc2.add(1, new Int3(15));
    System.out.println("cc after modifying cc2" + cc);
    System.out.println("cc2 after modifying" + cc2);
    
    
  }
}
