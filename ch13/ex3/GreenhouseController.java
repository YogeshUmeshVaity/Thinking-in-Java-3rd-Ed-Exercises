//: c08:GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class GreenhouseController {
  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    //gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
      gc.new ThermostatNight(),
      gc.new LightOn(),
      gc.new LightOff(),
      gc.new WaterOn(),
      gc.new WaterOff(),
      gc.new ThermostatDay(),
	    gc.new FanOn(),
	    gc.new FanOff(),
	    gc.new Bell()
    };
    //gc.addEvent(gc.new Restart(2000, eventList));
    GreenhouseControls.Startup st = gc.new Startup(eventList);
//    if(args.length == 1)
//      gc.addEvent(
//        gc.new Terminate(Integer.parseInt(args[0])));
    gc.run();
  }
} ///:~
