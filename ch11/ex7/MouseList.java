//: c11:MouseList.java
// A type-conscious List.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
// If inheritance is used instead of composition,
// The MouseList also gets all the fields and methods of
// ArrayList, so you can't make the MouseList to only accept
// the Mouse objects, so MouseList and also be used as ArrayList

public class MouseList extends ArrayList {
  public void add(Mouse m) { super.add(m); }
  public Mouse get(int index) {
    return (Mouse)super.get(index);
  }
  public int size() { return super.size(); }
} ///:~
