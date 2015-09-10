/**
This program tries to compare the performance difference between
Direct ByteBuffer and Non-Direct ByteBuffer
*/
import java.nio.*;
import com.bruceeckel.simpletest.*;

public class UsingBuffers {
  private static Test monitor = new Test();
  private static final int reps = 1000000;
  private static void symmetricScramble(CharBuffer buffer){
    while(buffer.hasRemaining()) {
      buffer.mark();
      char c1 = buffer.get();
      char c2 = buffer.get();
      buffer.reset();
      buffer.put(c2).put(c1);
    }
  }
  public static void TestDirect() {
    for(int i = 0; i < reps; i++) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocateDirect(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        cb.rewind();
        //System.out.println(cb.rewind());
        symmetricScramble(cb);
        cb.rewind();
        //System.out.println(cb.rewind());
        symmetricScramble(cb);
        cb.rewind();
        //System.out.println(cb.rewind());
    }
  }
  public static void TestNonDirect() {
    for(int i = 0; i < reps; i++) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        cb.rewind();
        //System.out.println(cb.rewind());
        symmetricScramble(cb);
        cb.rewind();
        //System.out.println(cb.rewind());
        symmetricScramble(cb);
        cb.rewind();
        //System.out.println(cb.rewind());
    }
  }
  public static void main(String[] args) {
    System.out.println("Testing with Direct ByteBuffer...");
    long t1 = System.currentTimeMillis();
    TestDirect();
    long t2 = System.currentTimeMillis();
    System.out.println("Time taken by Direct ByteBuffer : " 
        + (t2 - t1));
        
    System.out.println("Testing with Non-Direct ByteBuffer...");
    long t3 = System.currentTimeMillis();
    TestNonDirect();
    long t4 = System.currentTimeMillis();
    System.out.println("Time taken by Non-Direct ByteBuffer : " 
        + (t4 - t3));
  }
}
/*
Output : 
Testing with Direct ByteBuffer...
Time taken by Direct ByteBuffer : 1340
Testing with Non-Direct ByteBuffer...
Time taken by Non-Direct ByteBuffer : 341

Conclusion : 
Direct ByteBuffer is useful if it
is used for a long time(long lived buffer), otherwise its allocation
and dealocation costs are a lot.
*/
