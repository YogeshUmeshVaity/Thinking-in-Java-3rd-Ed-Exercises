final class Flag {
  private Flag() {}
  public static boolean status = false;
}

class Thread1 extends Thread {
  public Thread2 t2;
  public Thread1(Thread2 t2) {
    this.t2 = t2;
  }
  @Override
  public void run() {
    try {
    System.out.println("Initial flag status : " + Flag.status);
      sleep(9000);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    Flag.status = true;
    System.out.println("Secondary flag status : " + Flag.status);
    // must aquire lock on t2 before calling its notify()
    synchronized(t2) {
      t2.notify();
    }
    return;
  }
}

class Thread2 extends Thread {
  @Override
  public void run() {
    try {
      synchronized(this) {
        wait();
      }
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    Flag.status = false;
    System.out.println("Flag has been set to " + Flag.status);
    return;
  }
}

public class Wait {
  public static void main(String[] args) {
    Thread2 t2 = new Thread2();
    t2.start();
    Thread1 t1 = new Thread1(t2);
    t1.start();
  }
}
