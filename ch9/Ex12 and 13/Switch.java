//: c09:Switch.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
public class Switch {
  private boolean state = false;
  public boolean read() { return state; }
  public void on() {
	  state = true;
	  System.out.println("Switch State: " + read());
	}
  public void off() {
	  state = false;
	  System.out.println("Switch State: " + read());
	}
} ///:~