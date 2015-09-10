//: c08:GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
//import ex17.controller.*;

import java.util.*;
import java.io.*;

public class GreenhouseController {
  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    // Instead of hard-wiring, we are parsing
    // configuration information from a text file here:
    Map map = new HashMap();
    try {
        BufferedReader in = new BufferedReader(new FileReader("Data.txt"));
        String s;
        while ((s = in.readLine()) != null) {
            String[] entry = s.split(" ");
            map.put(entry[0], entry[1]);
        }
        in.close();
    } catch (FileNotFoundException fnf) {
        System.out.println("Cannot find the file" + fnf);
    } catch (IOException io) {
        System.out.println(io);
    }
    Set keySet = map.keySet();
    Event[] eventList = new Event[map.size()];
    Iterator it = keySet.iterator();
    int index = 0;
    while (it.hasNext()) {
        Object key = it.next();
        Object value = map.get(key);
        String eventName = (String)key;
        String timeValue = (String)value;
        long eventTime = Long.valueOf(timeValue).longValue();
        eventList[index] = Event.factory(eventName, eventTime);
        index++;
    }
    gc.addEvent(gc.new Restart(2000, eventList));
    if(args.length == 1)
      gc.addEvent(
        gc.new Terminate(Integer.parseInt(args[0])));
    gc.run();
  }
} ///:~
