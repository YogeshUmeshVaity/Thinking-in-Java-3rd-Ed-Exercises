/* Inherit from java.util.Logging.Level and define your own level 
 * with a value less than FINEST. Modify LoggingLevels.java to 
 * use your new level and show that messages at your level will 
 * not appear when the logging level is FINEST.
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
    lgr.setLevel(LessThanFinest.LESS_THAN_FINEST);
    lgr.finest("com : info");
    lgr2.finest("com.bruceeckel : info");
    util.finest("util : info");
    test.finest("test : severe");
    rand.finest("random : info");
    System.out.println(lgr.getLevel());
  }
  public static void main(String[] args) {
    logMessages();
  }
}


class LessThanFinest extends Level {

  protected LessThanFinest() {
    super("LESS_THAN_FINEST", 291);
  }
  
  public static final LessThanFinest LESS_THAN_FINEST = 
    new LessThanFinest();
  
}
