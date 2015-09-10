//: c12:DirList.java
// Displays directory listing using regular expressions.
// {Args: "D.*\.java"}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.util.*;
import java.util.regex.*;
import com.bruceeckel.util.*;

public class DirList {
  private static String[] regexArray;
  public static void main(String[] args) {
	String[] list;
	File path = new File(".");
	regexArray = args;
    if(regexArray.length == 0) {
		list = path.list();
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}  
    else {
		recDir(path);
	} 
  }
  public static void recDir(File path) {
	String[] list = path.list(new DirFilter(regexArray[0]));
    Arrays.sort(list, new AlphabeticComparator());
    for(int i = 0; i < list.length; i++) {
		File currentElement = new File(list[i]);
		if(currentElement.isDirectory()) {
			recDir(new File(currentElement.getName()));
		}
		else System.out.println(list[i]);
	}
  }
}

class DirFilter implements FilenameFilter {
  private Pattern pattern;
  public DirFilter(String regex) {
    pattern = Pattern.compile(regex);
  }
  public boolean accept(File dir, String name) {
    // Strip path information, search for regex:
	File currentElement = new File(name);
	if(currentElement.isDirectory()) {
		return true;
	}
    else return pattern.matcher(
      currentElement.getName()).matches();
  }
} ///:~
