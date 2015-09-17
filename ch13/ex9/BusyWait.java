final class Flag {
  private Flag() {}
  public static boolean status = false;
}

class Thread1 extends Thread {
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
    return;
  }
}

class Thread2 extends Thread {
  @Override
  public void run() {
    // time spent in 'busy wait' is equal to the time it takes
    // for the other thread to set the flag to true.
    while(true) {
      if(Flag.status) {
        Flag.status = false;
        System.out.println("Flag has been set to " + Flag.status);
        return;
      }
      yield(); // program doesn't work without this statement
    }
  }
}

public class BusyWait {
  public static void main(String[] args) {
    Thread1 t1 = new Thread1();
    t1.start();
    Thread2 t2 = new Thread2();
    t2.start();   
  }
}
