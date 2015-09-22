/* Inherit a class from java.util.Timer and implement the 
 * requestStop( ) method as in Stopping.java.
 */
 
import java.util.*;

class CanStop extends Thread {
  // Must be volatile:
  private volatile boolean stop = false;
  private int counter = 0;
  public void run() {
    while(!stop && counter < 100000) {
      System.out.println(counter++);
    }
    if(stop)
      System.out.println("Detected stop");
  }
  public void requestStop() { stop = true; }
}

public class Stopping {
  public static void main(String[] args) {
    CanStop stoppable = new CanStop();
    stoppable.start();
    new StopTimer().requestStop(stoppable, 600);
  }
} ///:~

final class StopTimer extends Timer {
  public StopTimer() {
    super(true);
  }
  public void requestStop(final CanStop STOPPABLE, final long milliSeconds) {
    schedule(new TimerTask() {
      @Override
      public void run() {
        STOPPABLE.requestStop();
      }
    }, milliSeconds);
  }
}
