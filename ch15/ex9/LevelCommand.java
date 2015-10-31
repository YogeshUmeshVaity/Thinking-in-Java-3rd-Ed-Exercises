/* Write a simple program that sets the root logger logging level 
 * based on a command-line argument.
 */
 
import java.util.logging.*;

public class LevelCommand {
  public static void main(String[] args) {
    Logger lgr = Logger.getLogger("com");
    if(args.length < 1) {
      System.out.println("Usage : java LevelCommand LEVELNAME");
      System.out.println(
        "levelName should be without Level. text");
    }
    lgr.setLevel(Level.parse(args[0]));
    lgr.info("Info Level");
  }
}
