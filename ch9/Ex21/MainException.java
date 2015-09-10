//: c09:MainException.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;

public class MainException {
  // Pass all exceptions to the console:
  public static void main(String[] args) throws Exception {
    // Open the file:
	// Exception in thread "main" java.io.FileNotFoundException: MainException1.java
	// (The system cannot find the file specified)
    FileInputStream file =
      new FileInputStream("MainException1.java");
    // Use the file ...
    // Close the file:
    file.close();
  }
} ///:~