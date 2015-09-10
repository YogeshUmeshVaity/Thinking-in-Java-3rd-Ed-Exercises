//: c09:LostMessage.java
// How an exception can be lost.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class VeryImportantException extends Exception {
  public String toString() {
    return "A very important exception!";
  }
}

class HoHumException extends Exception {
  public String toString() {
    return "A trivial exception";
  }
}

class WorthlessException extends Exception {
	public String toString() {
		return "A worthless exception";
	}
}

public class LostMessage {
  private static Test monitor = new Test();
  void f() throws VeryImportantException {
	System.out.println("f() called");
    throw new VeryImportantException();
  }
  void dispose() throws HoHumException {
	System.out.println("dispose() called");
    throw new HoHumException();
  }
  void clean() throws WorthlessException {
	  System.out.println("clean() called");
	  throw new WorthlessException();
  }
  public static void main(String[] args) throws Exception {
    LostMessage lm = new LostMessage();
    try {
      lm.f();
    } finally {
		try {
			lm.dispose();
		} finally {
			lm.clean();
		}
    }
    /* monitor.expect(new String[] {
      "Exception in thread \"main\" A trivial exception",
      "\tat LostMessage.dispose(LostMessage.java:24)",
      "\tat LostMessage.main(LostMessage.java:31)"
    }); */  }
} ///:~
