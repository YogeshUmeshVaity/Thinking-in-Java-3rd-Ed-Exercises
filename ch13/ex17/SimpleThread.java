/* 
 * Modify SimpleThread.java so that all threads receive an 
 * interrupt() before they are completed.
 */

public class SimpleThread extends Thread {
  private int countDown = 5;
  private static int threadCount = 0;
  public SimpleThread() {
    super("" + ++threadCount); // Store the thread name
    start();
  }
  public String toString() {
    return "#" + getName() + ": " + countDown;
  }
  @Override
  public void run() {
    while(true) {
      System.out.println(this);
      if(--countDown == 0) return;
      if(this.isInterrupted()) { return; }
    }
  }
  public static void main(String[] args) {
    Thread[] threads = new Thread[5];
    for(int i = 0; i < threads.length; i++) {
      threads[i] = new SimpleThread();
      threads[i].interrupt();
    }
  }
} ///:~
