//: c10:Shapes.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

class Shape {
  boolean flag = false;
  void draw() { System.out.println(this + ".draw()"); }
  void highlight() {
	  this.flag = true;
  }
  String showState() {
	  if(flag == true)
		  return " Highlighted";
	  else
		  return "";
  }
}

class Circle extends Shape {
  boolean flag = false;
  void highlight() {
	  this.flag = true;
  }
  String showState() {
	  if(flag == true)
		  return " Highlighted";
	  else
		  return "";
  }
  public String toString() { return "Circle" + showState(); }
}

class Square extends Shape {
  boolean flag = false;
  void highlight() {
	  this.flag = true;
  }
  String showState() {
	  if(flag == true)
		  return " Highlighted";
	  else
		  return "";
  }
  public String toString() { return "Square" + showState(); }
}

class Triangle extends Shape {
  boolean flag = false;
  void highlight() {
	  this.flag = true;
  }
  String showState() {
	  if(flag == true)
		  return " Highlighted";
	  else
		  return "";
  }
  public String toString() { return "Triangle" + showState(); }
}

public class Shapes {
  public static void main(String[] args) {
    // Array of Object, not Shape:
    Object[] shapeList = {
      new Circle(),
      new Square(),
      new Triangle(),
	  new Circle(),
	  new Triangle()
    };
	// Highlight the shape Triangle
    for(int i = 0; i < shapeList.length; i++) {
		// highlights only the objects in shapeList
		if(shapeList[i] instanceof Triangle) ((Triangle)shapeList[i]).highlight();
		((Shape)shapeList[i]).draw(); // Must cast
	}
    Shape t = new Triangle();
	System.out.println("t : ");
	t.draw();
  }
} ///:~
