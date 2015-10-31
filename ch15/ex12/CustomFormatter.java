package tijex.ch15.ex12;

import java.util.logging.*;

public class CustomFormatter extends Formatter {
  @Override
  public String format(LogRecord record) {
    return record.getLevel() + " : " +
    record.getSourceClassName() + " -:- " +
    record.getSourceMethodName() + " -:- " + 
    record.getMessage() + "\n";
  }
}
