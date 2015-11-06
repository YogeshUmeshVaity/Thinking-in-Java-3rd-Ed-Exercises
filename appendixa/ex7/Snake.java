/* Starting with Snake.java, create a deep-copy version of the 
 * snake.
 */
 
import com.bruceeckel.simpletest.*;

public class Snake implements Cloneable {
  private static Test monitor = new Test();
  private Snake next;
  private char c;
  // Value of i == number of segments
  public Snake(int i, char x) {
    c = x;
    if(--i > 0)
      next = new Snake(i, (char)(x + 1));
  }
  public void increment() {
    c++;
    if(next != null)
      next.increment();
  }
  public String toString() {
    String s = ":" + c;
    if(next != null)
      s += next.toString();
    return s;
  }
  public Object clone() {
    Snake o = null;
    try {
      o = (Snake)super.clone();
    } catch(CloneNotSupportedException e) {
      System.err.println("Snake can't clone");
    }
    if(o.next != null)
      o.next = (Snake)next.clone();
    return o;
  }
  public static void main(String[] args) {
    Snake s = new Snake(5, 'a');
    System.out.println("s = " + s);
    Snake s2 = (Snake)s.clone();
    System.out.println("s2 = " + s2);
    s.increment();
    System.out.println("after s.increment, s2 = " + s2);
    System.out.println("after s.increment, s = " + s);
//    monitor.expect(new String[] {
//      "s = :a:b:c:d:e",
//      "s2 = :a:b:c:d:e",
//      "after s.increment, s2 = :a:c:d:e:f"
//    });
  }
} ///:~
