//: c08:controller:Controller.java
// With Event, the generic framework for control systems.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This is the actual control framework
// that manages and fires events.

import java.util.*;

public class Controller {
  // An object from java.util to hold Event objects:
  private List eventList = new ArrayList();
  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
      for(int i = 0; i < eventList.size(); i++) {
        Event e = (Event)eventList.get(i);
          e.start();
      }
  }
} ///:~
