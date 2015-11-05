/* Demonstrate a second level of aliasing. Create a method that 
 * takes a reference to an object but doesn’t modify that 
 * reference’s object. However, the method calls a second method, 
 * passing it the reference, and this second method does modify 
 * the object.
 */
 
class TestRef {
  private int x = 5;
  
  public void increment() {
    x++;
  }
  
  @Override
  public String toString() {
    return Integer.toString(x);
  }
  
}

public class SecondLevelAlias {

  public void first(TestRef tr) {
    System.out.println("Inside first(), tr is " + tr);
    second(tr);
  }
  
  public void second(TestRef tr) {
   // modify the value
   tr.increment();
   System.out.println("Inside second(), tr is " + tr);
  }
  
  public static void main(String[] args) {
    TestRef tr = new TestRef();
    SecondLevelAlias changeTr = new SecondLevelAlias();
    System.out.println("Before call, tr is " + tr);
    changeTr.first(tr);
  }
  
}
