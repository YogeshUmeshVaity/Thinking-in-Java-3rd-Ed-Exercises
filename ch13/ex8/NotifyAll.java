class A extends Thread {

  @Override
  public void run() {
    try {
      // wait() can only be called from a synchronized method or 
      // block
      synchronized(this) {
        wait();
      }
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("NotifyAll message received.");
  }
  
}


class B extends Thread {

  private Thread a;
  
  private final long SLEEP_TIME = 3000;
  
  public B(Thread a) {
    this.a = a;
  }
  
  @Override
  public void run() {
    System.out.println("Calling notifyAll in " 
    + (SLEEP_TIME/1000) + " seconds");
    synchronized(a) {
      a.notifyAll();
    }
    
  }
  
}


public class NotifyAll {

  public static void main(String[] args) {
    A a = new A();
    a.start();
    B b = new B(a);
    b.start();
  }
  
}
