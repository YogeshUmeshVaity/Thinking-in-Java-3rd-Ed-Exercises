//: c11:MPair.java
// A new type of Map.Entry.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package TIJEx.Ch11.ex48;
import java.util.*;

public class MPair implements Map.Entry, Comparable {
  private Object key, value;
  public MPair(Object k, Object v) {
    key = k;
    value = v;
  }
  public Object getKey() { return key; }
  public Object getValue() { return value; }
  public Object setValue(Object v) {
    Object result = value;
    value = v;
    return result;
  }
  public boolean equals(Object o) {
    return key.equals(((MPair)o).key);
  }
  public int compareTo(Object rv) {
    return ((Comparable)key).compareTo(((MPair)rv).key);
  }
  public String toString() {
	  return key + "=" + value;
  }
} ///:~
