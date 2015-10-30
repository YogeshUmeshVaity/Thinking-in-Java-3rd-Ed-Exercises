/* Create a class containing a static clause that throws an 
 * exception if assertions are not enabled. Demonstrate that this 
 * test works correctly.
 */
 
public class StaticAssertion {
  static {
  boolean assertionsEnabled = false;
  // Note intentional side effect of assignment:
  assert assertionsEnabled = true;
  if (!assertionsEnabled)
    throw new RuntimeException("Assertions disabled");
  }
  
  public static void main(String[] args) {
    StaticAssertion sa = new StaticAssertion();
  }
}
