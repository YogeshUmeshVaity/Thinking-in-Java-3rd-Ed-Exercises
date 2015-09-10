//: c08:Month.java
// A more robust enumeration system.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package ex50;
import java.util.*;
import com.bruceeckel.simpletest.*;

public final class Month implements Comparable {
  private static Test monitor = new Test();
  private String name;
  private int num;
  private Month(String nm, int num) { name = nm; this.num = num;}
  public String toString() { return name; }
  public static final Month
    JAN = new Month("January", 1),
    FEB = new Month("February", 2),
    MAR = new Month("March", 3),
    APR = new Month("April", 4),
    MAY = new Month("May", 5),
    JUN = new Month("June", 6),
    JUL = new Month("July", 7),
    AUG = new Month("August", 8),
    SEP = new Month("September", 9),
    OCT = new Month("October", 10),
    NOV = new Month("November", 11),
    DEC = new Month("December", 12);
  public static final Month[] month =  {
    JAN, FEB, MAR, APR, MAY, JUN,
    JUL, AUG, SEP, OCT, NOV, DEC
  };
  public static final Month number(int ord) {
    return month[ord - 1];
  }
  @Override public int compareTo(Object o) {
	  return (num < ((Month)o).num ? -1 : (num == ((Month)o).num ? 0 : 1));
  }
  public static void main(String[] args) {
	// Test comparable and sort
    List l = new ArrayList();
	l.add(Month.SEP);
	l.add(Month.MAR);
	l.add(Month.JUN);
	System.out.println("\nList before sort : \n" + l);
	Collections.sort(l);
	System.out.println("\nList after sort : \n" + l);
  }
} ///:~
