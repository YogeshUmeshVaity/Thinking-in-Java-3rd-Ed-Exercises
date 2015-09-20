//: c13:PipedIO.java
// Using pipes for inter-thread I/O
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.util.*;

class Sender extends Thread {
  private BufferedReader readFile;
  public Sender(BufferedReader readFile) {
    this.readFile = readFile;
  }
  private Random rand = new Random();
  private PipedWriter out = new PipedWriter();
  public PipedWriter getPipedWriter() { return out; }
  
  private String s;
  @Override
  public void run() {
    while(true) {
      try {
        while((s = readFile.readLine()) != null) {
          out.write(s);
          out.write("\n");
          sleep(rand.nextInt(100));
        }
      } catch(IOException e) {
        throw new RuntimeException(e);
      } catch(InterruptedException ie) {
        System.out.println("Sender's sleep interrupted");
      }
    }
  }
}

class Receiver extends Thread {
  private PipedReader in;
  public Receiver(Sender sender) throws IOException {
    in = new PipedReader(sender.getPipedWriter());
  }
  public void run() {
    try {
      while(true) {
        // Blocks until characters are there:
        System.out.print((char)in.read());
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}

public class PipedIO {
  public static void main(String[] args) throws Exception {
    // this part must be in the executable block
    // not as field in a class
    BufferedReader readFile = new BufferedReader(new FileReader(new File("PipedIO.java")));
    Sender sender = new Sender(readFile);
    Receiver receiver = new Receiver(sender);
    sender.start();
    receiver.start();
    new Timeout(6000, "Terminated");
  }
} ///:~
