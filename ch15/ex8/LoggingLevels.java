//: c15:LoggingLevels.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.FileHandler;
import java.io.*;

public class LoggingLevels {
  private static Test monitor = new Test();
  private static Logger
    lgr = Logger.getLogger("com"),
    lgr2 = Logger.getLogger("com.bruceeckel"),
    util = Logger.getLogger("com.bruceeckel.util"),
    test = Logger.getLogger("com.bruceeckel.test"),
    rand = Logger.getLogger("random");
  private static void logMessages() {
    try {
      FileHandler handlerSevere = new FileHandler("Severe.xml");
      FileHandler handlerInfo = new FileHandler("Info.xml");
      handlerSevere.setLevel(Level.SEVERE);
      handlerInfo.setLevel(Level.INFO);
      lgr.addHandler(handlerSevere);
      lgr.addHandler(handlerInfo);
      
    } catch(IOException e) {
      throw new RuntimeException(e);
    }    
    lgr.info("com : info");
    lgr2.info("com.bruceeckel : info");
    util.info("util : info");
    test.severe("test : severe");
    rand.info("random : info");
  }
  public static void main(String[] args) {
    lgr.setLevel(Level.SEVERE);
    System.out.println("com level: SEVERE");
    logMessages();
    util.setLevel(Level.FINEST);
    test.setLevel(Level.FINEST);
    rand.setLevel(Level.FINEST);
    System.out.println("individual loggers set to FINEST");
    logMessages();
    lgr.setLevel(Level.SEVERE);
    System.out.println("com level: SEVERE");
    logMessages();
  }
} ///:~
