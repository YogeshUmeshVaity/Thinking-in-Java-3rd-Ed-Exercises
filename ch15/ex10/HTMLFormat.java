/* Write an example using Formatters and Handlers to output a log 
 * file as HTML.
 */
 
import java.util.logging.*;
import java.io.*;

public class HTMLFormat {
  public static void main(String[] args) {
    Logger logger = Logger.getLogger("HTMLFormat");
    try {
      FileHandler handler = new FileHandler("Log.html");
      logger.addHandler(handler);
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    
    logger.info("HTMLFormat test");
  }
}
