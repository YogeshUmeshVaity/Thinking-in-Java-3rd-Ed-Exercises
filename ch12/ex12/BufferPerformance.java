import java.io.*;

public class BufferPerformance {
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
	  for(int i = 0; i < ITERATIONS; i++) {
		try {
			BufferedReader inBuf = new BufferedReader(
			new StringReader(file));
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
	  }
	  long t2 = System.currentTimeMillis();
	  System.out.println("Average time per write : " + (t2 - t1));
		// Write to file without using Buffer
	  System.out.println("Writing file without using Buffer...");
	  long t3 = System.currentTimeMillis();
	  for(int i = 0; i < ITERATIONS; i++) {
		try {
			BufferedReader inBuf = new BufferedReader(
			new StringReader(file));
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
	  }
	  long t4 = System.currentTimeMillis();
	  System.out.println("Average time per write : " + (t4 - t3));
	}
}