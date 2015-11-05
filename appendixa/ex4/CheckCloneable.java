/* Change CheckCloneable.java so that all of the clone( ) 
 * methods catch the CloneNotSupportedException rather than 
 * passing it to the caller.
 */

import com.bruceeckel.simpletest.*;

// Can't clone this because it doesn't override clone():
class Ordinary {}

// Overrides clone, but doesn't implement Cloneable:
class WrongClone extends Ordinary {
  public Object clone() {
    Object o = null;
    try {
      o = super.clone(); // Throws exception
    } catch(CloneNotSupportedException e) {
      System.out.println("Cannot clone WrongClone");
    }
    return o;
  }
}

// Does all the right things for cloning:
class IsCloneable extends Ordinary implements Cloneable {
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

// Turn off cloning by throwing the exception:
class NoMore extends IsCloneable {
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}

class TryMore extends NoMore {
  public Object clone() {
    // Calls NoMore.clone(), throws exception:
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("Cannot clone TryMore");
    }
    return o;
  }
}

class BackOn extends NoMore {
  private BackOn duplicate(BackOn b) {
    // Somehow make a copy of b and return that copy.
    // This is a dummy copy, just to make the point:
    return new BackOn();
  }
  public Object clone() {
    // Doesn't call NoMore.clone():
    return duplicate(this);
  }
}

// You can't inherit from this, so you can't override
// the clone method as you can in BackOn:
final class ReallyNoMore extends NoMore {}

public class CheckCloneable {
  private static Test monitor = new Test();
  public static Ordinary tryToClone(Ordinary ord) {
    String id = ord.getClass().getName();
    System.out.println("Attempting " + id);
    Ordinary x = null;
    if(ord instanceof Cloneable) {
      try {
        x = (Ordinary)((IsCloneable)ord).clone();
        System.out.println("Cloned " + id);
      } catch(CloneNotSupportedException e) {
        System.err.println("Could not clone " + id);
      }
    } else {
      System.out.println("Doesn't implement Cloneable");
    }
    return x;
  }
  public static void main(String[] args) {
    // Upcasting:
    Ordinary[] ord = {
      new IsCloneable(),
      new WrongClone(),
      new NoMore(),
      new TryMore(),
      new BackOn(),
      new ReallyNoMore(),
    };
    Ordinary x = new Ordinary();
    // This won't compile; clone() is protected in Object:
    //! x = (Ordinary)x.clone();
    // Checks first to see if a class implements Cloneable:
    for(int i = 0; i < ord.length; i++)
      tryToClone(ord[i]);
//    monitor.expect(new String[] {
//      "Attempting IsCloneable",
//      "Cloned IsCloneable",
//      "Attempting WrongClone",
//      "Doesn't implement Cloneable",
//      "Attempting NoMore",
//      "Could not clone NoMore",
//      "Attempting TryMore",
//      "Could not clone TryMore",
//      "Attempting BackOn",
//      "Cloned BackOn",
//      "Attempting ReallyNoMore",
//      "Could not clone ReallyNoMore"
//    });
  }
} ///:~
