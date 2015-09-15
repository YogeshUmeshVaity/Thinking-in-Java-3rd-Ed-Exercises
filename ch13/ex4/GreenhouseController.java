//: c08:GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.*;

public class GreenhouseController {
  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    //gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
      gc.new ThermostatNight(0), //0
      gc.new LightOn(200),
      gc.new LightOff(400),
      gc.new WaterOn(600), // 600
      gc.new WaterOff(800), // 800
      gc.new ThermostatDay(1400), // 1400
	    gc.new FanOn(1500), // 1500
	    gc.new FanOff(1600), // 1600
	    gc.new Bell(900) // 900
    };
    //gc.addEvent(gc.new Restart(2000, eventList));
    GreenhouseControls.Startup st = gc.new Startup(eventList);
    
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        gc.run();
      }
    }, 0);
    if(args.length == 1)
      gc.addEvent(gc.new Terminate(Integer.parseInt(args[0])));
  }
} ///:~
