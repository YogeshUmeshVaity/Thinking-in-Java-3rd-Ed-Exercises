import java.io.*;
import java.util.regex.*;

public class SortedDirList {
	File file;
	public SortedDirList(String filePath) {
		file = new File(filePath);
	}
	public void list() {
		String[] lst = file.list();
		for(int i = 0; i < lst.length; i++) {
			System.out.println(lst[i]);
		}
	}
	public void list(String s) {
		String[] lst = file.list(new DirFilter(s));
		for(int i = 0; i < lst.length; i++) {
			System.out.println(lst[i]);
		}
	}
	public void size(String fileName) {
		File fileForSize = new File(fileName);
		System.out.println(
		"Size of the file " + fileName + " : " + fileForSize.length());
	}
	
	public static void main(String[] args) {
		SortedDirList dirList =
		new SortedDirList("C:\\code");
		dirList.size("SortedDirList.java");
		if(args.length == 0) {
			dirList.list();
			System.exit(0);
		}
		dirList.list(args[0]);
	}
}

class DirFilter implements FilenameFilter {
	Pattern p;
	DirFilter(String regex) {
		p = Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		return p.matcher(new File(name).getName()).matches();
	}
}