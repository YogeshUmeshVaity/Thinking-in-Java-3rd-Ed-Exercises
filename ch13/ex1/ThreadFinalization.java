
/* Here we are not capturing references of the Thread objects.
 * If these were ordinary objects, they would have been garbage
 * collected. But Each Thread 'registers' itself so there is actually
 * a reference to it someplace, and the garbage collector can't clean
 * it up until the thread exits it's run() and dies.
 */
import java.util.*;

class SleepClass extends Thread {
    private static int count = 1;
    private int threadNumber = count++;
    private final int SLEEP_TIME = 5000;
    public SleepClass() {
        System.out.println("Sleep " + threadNumber
        + " started...");
    }
    public void run() {
        try {
            System.out.println("Message 1 of " + threadNumber);
            sleep(SLEEP_TIME);
            System.out.println("Message 2 of " + threadNumber);
            sleep(SLEEP_TIME);
            System.out.println("Message 3 of " + threadNumber);
            sleep(SLEEP_TIME);
            return;
        } catch(InterruptedException e) {
            throw new RuntimeException();
        }
    }
    protected void finalize() {
        System.out.println("Sleep " + threadNumber
        + " has been shut down.");
    }
}

class GCClass extends Thread {
    private static int count = 1;
    private int threadNumber = count++;
    public void run() {
        System.out.println("GC " + threadNumber
        + " calling garbage collector...");
        System.gc();
        System.out.println("GC " + threadNumber 
        + " calling finalization...");
        System.runFinalization();
    }
}

public class ThreadFinalization {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            new SleepClass().start();
            new GCClass().start();
        }  
    }
}
