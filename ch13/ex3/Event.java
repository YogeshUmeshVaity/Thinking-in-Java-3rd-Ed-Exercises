//: c08:controller:Event.java
// The common methods for any control event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This control framework

public abstract class Event extends Thread {
  private long eventTime;
  protected final long delayTime;
  public Event(long delayTime) {
    this.delayTime = delayTime;
    startEvent();
  }
  public void startEvent() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void run();
} ///:~
