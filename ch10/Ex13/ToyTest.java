//: c10:ToyTest.java
// Testing class Class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.lang.reflect.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy {
  // Comment out the following default constructor
  // to see NoSuchMethodError from (*1*)
  Toy() {}
  Toy(int i) {
	  System.out.println("Toy created with int = " + i);
  }
}

class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
  FancyToy() { super(1); }
}

public class ToyTest {
  static void printInfo(Class cc) {
    System.out.println("Class name: " + cc.getName() +
      " is interface? [" + cc.isInterface() + "]");
  }
  public static void main(String[] args) {
    Class c = null;
    try {
      c = Class.forName("FancyToy");
    } catch(ClassNotFoundException e) {
      System.out.println("Can't find FancyToy");
      System.exit(1);
    }
    printInfo(c);
    Class[] faces = c.getInterfaces();
    for(int i = 0; i < faces.length; i++)
      printInfo(faces[i]);
    Class cy = c.getSuperclass();
	Object o = null;
	try {
		// get constructor object
		// can also use Integer.TYPE instead of int.class
		Constructor cons = cy.getDeclaredConstructor(int.class);
		// call the newInstance(i) using the constructor object
		o = cons.newInstance(3);
	} catch(NoSuchMethodException e) {
		System.out.println("Couldn't find the constructor");
	} catch(SecurityException e) {
		System.out.println("SecurityException: " + e);
	} catch(InstantiationException e) {
		System.out.println("Couldn't create the instance");
	} catch(IllegalAccessException e) {
		System.out.println(e);
	} catch(InvocationTargetException e) {
		System.out.println(e);
	}
    printInfo(o.getClass());
  }
} ///:~
