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
  private Chopstick[] allChopSticks;
  static int ponder = 0; // Package access
  // has references to all chopsticks
  public Philosopher(List allChopSticks) {
    this.allChopSticks = allChopSticks;
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
    // philosopher will get lock on Arraylist,
    //  then get 2 chopsticks, remove them from bin
    // as soon as he gets total 2 chopsticks, display eating msg
    // and return the eat method so that he won't try to get lock
    // on all chopsticks.
    // the return point should be after synchronized block
    List chopstickList = new Arraylist(); // stores 2 chopsticks
    // Get chopsticks from bin
    System.out.println(this + 
    " needs to eat, waiting for chopsticks...");
    //int availableChopsticks = chopstickList.size();
    while(chopstickList.size() < 2) {
      synchronized(allChopSticks) {
        if(!allChopSticks.isEmpty()) {
          chopstickList.add(allChopSticks.remove(1));
          if(chopstickList.size() == 1) {
            System.out.println(this + " has a chopstick" + 
            "waiting for another...");
          }
        }
      }
      // so that others have chance to put chopsticks back
      yield(); 
    }
    System.out.println(this + " eating");
    try {
      sleep(600); // time to eat
    } catch (InterruptedException e) {
      System.out.println("Philosopher's eat sleep interrupted.");
      throw new RuntimeException(e);
    }
    // put chopsticks back into bin after eating
    synchronized(allChopSticks) {
      Iterator it = chopstickList.iterator();
      while(it.hasNext()) {
        allChopSticks.add(it.next());
        it.remove();
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
