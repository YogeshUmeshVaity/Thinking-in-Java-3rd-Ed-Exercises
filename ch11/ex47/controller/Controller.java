//: c08:controller:Controller.java
// With Event, the generic framework for control systems.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This is the actual control framework
// that manages and fires events.
package TIJEx.Ch11.ex47.controller;
import java.util.*;

public class Controller {
  // An object from java.util to hold Event objects:
  private List eventList = new LinkedList();
  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
    while(eventList.size() > 0) {
	  Iterator it = eventList.iterator();
	  // Throws ConcurrentModificationException because
	  // the list is being modified also from other part of the program.
	  // fail fast mechanism of iterators takes place
      while(it.hasNext()) {
        Event e = (Event)it.next();
        if(e.ready()) {
          System.out.println(e);
          e.action();
          it.remove();
        }
      }
    }
  }
} ///:~
