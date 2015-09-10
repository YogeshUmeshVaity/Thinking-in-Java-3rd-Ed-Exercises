//: c07:Sandwich.java
// Order of constructor calls.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

interface FastFood {
	void showQuality();
	void showExpiryDate();
}

class Meal {
  int x1 = initiaze("x1 initialized");
  Meal() { System.out.println("Meal()"); }
  int x2 = initiaze("x2 initialized"); 
  int initiaze(String s) {
	  System.out.println(s);
	  return 3;
  }
}

class Bread {
  Bread() { System.out.println("Bread()"); }
}

class Cheese {
  Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
  Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
	int x3 = initiaze("x3 intitialized");
  Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() { System.out.println("PortableLunch()");}
  int x4 = initiaze("x4 intitialized");
}

public class Sandwich extends PortableLunch implements FastFood {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() {
    System.out.println("Sandwich()");
  }
  public void showQuality() {
	  System.out.println("High quality Sandwich");
  }
  public void showExpiryDate() {
	  System.out.println("1 day from manufacturing date");
  }
  public static void main(String[] args) {
    FastFood fs = new Sandwich();
	fs.showQuality();
	fs.showExpiryDate();
   /*  monitor.expect(new String[] {
      "Meal()",
      "Lunch()",
      "PortableLunch()",
      "Bread()",
      "Cheese()",
      "Lettuce()",
      "Sandwich()"
    }); */
  }
} ///:~

// Order of Constructor Calls :
/** When you drop the reference new Sandwich(),
1. Static variables in all classes in hierarchy are initialized first in written order.

2. Member variables in root class (meal) x1, x2 etc are initialiezed.
3. Body of the root class consturctor is called.

4.Member variables(x3 here) in derived class(Lunch) are intialized.
5.Body of the derived class(Lunch) is called.

6...same for the derived class PortableLunch(x4 here)...
7...same for the derived class PortableLunch...

8.In the end, Member variables(objects of Bread, Cheese, Lettuce in this case) are intialized.
9.Finally the constructor of the final derived class is called.
*/