/* Create a class containing a static clause that throws an 
 * exception if assertions are not enabled. Demonstrate that this 
 * test works correctly.
 * Modify the preceding exercise to use the approach in 
 * LoaderAssertions.java to turn on assertions instead of 
 * throwing an exception. Demonstrate that this works correctly.
 */
 
public class StaticAssertion {
  
  public static void main(String[] args) {
    ClassLoader.getSystemClassLoader()
      .setDefaultAssertionStatus(true);
    Assertion a = new Assertion();
  }
  
}

class Assertion {
  static {
    boolean assertionsEnabled = false;
    // Note intentional side effect of assignment:
    assert assertionsEnabled = true;
    if (!assertionsEnabled)
      throw new RuntimeException("Assertions disabled");
  }
}
