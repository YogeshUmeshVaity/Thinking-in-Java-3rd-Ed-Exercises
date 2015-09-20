/* 
 * Change DiningPhilosophers.java so that the philosophers just 
 * pick the next available chopstick (when a philosopher is done 
 * with their chopsticks, they drop them into a bin. When a 
 * philosopher wants to eat, they take the next two available 
 * chopsticks from the bin). Does this eliminate the possibility 
 * of deadlock? Can you re-introduce deadlock by simply reducing 
 * the number of available chopsticks?
 */
 
import java.util.*;

class Chopstick {
  private static int counter = 0;
  private int number = counter++;
  public String toString() {
    return "Chopstick " + number;
  }
}

class Philosopher extends Thread {
  private static Random rand = new Random();
  private static int counter = 0;
  private int number = counter++;
  private Chopstick leftChopstick;
  private Chopstick rightChopstick;
  static int ponder = 0; // Package access
  public Philosopher(Chopstick left, Chopstick right) {
    leftChopstick = left;
    rightChopstick = right;
    start();
  }
  public void think() {
    System.out.println(this + " thinking");
    if(ponder > 0)
      try {
        sleep(rand.nextInt(ponder));
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
  }
  public void eat() {
    synchronized(leftChopstick) {
      System.out.println(this + " has "
        + this.leftChopstick + " Waiting for "
        + this.rightChopstick);
      synchronized(rightChopstick) {
        System.out.println(this + " eating");
      }
    }
  }
  public String toString() {
    return "Philosopher " + number;
  }
  public void run() {
    while(true) {
      think();
      eat();
    }
  }
}

public class DiningPhilosophers {
  public static void main(String[] args) {
    if(args.length < 3) {
      System.err.println("usage:\n" +
        "java DiningPhilosophers numberOfPhilosophers " +
        "ponderFactor deadlock timeout\n" +
        "A nonzero ponderFactor will generate a random " +
        "sleep time during think().\n" +
        "If deadlock is not the string " +
        "'deadlock', the program will not deadlock.\n" +
        "A nonzero timeout will stop the program after " +
        "that number of seconds.");
      System.exit(1);
    }
    Philosopher[] philosopher =
      new Philosopher[Integer.parseInt(args[0])];
    Philosopher.ponder = Integer.parseInt(args[1]);
    Chopstick
      left = new Chopstick(),
      right = new Chopstick(),
      first = left;
    int i = 0;
    while(i < philosopher.length - 1) {
      philosopher[i++] =
        new Philosopher(left, right);
      left = right;
      right = new Chopstick();
    }
    if(args[2].equals("deadlock"))
      philosopher[i] = new Philosopher(left, first);
    else // Swapping values prevents deadlock:
      philosopher[i] = new Philosopher(first, left);
    // Optionally break out of program:
    if(args.length >= 4) {
      int delay = Integer.parseInt(args[3]);
      if(delay != 0)
        new Timeout(delay * 1000, "Timed out");
    }
  }
} ///:~
