import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Ex5 {
  public static void main(String[] args) {
	if(args.length < 2) {
		System.out.println("Usage : java Ex2 fileName words+");
		System.exit(0);
	}
	List list = new LinkedList();
	try {
		FileReader file = new FileReader(args[0]);
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
	
	ListIterator it = list.listIterator();
	while(it.hasNext()) {
		// set for avoiding duplicate lines.
		Set set = new HashSet();
		String s1 = (String)it.next();
		for(int i = 1; i < args.length; i++) {
			// to match the exact word : used boundary matchers
			String tempString = "\\b" + args[i] + "\\b";
			Pattern p = Pattern.compile(tempString);
			Matcher m = p.matcher(s1);
			if(m.find()) {
				set.add(s1);
			}
		}
		// display set
		Iterator setIt = set.iterator();
		while(setIt.hasNext()) {
			System.out.println(setIt.next());
		}
	}
  }
}