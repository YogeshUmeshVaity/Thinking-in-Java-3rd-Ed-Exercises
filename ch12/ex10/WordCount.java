/*
 * Modify WordCount.java so that it uses a class containing
 * a String and a count value to store each different word,
 * and a Set of these objects to maintain the list of words. 
 */
import com.bruceeckel.simpletest.*;
import java.io.*;
import java.util.*;
import com.bruceeckel.util.*;

class Counter {
  private int i = 1;
  public int read() { return i; }
  public void increment() { i++; }
}

class StringCounter implements Comparable {
	public String key;
	public StringCounter(String key) {
		this.key = key;
	}
	private int counter = 1;
	public String getKey() { return key; }
	public int getValue() { return counter; }
	public void increment() { counter++; }
	@Override public int hashCode() {
		return key.hashCode();
	}
	@Override public boolean equals(Object o) {
		return (o instanceof StringCounter && (key == ((StringCounter)o).key));
	}
	@Override public String toString() {
		return key + " : " + counter;
	}
	@Override public int compareTo(Object o) {
		return ((Comparable)key).compareTo(((StringCounter)o).key);
	}
}

public class WordCount {
  private static final String usage =
    "Usage: \nWordCount file\n" +
    "Counts the words in the file and " +
    "outputs results in sorted form.";
  private FileReader file;
  private StreamTokenizer st;
  Set set = new TreeSet();
  public WordCount(String filename)
    throws FileNotFoundException {
    try {
      file = new FileReader(filename);
      st = new StreamTokenizer(new BufferedReader(file));
      st.ordinaryChar('.');
      st.ordinaryChar('-');
    } catch(FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  public void dispose() {
    try {
      file.close();
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void countWords() {
    try {
      while(st.nextToken() !=
        StreamTokenizer.TT_EOF) {
        String s;
        switch(st.ttype) {
          case StreamTokenizer.TT_EOL:
            s = new String("EOL");
            break;
          case StreamTokenizer.TT_NUMBER:
            s = Double.toString(st.nval);
            break;
          case StreamTokenizer.TT_WORD:
            s = st.sval; // Already a String
            break;
          default: // single character in ttype
            s = String.valueOf((char)st.ttype);
        }
		Iterator it = set.iterator();
		boolean found = false;
		while(it.hasNext()) {
			StringCounter sc = (StringCounter)it.next();
			String scKey = sc.getKey();
			if(scKey.equals(s)) {
				sc.increment();
				found = true;
				break;
			}
		}
		if(!found) {
			set.add(new StringCounter(s));
		}
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public Collection values() {
	Collection c = new ArrayList();
	Iterator it = set.iterator();
	while(it.hasNext()) {
		StringCounter sc = (StringCounter)it.next();
		c.add(sc.getValue());
	}
    return c;
  }
  public Set keySet() { return set; }
  public int getCounter(String s) {
		Iterator it = set.iterator();
		boolean found = false;
		while(it.hasNext()) {
			StringCounter sc = (StringCounter)it.next();
			String scKey = sc.getKey();
			if(scKey.equals(s)) {
				return sc.getValue();
			}
		}
		return 0;
  }
  public static void main(String[] args)
  throws FileNotFoundException {
    if(args.length == 0) {
      System.out.println(usage);
      System.exit(1);
    }
    WordCount wc = new WordCount(args[0]);
    wc.countWords();
    Iterator keys = wc.keySet().iterator();
    while(keys.hasNext()) {
     System.out.println(keys.next());
    }
	System.out.println("Value Collection : " + wc.values());
	System.out.println
	("The word 'it' appears " + wc.getCounter("it") + " times");
    wc.dispose();
  }
} ///:~