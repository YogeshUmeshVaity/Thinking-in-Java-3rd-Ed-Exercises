/* 
 * Change DiningPhilosophers.java so that the philosophers just 
 * pick the next available chopstick (when a philosopher is done 
 * with their chopsticks, they drop them into a bin. When a 
 * philosopher wants to eat, they take the next two available 
 * chopsticks from the bin). Does this eliminate the possibility 
 * of deadlock? Can you re-introduce deadlock by simply reducing 
 * the number of available chopsticks?
 
 
 * Conclusion : If philosophers are allowed to take 1 chopstick 
 * at a time, total 5 chopsticks
 
 * 1. java DiningPhilosophers 6 0  
 *    the program, deadlocks after a little while
 
 * 2. java DiningPhilosophers 5 0 
 *    same as above
 
 * 3. java DiningPhilosophers 5 600
 *    program doesn't deadlock but there is a possibility
 
 * Conclusion : If philosophers are allowed to take only 2
 * chopsticks at a time
 
 * 1. java DiningPhilosophers 5 0 
 *    this removes the possibility of the deadlock with 5 
 *    chopsticks
 
 * 2. java DiningPhilosophers 5 0
 *    no deadlock when reduced chopsticks to 4
 
 * 3. java DiningPhilosophers 5 0
 *    no deadlock when reduced chopsticks to 3
 
 * 4. java DiningPhilosophers 5 0
 *    no deadlock when reduced chopsticks to 2,
 *    so, deadlock cannot be reintroduced with reduced chopsticks
 *    
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
  private LinkedList allChopSticks;
  static int ponder = 0; // Package access
  // has references to all chopsticks
  public Philosopher(String name, LinkedList allChopSticks) {
    super(name);
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
    List chopstickList = new ArrayList(); // stores 2 chopsticks
    // Get chopsticks from bin
    System.out.println(this + 
    " needs to eat, waiting for chopsticks...");
    while(chopstickList.size() < 2) {
      synchronized(allChopSticks) {
        // Allow philosophers to take 1 chopstick at a time
      /*  if(!allChopSticks.isEmpty()) {
          chopstickList.add(allChopSticks.removeFirst());
          if(chopstickList.size() == 1) {
            System.out.println(this + " has a chopstick" + 
            "waiting for another...");
          }
        } */
        // Allow philosophers to take 2 chopsticks at a time
        if(allChopSticks.size() >= 2) {
          chopstickList.add(allChopSticks.removeFirst());
          chopstickList.add(allChopSticks.removeFirst());
        }
      }
      // so that others have chance to put chopsticks back
      yield();
    }
    System.out.println(this + " eating");
//    try {
//      sleep(600); // time to eat
//    } catch (InterruptedException e) {
//      System.out.println("Philosopher's eat sleep interrupted.");
//      throw new RuntimeException(e);
//    }
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
        "ponderFactor numberOfChopsticks" +
        "A nonzero ponderFactor will generate a random " +
        "sleep time during think()");
      System.exit(1);
    }
    Philosopher[] philosopher =
      new Philosopher[Integer.parseInt(args[0])];
    Philosopher.ponder = Integer.parseInt(args[1]);
    int numberOfChopsticks = Integer.parseInt(args[2]);
    LinkedList allChopSticks = new LinkedList();
    for(int i = 0; i < numberOfChopsticks; i++) {
      allChopSticks.add(new Chopstick());
    }
    for(int i = 0; i < philosopher.length; i++) {
      // give each thread a name so that it becomes easier to
      // recognize while solving exceptions
      philosopher[i] = new Philosopher("Philosopher " + 
      i, allChopSticks);
    }
  }
} ///:~
