//: c10:Shapes.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
//import com.bruceeckel.simpletest.*;

class Shape {
  void draw() { System.out.println(this + ".draw()"); }
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
	public String toString() { return "Rhomboid"; }
}

public class Shapes {
  //private static Test monitor = new Test();
  public static void main(String[] args) {
    // Array of Object, not Shape:
    Object[] shapeList = {
      new Circle(),
      new Square(),
      new Triangle()
    };
    for(int i = 0; i < shapeList.length; i++)
      ((Shape)shapeList[i]).draw(); // Must cast
	Shape r = new Rhomboid(); // Upcasted
	System.out.println("Upcasted Rhomboid to Shape: ");
	r.draw();
	System.out.println("Downcasted Rhomboid back to Rhomboid : ");
	((Rhomboid)r).draw(); // Downcasted
	// Downcasting to Circle, 
	// Exception in thread "main"
	// java.lang.ClassCastException: Rhomboid cannot be cast to Circle
	((Circle)r).draw(); 
    /* monitor.expect(new String[] {
      "Circle.draw()",
      "Square.draw()",
      "Triangle.draw()"
    }); */
  }
} ///:~
