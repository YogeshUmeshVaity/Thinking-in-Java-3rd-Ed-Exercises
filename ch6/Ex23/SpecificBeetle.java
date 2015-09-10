//: c06:Beetle.java
// The full process of initialization.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
class Insect {
  private int i = 9;
  protected int j;
  Insect() {
    System.out.println("i = " + i + ", j = " + j);
    j = 39;
  }
  private static int x1 =
    print("static Insect.x1 initialized");
  static int print(String s) {
    System.out.println(s);
    return 47;
  }
}

class Beetle extends Insect {
  private int k = print("Beetle.k initialized");
  private int l;
  public Beetle() {
    System.out.println("k = " + k);
    System.out.println("j = " + j);
	l = print("Beetle.l in the constructor is initialized");
  }
  private static int x2 =
    print("static Beetle.x2 initialized");
}

public class SpecificBeetle extends Beetle {
	private int m = print("SpecificBeetle.m initialized");
	private int n;
	public SpecificBeetle() {
		System.out.println("m = " + m);
		System.out.println("n = " + n);
		n = print("SpecificBeetle.n in the constructor is initialized");
	}
	private static int x3 = print("static SpecificBeetle.x3 initialized");
	public static void main(String[] args) {
		System.out.println("SpecificBeetle constructor");
		SpecificBeetle sb = new SpecificBeetle();
	}
}
// first it loads all the classes.
// then initializes the static variables. root class -> base class -> derived class
// then the lines in the main method.
// then non static variables initializing takes place. written order : from root class to derived class.
// then constructors. derived -> base class -> root class

//Detailed Explaination : 
/**
* When you run java SpecificBeetle, you try to access SpecificBeetle.main(), as static method.
* The loader goes out and finds the compiled code for SpecificBeetle which in SpecificBeetle.class.
* It sees that SpecificBeetle is derived from Beetle(by extend keyword), it then loads Beetle.class.
* If the base class(Beetle in this case) has a base class(Insect class here), that second base class is then loaded and so on.
* Next, the static initialization takes place, in the order root class to derived class.
* Here statics x1, x2, x3 are intialized in this order.
* At this point all the necessary classes are loaded, so object can be created.
* Next, all the primitives are set to their default values, and object references are set to null.
* Here, i, j, k, l, m, n are set to their default values.
* Then the at new SpecificBeetle(); , the constructor of the root class(Insect) will be called and executed.
* Next, the constructor of the base class(Beetle) will be called and executed.
* Then, finally the constructor of the derived class well called and executed and so on.
*/

