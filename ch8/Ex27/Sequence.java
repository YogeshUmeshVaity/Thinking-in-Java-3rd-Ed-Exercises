//: c08:Sequence.java
// Holds a sequence of Objects.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
//import com.bruceeckel.simpletest.*;

interface Selector {
  boolean end();
  Object current();
  void next();
}

public class Sequence {
  //private static Test monitor = new Test();
  private Object[] objects;
  private int next = 0;
  public Sequence(int size) { objects = new Object[size]; }
  public void add(Object x) {
    if(next < objects.length)
      objects[next++] = x;
  }
  private class SSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == objects.length; }
    public Object current() { return objects[i]; }
    public void next() { if(i < objects.length) i++; }
  }
  public Selector getSelector() { return new SSelector(); }
  private class RSelector implements Selector {
	  private int x = objects.length;
	  public boolean end() { return x == 0;}
	  // while going reverse you need to do x - 1 because
	  // ojbects.length=10 and the upper bound array is objects[9]
	  // otherwise compiler will give ArrayOutOfBound error
	  public Object current() { return objects[x - 1]; }
	  public void next() { if(x > 0) x--; }
  }
  public Selector getRSelector() { return new RSelector(); }
  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.getSelector();
    while(!selector.end()) {
      System.out.println(selector.current());
      selector.next();
    }
	System.out.println(); // separator at output
	Selector rSelector = sequence.getRSelector();
	while(!rSelector.end()) {
	System.out.println(rSelector.current());
	rSelector.next();
	}
   /*  monitor.expect(new String[] {
      "0",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9"
    }); */
  }
} ///:~