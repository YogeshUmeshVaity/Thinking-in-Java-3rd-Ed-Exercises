/** Modify DirList.java so that the FilenameFilter actually
 * opens each file and accepts the file based on whether
 * any of the trailing arguments on the command line exist
 * in that file.
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;
import com.bruceeckel.util.*;

public class DirList {
  public static void main(String[] args) {
	if(args.length != 1) {
		System.out.println("Usage : java DirList wordForSearch");
		System.exit(0);
	}
    File path = new File("."); // . means current directory
    String[] list;
    if(args.length == 0)
      list = path.list();
    else
      list = path.list(new DirFilter(args));
    Arrays.sort(list, new AlphabeticComparator());
    for(int i = 0; i < list.length; i++)
      System.out.println(list[i]);
  }
}

class DirFilter implements FilenameFilter {
  private String[] regex;
  public DirFilter(String[] regex) {
    this.regex = regex;
  }
  public boolean accept(File dir, String name) {
    // Strip path information, search for regex:
    //return pattern.matcher(new File(name).getName()).matches();
	String stringFile = "";
	try {
		FileReader fileIn = new FileReader(name);
		BufferedReader in = new BufferedReader(fileIn);
		String s;
		while((s = in.readLine()) != null) {
			stringFile += s + "\n";
		}
		in.close();
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf);
		} catch(IOException io) {
			System.out.println(io);
	  }
	for(int i = 0; i < regex.length; i++) {
		Pattern p = Pattern.compile(regex[i]);
		Matcher m = p.matcher(stringFile);
		if(m.find()) {
			return true;
		}
	}
	return false;
  }
} ///:~
