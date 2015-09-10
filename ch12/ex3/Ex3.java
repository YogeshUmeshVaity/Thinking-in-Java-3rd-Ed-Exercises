import java.io.*;
import java.util.*;

public class Ex3 {
  public static void main(String[] args) {
	if(args.length != 2) {
		System.out.println
		("Usage : java Ex3 sourcefile destfile");
		System.exit(0);
	}
	List list = new LinkedList();
	try {
		FileReader file = new FileReader(args[0]);
		BufferedReader in = new BufferedReader(file);
		// Temporary string
		String s;
		int lineCount = 1;
		while((s = (in.readLine())) != null) {
		  list.add(lineCount++ + " : " + s);
		}
		in.close();
	} catch(FileNotFoundException fnf) {
		System.out.println("File not found : " + fnf);
	} catch(IOException io) {
		System.out.println("IOException while reading lines : " + io);
	}
	try {
		FileWriter fileOut = new FileWriter(args[1]);
		BufferedWriter out = new BufferedWriter(fileOut);
		ListIterator it = list.listIterator();
		while(it.hasNext()) {
			out.write((String)it.next());
			out.newLine();
		}
		out.close();
	} catch(Exception e) {
			System.out.println(e);
		}
	
	//System.out.println(list);
  }
}