//: c07:Shapes.java
// Polymorphism in Java.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
//import com.bruceeckel.simpletest.*;
import java.util.*;

class Shape {
  void draw() {}
  void erase() {}
  void printMessage() {
	  // Base class' method is called if it's not overloaded in derived classes.
	  System.out.println("Shape Message");
  }
}

class Circle extends Shape {
  void draw() {
    System.out.println("Circle.draw()");
  }
  void erase() {
    System.out.println("Circle.erase()");
  }
  void printMessage() {
	  // when overloaded in all classes, the method of that particular class is called,
	  // depending on the reference in the upcasting.
	  System.out.println("Circle Message");
  }
}

class Square extends Shape {
  void draw() {
    System.out.println("Square.draw()");
  }
  void erase() {
    System.out.println("Square.erase()");
  }
  void printMessage() {
	  System.out.println("Square Message");
  }
}

class Triangle extends Shape {
  void draw() {
    System.out.println("Triangle.draw()");
  }
  void erase() {
    System.out.println("Triangle.erase()");
  }
  void printMessage() {
	  // If it's overloaded in only one of the classes or few of the classes,
	  // the overloaded method is called for that class' object reference.
	  System.out.println("Triangle Message");
  }
}

// A "factory" that randomly creates shapes:
class RandomShapeGenerator {
  private Random rand = new Random();
  public Shape next() {
    switch(rand.nextInt(3)) {
      default:
      case 0: return new Circle(); // Upcasting happens here in the return statements.
      case 1: return new Square(); // i.e. the method returns Shape while the Circle, Square, Tringle are created.
      case 2: return new Triangle();
    }
  }
}

public class Shapes {
 // private static Test monitor = new Test();
  private static RandomShapeGenerator gen =
    new RandomShapeGenerator();
  public static void main(String[] args) {
    Shape[] s = new Shape[9];
    // Fill up the array with shapes:
    for(int i = 0; i < s.length; i++)
      s[i] = gen.next();
    // Make polymorphic method calls:
    for(int i = 0; i < s.length; i++) {
      s[i].draw();
	  s[i].printMessage();
	}
    /* monitor.expect(new Object[] {
      new TestExpression("%% (Circle|Square|Triangle)"
        + "\\.draw\\(\\)", s.length)
    }); */
  }
} ///:~
