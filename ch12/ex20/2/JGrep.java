//: c12:JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.util.regex.*;
import java.util.*;
import com.bruceeckel.util.*;
import java.nio.*;
import java.nio.channels.*;

public class JGrep {
  public static void main(String[] args) throws Exception {
    if(args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }

    File file = new File(args[0]);
    MappedByteBuffer out = new RandomAccessFile(file, "rw")
    .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, file.length());
    StringBuilder sb = new StringBuilder();
    // read the file into StringBuilder
    for(int i = 0; i < file.length(); i++) {
        sb.append((char)out.get(i));
    }
    String fileContents = sb.toString();
    
    // Create ArrayList of lines using fileContents
    ArrayList lineList = new ArrayList(Arrays.asList(
    fileContents.split("\n")));
    Pattern p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file:
    ListIterator it = lineList.listIterator();
    while(it.hasNext()) {
        Matcher m = p.matcher((String)it.next());
        while(m.find())
            System.out.println(it.nextIndex() + ": " +
            m.group() + ": " + m.start());
    }
  }
} ///:~


