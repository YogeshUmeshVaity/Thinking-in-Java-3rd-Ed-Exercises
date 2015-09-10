import java.io.*;
import java.util.*;

public class Ex1 {
  public static void main(String[] args) {
	List list = new LinkedList();
	try {
		FileReader file = new FileReader("Ex1.java");
		BufferedReader in = new BufferedReader(file);
		// Temporary string
		String s;
		while((s = (in.readLine())) != null) {
		list.add(s);
		}
		in.close();
	} catch(FileNotFoundException fnf) {
		System.out.println("File not found : " + fnf);
	} catch(IOException io) {
		System.out.println("IOException while reading lines : " + io);
	}
	
	ListIterator it = list.listIterator(list.size());
	//System.out.println(list);
	int lineNumber = list.size();
	while(it.hasPrevious()) {
		System.out.println
		(lineNumber-- + " : " + it.previous());
	}
  }
}