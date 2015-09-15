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
  private final long DELAY_TIME;
  public LightOn(long delayTime) { this.DELAY_TIME = delayTime; }
    public void run() {
      // Put hardware control code here to
      // physically turn on the light.
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if(!light) {
            light = true;
            System.out.println("Light is on");
          }          
        }
      }, DELAY_TIME, 2100);
    }
    public String toString() { return "Light is on"; }
  }
  public class LightOff extends Event {
    private final long DELAY_TIME;
    public LightOff(long delayTime) { this.DELAY_TIME = 
    delayTime; }
    public void run() {
      // Put hardware control code here to
      // physically turn off the light.
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if(light) {
            light = false;
            System.out.println("Light is off");
          }
        } 
      }, DELAY_TIME, 2100);
      
    }
    public String toString() { return "Light is off"; }
  }
  private boolean water = false;
  public class WaterOn extends Event {
  private final long DELAY_TIME;
  public WaterOn(long delayTime) { this.DELAY_TIME = delayTime; }
    public void run() {
      // Put hardware control code here.
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if(!water) {
            water = true;
            System.out.println("Greenhouse water is on");
          }
        }
      }, DELAY_TIME, 2100);
    }
    public String toString() {
      return "Greenhouse water is on";
    }
  }
  public class WaterOff extends Event {
  private final long DELAY_TIME;
  public WaterOff(long delayTime) { this.DELAY_TIME = 
  delayTime; }
    public void run() {
      // Put hardware control code here.
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if(water) {
            water = false;
            System.out.println("Greenhouse water is off");
          }
        }
      }, DELAY_TIME, 2100);
    }
    public String toString() {
      return "Greenhouse water is off";
    }
  }
  private String thermostat = "Day";
  public class ThermostatNight extends Event {
  private final long DELAY_TIME;
  public ThermostatNight(long delayTime) { this.DELAY_TIME = 
  delayTime; }
    public void run() {
      // Put hardware control code here.
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() { 
        @Override
        public void run() {
          if(thermostat.equals("Day")) {
            thermostat = "Night";
            System.out.println("Thermostat on night setting");
          }
        }
      }, DELAY_TIME, 2100);
      
    }
    public String toString() {
      return "Thermostat on night setting";
    }
  }
  public class ThermostatDay extends Event {
  private final long DELAY_TIME;
  public ThermostatDay(long delayTime) { this.DELAY_TIME = 
  delayTime; }
    public void run() {
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if(thermostat.equals("Night")) {
            // Put hardware control code here.
            thermostat = "Day";
            System.out.println("Thermostat on day setting");
          }
        }
      }, DELAY_TIME, 21000);
    }
    public String toString() {
      return "Thermostat on day setting";
    }
  }
  boolean fan = false;
  public class FanOn extends Event {
  private final long DELAY_TIME;
  public FanOn(long delayTime) { this.DELAY_TIME = delayTime; }
	 public void run() {
	   Timer timer = new Timer();
	   timer.scheduleAtFixedRate(new TimerTask() {
	     @Override
	     public void run() {
		     if(!fan) {
		       // Hardware control to turn on fan here...
		       fan = true;
		       System.out.println("Fan is on");
		     }
	     }
	   }, DELAY_TIME, 2100);
	 }
	 public String toString() { return "Fan is on";}
  }
  public class FanOff extends Event{
   private final long DELAY_TIME;
   public FanOff(long delayTime) { this.DELAY_TIME = delayTime; }
	 public void run() {
		 Timer timer = new Timer();
		 timer.scheduleAtFixedRate(new TimerTask() {
		   @Override
		   public void run() {
		     if(fan) {
		       // Hardware control to turn off fan here...
		       fan = false;
		       System.out.println("Fan is off");
		     }
		   }
		 }, DELAY_TIME, 2100);
	 }
	 public String toString() { return "Fan is off";}
  }
  public class Bell extends Event {
  private final long DELAY_TIME;
  public Bell(long delayTime) { this.DELAY_TIME = delayTime; }
    public void run() {
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          System.out.println("Bing!");
        }
      }, DELAY_TIME, 2100);
    }
    public String toString() { return "Bing!"; }
  }
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
    private long sleepTime;
    public Terminate(long sleepTime) {
      this.sleepTime = sleepTime;
    }
    public void run() {
      try {
        sleep(sleepTime);
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Terminating"); 
      System.exit(0);
    }
    public String toString() { return "Terminating";  }
  }
} ///:~
