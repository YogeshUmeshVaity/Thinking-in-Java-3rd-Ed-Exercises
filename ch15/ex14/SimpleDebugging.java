//: c15:SimpleDebugging.java
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.*;

public class SimpleDebugging {
  static List arrayList; // Uninitialized reference
  private static void foo1() {
    System.out.println("In foo1");
    // use the reference - throws NullPointerException
    arrayList.add(new Object()); 
  }
  public static void main(String[] args) {
    foo1();
  }
} ///:~
