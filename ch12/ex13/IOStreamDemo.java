//: c12:IOStreamDemo.java
// Typical I/O stream configurations.
// {RunByHand}
// {Clean: IODemo.out,Data.txt,rtest.dat}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.io.*;
import java.util.regex.*;

public class IOStreamDemo {
  private static Test monitor = new Test();
  // Throw exceptions to console:
  public static void main(String[] args)
  throws IOException {
    // 1. Reading input by lines:
	// In general, each read request made of a Reader causes
	// a corresponding read request to be made of the
	// underlying character or byte stream.
	// It is therefore advisable to wrap a BufferedReader
	// around any Reader whose read() operations may be
	// costly, such as FileReaders and InputStreamReaders.
    BufferedReader in = new BufferedReader(
      new FileReader("IOStreamDemo.java"));
    String s, s2 = new String();
    while((s = in.readLine())!= null)
      s2 += s + "\n";
    in.close();

    // 1b. Reading standard input:
	// InputStreamReader is a bridge(adapter) from byte streams
	// to character streams: It reads bytes and decodes
	// them into characters.
	// System.in(byte stream) is an InputStream, 
	// and BufferedReader needs a Reader argument,
	// so InputStreamReader is brought in to perform
	// the adaptation.
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader(System.in));
    System.out.print("Enter a line:");
    System.out.println(stdin.readLine());

    // 2. Input from memory
    StringReader in2 = new StringReader(s2);
    int c;
    while((c = in2.read()) != -1)
      System.out.print((char)c);

    // 3. Formatted memory input
	// To read 'formatted' data, you use a DataInputStream,
	// which is a byte-oriented I/O class
	// (rather than char-oriented). Thus you must use all
	// InputStream classes rather than Reader classes.
	// getBytes() converts a string to array of bytes which
	// is required for ByteArrayInputStream
    try {
      DataInputStream in3 = new DataInputStream(
        new ByteArrayInputStream(s2.getBytes()));
      while(true)
        System.out.print((char)in3.readByte());
    } catch(EOFException e) {
      System.err.println("End of stream");
    }

    // 4. File output
	// FileWriter is created to connect to the file. 
	// You’ll virtually always want to buffer the output
	// by wrapping it in a BufferedWriter
	// buffering tends to dramatically increase performance
	// of I/O operations.
	// Then for the formatting it’s turned into a PrintWriter.
	// The data file created this way is readable as an 
	// ordinary text file.
	// FileWriter - where you want to write
	// BufferedWriter - Provide buffer for writing
	// PrintWriter - how you want to write
	// BufferedReader - what you want to write(while providing
	// buffer for reading).
    try {
      BufferedReader in4 = new BufferedReader(
        new StringReader(s2)); // you would use FileReader, if it was to read from a file.
      PrintWriter out1 = new PrintWriter(
        new BufferedWriter(new FileWriter("IODemo.out")));
	  // Note that LineNumberInputStream is not used,
	  // because it’s a silly class and you don’t need it.
	  // As shown here, it’s trivial to keep track
	  // of your own line numbers.
      int lineCount = 1;
      while((s = in4.readLine()) != null )
        out1.println(lineCount++ + ": " + s);
	// if you don’t call close( ) for all your output files,
	// you might discover that the buffers don’t get flushed,
	// so they’re incomplete.
      out1.close();
    } catch(EOFException e) {
      System.err.println("End of stream");
    }

    // 5. Storing & recovering data
    try {
      DataOutputStream out2 = new DataOutputStream(
        new BufferedOutputStream(
          new FileOutputStream("Data.txt")));
      out2.writeDouble(3.14159);
      out2.writeUTF("That was pi");
      out2.writeDouble(1.41413);
      out2.writeUTF("Square root of 2");
      out2.close();
      DataInputStream in5 = new DataInputStream(
        new BufferedInputStream(
          new FileInputStream("Data.txt")));
      // Must use DataInputStream for data:
      System.out.println(in5.readDouble());
      // Only readUTF() will recover the
      // Java-UTF String properly:
	  String tempString = in5.readUTF();
	  String newStr = tempString.replaceAll("\\s", "");
      System.out.println(newStr);
      // Read the following double and String:
      System.out.println(in5.readDouble());
      System.out.println(in5.readUTF());
    } catch(EOFException e) {
      throw new RuntimeException(e);
    }

    // 6. Reading/writing random access files
    RandomAccessFile rf =
      new RandomAccessFile("rtest.dat", "rw");
    for(int i = 0; i < 10; i++)
      rf.writeDouble(i*1.414);
    rf.close();
    rf = new RandomAccessFile("rtest.dat", "rw");
    rf.seek(5*8);
    rf.writeDouble(47.0001);
    rf.close();
    rf = new RandomAccessFile("rtest.dat", "r");
    for(int i = 0; i < 10; i++)
      System.out.println("Value " + i + ": " +
        rf.readDouble());
    rf.close();
    //monitor.expect("IOStreamDemo.out");
  }
} ///:~