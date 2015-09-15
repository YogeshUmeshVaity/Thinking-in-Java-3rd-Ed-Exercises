//: c08:GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This is the implementation of the control framework
import com.bruceeckel.simpletest.*;
import java.util.*;

public class GreenhouseControls extends Controller {
  private Random rnd = new Random();
  private boolean light = false;
  public class LightOn extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here to
      // physically turn on the light.
      light = true;
      System.out.println("Light is on");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() { return "Light is on"; }
  }
  public class LightOff extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here to
      // physically turn off the light.
      light = false;
      System.out.println("Light is on");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() { return "Light is off"; }
  }
  private boolean water = false;
  public class WaterOn extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here.
      water = true;
      System.out.println("Greenhouse water is on");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() {
      return "Greenhouse water is on";
    }
  }
  public class WaterOff extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here.
      water = false;
      System.out.println("Greenhouse water is off");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() {
      return "Greenhouse water is off";
    }
  }
  private String thermostat = "Day";
  public class ThermostatNight extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here.
      thermostat = "Night";
      System.out.println("Thermostat on night setting");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() {
      return "Thermostat on night setting";
    }
  }
  public class ThermostatDay extends Event {
    public void run() {
     while(true) {
      // Put hardware control code here.
      thermostat = "Day";
      System.out.println("Thermostat on day setting");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() {
      return "Thermostat on day setting";
    }
  }
  boolean fan = false;
  public class FanOn extends Event {
	 public void run() {
	  while(true) {
		 // Hardware control to turn on fan here...
		 fan = true;
		 System.out.println("Fan is on");
		 try {
           sleep(rnd.nextInt(3000));
           } catch(InterruptedException e) {
             throw new RuntimeException();
           }
	     }
	 }
	 public String toString() { return "Fan is on";}
  }
  public class FanOff extends Event{
	 public void run() {
	  while(true) {
		 // Hardware control to turn off fan here...
		 fan = false;
		 System.out.println("Fan is off");
		 try {
           sleep(rnd.nextInt(3000));
           } catch(InterruptedException e) {
           throw new RuntimeException();
         }
	  }
	 }
	 public String toString() { return "Fan is off";}
  }
  public class Bell extends Event {
    public void run() {
     while(true) {
      System.out.println("Bing!");
      try {
        sleep(rnd.nextInt(3000));
      } catch(InterruptedException e) {
        throw new RuntimeException();
      }
     }
    }
    public String toString() { return "Bing!"; }
  }
//  public class Restart extends Event {
//    private Event[] eventList;
//    public Restart(long delayTime, Event[] eventList) {
//      super(delayTime);
//      this.eventList = eventList;
//      for(int i = 0; i < eventList.length; i++)
//        addEvent(eventList[i]);
//    }
//    public void run() {
//      for(int i = 0; i < eventList.length; i++) {
//        eventList[i].startEvent(); // Rerun each event
//        addEvent(eventList[i]);
//      }
//      startEvent(); // Rerun this Event
//      //addEvent(this);
//    }
//    public String toString() {
//      return "Restarting system";
//    }
//  }
  public class Startup {
    private Event[] eventList;
    public Startup(Event[] eventList) {
      this.eventList = eventList;
      for(int i = 0; i < eventList.length; i++) {
        addEvent(eventList[i]);
      }
    }
  }
  public class Terminate extends Event {
    public void run() {
      System.out.println("Terminating"); 
      System.exit(0);
    }
    public String toString() { return "Terminating";  }
  }
} ///:~
