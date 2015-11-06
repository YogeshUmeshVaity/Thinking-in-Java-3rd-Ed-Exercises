/* Modify Compete.java to add more member objects to classes 
 * Thing2 and Thing4 and see if you can determine how the timings 
 * vary with complexity—whether it’s a simple linear relationship 
 * or if it seems more complicated.
 * 
 *
 * ###Results : 
 *
 * Initial values minimum of 6 results
 * Ser : 151 ms, Clone : 7 ms
 * With 1 level added
 * Ser : 193 ms, Clone : 10 ms
 *
 */
import java.io.*;

class Thing1 implements Serializable {}
class Thing5 implements Serializable {}
class Thing2 implements Serializable {
  Thing1 o1 = new Thing1();
  Thing5 o5 = new Thing5();
}

class Thing3 implements Cloneable {
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Thing3 can't clone");
    }
    return o;
  }
}

class Thing6 implements Cloneable {
  @Override
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Thing6 can't clone");
    }
    return o;
  }
}

class Thing4 implements Cloneable {
  private Thing3 o3 = new Thing3();
  private Thing6 o6 = new Thing6();
  public Object clone() {
    Thing4 o = null;
    try {
      o = (Thing4)super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Thing4 can't clone");
    }
    // Clone the field, too:
    o.o3 = (Thing3)o3.clone();
    o.o6 = (Thing6)o6.clone();
    return o;
  }
}

public class Compete1 {
  public static final int SIZE = 25000;
  public static void main(String[] args) throws Exception {
    Thing2[] a = new Thing2[SIZE];
    for(int i = 0; i < a.length; i++)
      a[i] = new Thing2();
    Thing4[] b = new Thing4[SIZE];
    for(int i = 0; i < b.length; i++)
      b[i] = new Thing4();
    long t1 = System.currentTimeMillis();
    ByteArrayOutputStream buf= new ByteArrayOutputStream();
    ObjectOutputStream o = new ObjectOutputStream(buf);
    for(int i = 0; i < a.length; i++)
      o.writeObject(a[i]);
    // Now get copies:
    ObjectInputStream in = new ObjectInputStream(
        new ByteArrayInputStream(buf.toByteArray()));
    Thing2[] c = new Thing2[SIZE];
    for(int i = 0; i < c.length; i++)
      c[i] = (Thing2)in.readObject();
    long t2 = System.currentTimeMillis();
    System.out.println("Duplication via serialization: " +
      (t2 - t1) + " Milliseconds");
    // Now try cloning:
    t1 = System.currentTimeMillis();
    Thing4[] d = new Thing4[SIZE];
    for(int i = 0; i < d.length; i++)
      d[i] = (Thing4)b[i].clone();
    t2 = System.currentTimeMillis();
    System.out.println("Duplication via cloning: " +
      (t2 - t1) + " Milliseconds");
  }
}



