//: c11:CatsAndDogs.java
// Simple container example.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package ex8;
import ex8.*;
import java.util.*;
import java.lang.reflect.*;

public class CatsAndDogs {
  public static void main(String[] args) {
    List cats = new ArrayList();
    for(int i = 0; i < 7; i++)
      cats.add(new Cat(i));
    // Not a problem to add a dog to cats:
    cats.add(new Dog(7));
	// To repair you must check type first and then call the id()
	// for the appropriate type
    for(int i = 0; i < cats.size(); i++) {
		Object o = cats.get(i);
		if(o instanceof Cat) {
			((Cat)o).id();
		}
		else if(o instanceof Dog) {
			((Dog)o).id();
		}
	}
      //((Cat)cats.get(i)).id();
      // Dog is detected only at run time
  }
} ///:~
