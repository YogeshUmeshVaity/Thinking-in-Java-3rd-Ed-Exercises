//: c10:Shapes.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Shape {
  void draw() { System.out.println(this + ".draw()");
  }
  public void rotate() {
  }
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
  public void rotate() {
	  System.out.println("Square rotated");
  }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
  public void rotate() {
	  System.out.println("Triangle rotated");
  }
}

public class Shapes {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    // Array of Object, not Shape:
    Object[] shapeList = {
      new Circle(),
      new Square(),
      new Triangle(),
	  new Square(),
	  new Triangle(),
	  new Circle(),
	  new Circle(),
	  new Triangle()
    };
	// rotate shapes
    for(int i = 0; i < shapeList.length; i++)
		// use RTTI to identify Circle reference
		if(!(shapeList[i] instanceof Circle))
			((Shape)shapeList[i]).rotate();
  }
} ///:~
