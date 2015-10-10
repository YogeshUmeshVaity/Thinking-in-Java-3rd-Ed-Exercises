/* Test whether overriden methods can be overloaded.
 * The answer is no : An overridden method would have the exact
 * same method name, return type, number of parameters, and types 
 * of parameters as the method in the parent class, and the only 
 * difference would be the definition of the method.
 */

class A {
  public void add() {
    System.out.println("add()");
  }
}

class B extends A {
  // error : method does not override or implement a method from 
  // a supertype
  @Override 
  public void add(int a, int b) {
    System.out.println("add(int a, int b");
  }
  @Override
  public void add(float a, float b) {
    System.out.println("add(float a, float b)");
  }
}

public class OverrideOverload {
  public static void main(String[] args) {
    B b = new B();
    b.add(3, 6);
    b.add(3.6f, 3.9f);
  }
}
