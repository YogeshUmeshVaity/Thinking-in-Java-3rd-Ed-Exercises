/* In LoggingLevels.java, comment out the code that sets the 
 * severity level of the root logger handlers and verify that 
 * messages of level CONFIG and below are not reported.
 */
 
import com.bruceeckel.simpletest.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.LogManager;

public class LoggingLevels {
  private static Test monitor = new Test();
  private static Logger
    lgr = Logger.getLogger("com"),
    lgr2 = Logger.getLogger("com.bruceeckel"),
    util = Logger.getLogger("com.bruceeckel.util"),
    test = Logger.getLogger("com.bruceeckel.test"),
    rand = Logger.getLogger("random");
  private static void logMessages() {
    lgr.info("com : info");
    lgr2.fine("com.bruceeckel : info");
    util.warning("util : info");
    test.severe("test : severe");
    rand.info("random : info");
  }
  public static void main(String[] args) {
//    lgr.setLevel(Level.SEVERE);
//    System.out.println("com level: SEVERE");
    logMessages();
    util.setLevel(Level.CONFIG);
    test.setLevel(Level.CONFIG);
    rand.setLevel(Level.CONFIG);
    System.out.println("individual loggers set to CONFIG");
    logMessages();
    lgr.setLevel(Level.SEVERE);
    System.out.println("com level: SEVERE");
    logMessages();
//    monitor.expect("LoggingLevels.out");
  }
} ///:~
