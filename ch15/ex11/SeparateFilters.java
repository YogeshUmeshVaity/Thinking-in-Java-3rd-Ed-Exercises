/* Write an example using Handlers and Filters to log messages 
 * with any severity level over INFO in one file and any severity 
 * level including and below INFO in other file. The files should 
 * be written in simple text.
 */
 
import java.util.logging.*;

public class SeparateFilters {
  public static void main(String[] args) throws Exception {
    Logger logger = Logger.getLogger("SeparateFilters");
    FileHandler aboveInfoHandler = 
      new FileHandler("AboveInfo.txt");
    aboveInfoHandler.setFormatter(new SimpleFormatter());
    aboveInfoHandler.setFilter(new Filter() {
      @Override
      public boolean isLoggable(LogRecord record) {
        Object[] params = record.getParameters();
        //if(params == null) return true;
        Level level = record.getLevel();
        if(level.intValue() > 800)
          return true;
        return false;
      }
    });
    
    FileHandler belowInfoHandler = 
      new FileHandler("BelowInfo.txt");
    belowInfoHandler.setFormatter(new SimpleFormatter());
    belowInfoHandler.setFilter(new Filter() {
      @Override
      public boolean isLoggable(LogRecord record) {
        Level level = record.getLevel();
        if(level.intValue() <= 800) 
          return true;
        return false;
      }
    });
    logger.addHandler(belowInfoHandler);
    logger.addHandler(aboveInfoHandler);
    logger.log(Level.WARNING, "This is a Warning");
    logger.log(Level.INFO, "This is an info");
  }
}
