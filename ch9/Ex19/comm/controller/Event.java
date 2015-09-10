//: c08:controller:Event.java
// The common methods for any control event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This control framework
package Ex19.comm.controller;
import Ex19.comm.controller.*;
public abstract class Event {
  private long eventTime;
  protected final long delayTime;
  public Event(long delayTime) throws EventException {
	  //if(delayTime == 0) throw new EventException();
    this.delayTime = delayTime;
    start();
  }
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void action() throws ActionException;
} ///:~