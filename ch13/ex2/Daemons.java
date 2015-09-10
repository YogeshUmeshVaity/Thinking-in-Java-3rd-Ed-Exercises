//: c13:Daemons.java
// Daemon threads spawn other daemon threads.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import com.bruceeckel.simpletest.*;

class Daemon extends Thread {
  // Need to increase the number of threads on a fast processor
  // to see the change
  private Thread[] t = new Thread[100];
  public Daemon() {
    setDaemon(true);
    start();
  }
  public void run() {
    for(int i = 0; i < t.length; i++)
      t[i] = new DaemonSpawn(i);
    for(int i = 0; i < t.length; i++)
      System.out.println("t[" + i + "].isDaemon() = "
        + t[i].isDaemon());
    while(true)
      yield();
  }
}

class DaemonSpawn extends Thread {
  public DaemonSpawn(int i) {
    start();
    System.out.println("DaemonSpawn " + i + " started");
  }
  public void run() {
    while(true)
      yield();
  }
}

public class Daemons {
  private static Test monitor = new Test();
  public static void main(String[] args) throws Exception {
    Thread d = new Daemon();
    System.out.println("d.isDaemon() = " + d.isDaemon());
    // Allow the daemon threads to
    // finish their startup processes:
    Thread.sleep(10000);
  }
} ///:~
