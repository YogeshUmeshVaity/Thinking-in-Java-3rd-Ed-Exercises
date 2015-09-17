import java.util.*;

public class WithTimer {
  public static void main(String[] args) {
    final int NUMBER_OF_OBJECTS = 10000;
    final long delayTime = 30;
    for(int i = 0; i < NUMBER_OF_OBJECTS; i++) {
      final int TEMP_I = i;
      new Timer(true).schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println("Task " + TEMP_I 
          + " in Progress...");
          int x = 9, y = 36;
          int z = 0;
          z = x * y;
          return;
        }
      }, delayTime);
    }
    /**
     * Make the main() sleep for a while so the daemon threads
     * get some time to complete their tasks
     */
    try {
      Thread.sleep(9000);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
