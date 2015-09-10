import java.io.*;

public class BufferPerformance3 {
	public static void main(String[] args) {
		final int ITERATIONS = 100000;
		String file = "";
		try {
			BufferedReader in = new BufferedReader(
			new FileReader("BufferPerformance.java"));
			String s;
			while((s = in.readLine()) != null) {
				file += s + "\n";
			}
			in.close();
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf);
		} catch(IOException io) {
			System.out.println(io);
		} 
		// Write to file using Buffer
	  System.out.println("Writing file using Buffer...");
	  long t1 = System.currentTimeMillis();
	  //for(int i = 0; i < ITERATIONS; i++) {
		try {
			BufferedReader inBuf = new BufferedReader(
			new FileReader("test.txt"));
			PrintWriter outBuf = new PrintWriter(new BufferedWriter(
			new FileWriter("IODemo.out")));
			String s;
			while((s = inBuf.readLine()) != null) {
				outBuf.println(s);
			}
			outBuf.close();
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf);
		} catch(IOException io) {
			System.out.println(io);
		}
	  //}
	  long t2 = System.currentTimeMillis();
	  System.out.println("Average time per write : " + (t2 - t1));
		// Write to file without using Buffer
	  System.out.println("Writing file without using Buffer...");
	  long t3 = System.currentTimeMillis();
	  //for(int i = 0; i < ITERATIONS; i++) {
		try {
			BufferedReader inBuf = new BufferedReader(
			new FileReader("test.txt"));
			PrintWriter out = new PrintWriter(new FileWriter("IODemo2.out"));			
			String s;
			while((s = inBuf.readLine()) != null) {
				out.println(s);
			}
			out.close();
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf);
		} catch(IOException io) {
			System.out.println(io);
		}
	  //}
	  long t4 = System.currentTimeMillis();
	  System.out.println("Average time per write : " + (t4 - t3));
	}
}
/**
 * Using the 1.76 GB file test.txt : Output Report as follows : 
 * C:\code\TIJEx\Ch12\ex12>java BufferPerformance3
 * Writing file using Buffer...
 * Average time per write : 73568
 * Writing file without using Buffer...
 * Average time per write : 79492
 */