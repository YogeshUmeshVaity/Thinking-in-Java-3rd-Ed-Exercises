// ex 5
import com.bruceeckel.simpletest.*;

public class SimpleThread extends Thread {
  private static Test monitor = new Test();
  private int countDown = 5;
  private static int threadCount = 0;
  public SimpleThread() {
    super("" + ++threadCount); // Store the thread name
    setDaemon(true);
    start();
  }
  public String toString() {
    return "#" + getName() + ": " + countDown;
  }
  public void run() {
    while(true) {
      System.out.println(this);
      if(--countDown == 0) return;
    }
  }
  public static void main(String[] args) {
    // need to set the value of i higher on faster computers
    // to see the result
    // when the thread is set to daemon, the program doesn't 
    // complete all 100 cycles
    /*The program ends as soon as the main() is able to exit */
    for(int i = 0; i < 100; i++)
      new SimpleThread();
  }
} ///:~
