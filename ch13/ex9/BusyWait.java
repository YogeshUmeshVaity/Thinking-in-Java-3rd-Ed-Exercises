class Thread1 extends Thread {
  private boolean flag = false;
  @Override
  public void run() {
    try {
    System.out.println("Initial flag status : " + flag);
      sleep(9000);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    setFlagTrue();
    System.out.println("Secondary flag status : " + flag);
    return;
  }
  public void setFlagTrue() {
    flag = true;
  }
  public void setFlagFalse() {
    flag = false;
  }
  public boolean checkFlag() {
    return flag;
  }
}

class Thread2 extends Thread {
  public Thread1 t1;
  public Thread2(Thread1 t1) {
    this.t1 = t1;
  }
  @Override
  public void run() {
    // time spent in 'busy wait' is equal to the time it takes
    // for the other thread to set the flag to true.
    while(true) {
      if(t1.checkFlag()) {
        t1.setFlagFalse();
        System.out.println("Flag has been set to false");
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
    Thread2 t2 = new Thread2(t1);
    t2.start();   
  }
}
