import java.util.*;
import com.bruceeckel.util.*;

public class HashMapTest {
  private static int reps = 50000;
  private abstract static class Tester {
    String name;
    Tester(String name) { this.name = name; }
    abstract void test(Map m);
  }
  private static Tester[] tests = {
      new Tester("get") {
      void test(Map m) {
        for(int i = 0; i < reps; i++)
          for(int j = 0; j < m.size(); j++)
            m.get(Integer.toString(j));
      }
    }
  };
  public static void test(Map m) {
    // Strip qualifiers from class name:
    System.out.println("Testing " +
      m.getClass().getName().replaceAll("\\w+\\.", "") +
      " size " + m.size());
	  double sz = (double)m.size();
    for(int i = 0; i < tests.length; i++) {
      System.out.print(tests[i].name);
      long t1 = System.currentTimeMillis();
      tests[i].test(m);
      long t2 = System.currentTimeMillis();
      System.out.println(": " +
        ((double)(t2 - t1)/sz));
    }
  }
  public static void main(String[] args) {
    // Choose a different number of
    // repetitions via the command line:
    if(args.length > 0)
      reps = Integer.parseInt(args[0]);
    System.out.println(reps + " repetitions");
	// the default initial capacity (16) and the default load factor (0.75)
	HashMap m1 = new HashMap();
	Collections2.fill(m1, Collections2.rsp, 9999);
    test(m1);
	// new map with larger initial capacity with same loadFactor
	HashMap m2 = new HashMap(1500, 0.75f);
	m2.putAll(m1);
	test(m2);
	// not much difference if the map size is 999
	// not much difference with 9999 either
	
	
  }
} ///:~
