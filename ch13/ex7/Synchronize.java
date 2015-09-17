/*
 * Demonstrate that a synchronized method in a class can call a 
 * second synchronized method in the same class, which can then 
 * call a third synchronized method in the same class. Create a 
 * separate Thread object that invokes the first synchronized 
 * method.
 */


class SyncMethods {

  public synchronized void x() {
    System.out.println("x() was called...");
    y();
  }
  
  public synchronized void y() {
    System.out.println("y() was called...");
    z();
  }
  
  public synchronized void z() {
    System.out.println("z() was called...");
  }
  
}


class CallerThread extends Thread {

  @Override
  public void run() {
    SyncMethods sm = new SyncMethods();
    sm.x();
    return;
  }
  
}


public class Synchronize {
  
  public static void main(String[] args) {
    // start the caller
    CallerThread ct = new CallerThread();
    ct.start();
  }
  
}
