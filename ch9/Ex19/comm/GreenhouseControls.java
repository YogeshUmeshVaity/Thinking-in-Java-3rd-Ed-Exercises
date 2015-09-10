//: c08:GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This is the implementation of the control framework
//import com.bruceeckel.simpletest.*;
package Ex19.comm;
import Ex19.comm.controller.*;
//import Ex19.comm.exceptions.*;

public class GreenhouseControls extends Controller {
  //private static Test monitor = new Test();
  private boolean light = false;
  public class LightOn extends Event {
    public LightOn(long delayTime) throws EventException { super(delayTime); }
    public void action() throws ActionException {
      // Put hardware control code here to
      // physically turn on the light.
      light = true;
    }
    public String toString() { return "Light is on"; }
  }
  public class LightOff extends Event {
    public LightOff(long delayTime) throws EventException { super(delayTime); }
    public void action() throws ActionException {
      // Put hardware control code here to
      // physically turn off the light.
      light = false;
    }
    public String toString() { return "Light is off"; }
  }
  private boolean water = false;
  public class WaterOn extends Event {
    public WaterOn(long delayTime) throws EventException { super(delayTime); }
    public void action() throws ActionException {
      // Put hardware control code here.
      water = true;
	  throw new ActionException();
    }
    public String toString() {
      return "Greenhouse water is on";
    }
  }
  public class WaterOff extends Event {
    public WaterOff(long delayTime) throws EventException { super(delayTime); }
    public void action() throws ActionException {
      // Put hardware control code here.
      water = false;
    }
    public String toString() {
      return "Greenhouse water is off";
    }
  }
  private String thermostat = "Day";
  public class ThermostatNight extends Event {
    public ThermostatNight(long delayTime) throws EventException {
      super(delayTime);
    }
    public void action() throws ActionException {
      // Put hardware control code here.
      thermostat = "Night";
    }
    public String toString() {
      return "Thermostat on night setting";
    }
  }
  public class ThermostatDay extends Event {
    public ThermostatDay(long delayTime) throws EventException {
      super(delayTime);
    }
    public void action() throws ActionException {
      // Put hardware control code here.
      thermostat = "Day";
    }
    public String toString() {
      return "Thermostat on day setting";
    }
  }
  boolean fan = false;
  public class FanOn extends Event{
	 FanOn(long delayTime) throws EventException { super(delayTime);}
	 public void action() throws ActionException {
		 // Hardware control to turn on fan here...
		 fan = true;
	 }
	 public String toString() { return "Fan is on";}
  }
  public class FanOff extends Event{
	 FanOff(long delayTime) throws EventException { super(delayTime);}
	 public void action() throws ActionException {
		 // Hardware control to turn off fan here...
		 fan = false;
	 }
	 public String toString() { return "Fan is off";}
  }
  // An example of an action() that inserts a
  // new one of itself into the event list:
  public class Bell extends Event {
    public Bell(long delayTime) throws EventException { super(delayTime); }
    public void action() throws ActionException {
      try {
		  addEvent(new Bell(delayTime));
	  } catch(EventException ee) {
		  System.out.println("Caught EventException: " + ee);
	  }
    }
    public String toString() { return "Bing!"; }
  }
  public class Restart extends Event {
    private Event[] eventList;
    public Restart(long delayTime, Event[] eventList) throws EventException {
      super(delayTime);
      this.eventList = eventList;
      for(int i = 0; i < eventList.length; i++)
        addEvent(eventList[i]);
    }
    public void action() {
      for(int i = 0; i < eventList.length; i++) {
        eventList[i].start(); // Rerun each event
        addEvent(eventList[i]);
      }
      start(); // Rerun this Event
      addEvent(this);
    }
    public String toString() {
      return "Restarting system";
    }
  }
  public class Terminate extends Event {
    public Terminate(long delayTime) throws EventException { super(delayTime); }
    public void action() { System.exit(0); }
    public String toString() { return "Terminating";  }
  }
} ///:~
