import com.bruceeckel.util.*;
import java.util.*;
class StringContainer {
	// increasing the initial size significantly improves performance
	private String[] str = new String[90000];
	private int index = 0;
	public void add(String s) {
		if(index < (str.length-1)) {
			str[index] = s;
			index++;
		}
		else {
			String[] tmp = new String[str.length + 1];
			// copy str to tmp
			for(int i = 0; i < str.length; i++) {
				tmp[i] = str[i];
			}
			str = new String[tmp.length];
			// copy tmp to str after increasing str
			for(int i = 0; i < tmp.length; i++) {
				str[i] = tmp[i];
			}
			// Now add the element
			str[index] = s;
			index++;
		}
	}
	public String get(int getIndex) {
		if(getIndex <= (str.length - 1)) {
			return str[getIndex];
		}
		else return "no more values";
	}
}

public class Ex12 {
	public static void main(String[] args) {
		int reps = 100000;
		StringContainer st = new StringContainer();
		System.out.println("Testing StringContainer for add...");
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < reps; i++)
			st.add((new Arrays2.RandStringGenerator(6)).next().toString());
		long t2 = System.currentTimeMillis();
		
		ArrayList al = new ArrayList();
		System.out.println("Testing ArrayList for add...");
		long t3 = System.currentTimeMillis();
		for(int i = 0; i < reps; i++)
			al.add((new Arrays2.RandStringGenerator(6)).next().toString());
		long t4 = System.currentTimeMillis();
		
		System.out.println("Testing StringContainer for get...");
		long t5 = System.currentTimeMillis();
		for(int i = 0; i < reps; i++) {
			System.out.println(st.get(i));
		}
		long t6 = System.currentTimeMillis();
		System.out.println("Testing ArrayList for get...");
		long t7 = System.currentTimeMillis();
		for(int i = 0; i < reps; i++) {
			System.out.println(al.get(i));
		}
		long t8 = System.currentTimeMillis();
		System.out.println("Time taken by StringContainer for add = " + (t2 - t1));
		System.out.println("Time taken by ArrayList for add = " + (t4 - t3));
		System.out.println("Time taken by StringContainer for get and print = " + (t6 - t5));
		System.out.println("Time taken by ArrayList for get and print = " + (t8 - t7));
		//st.get(95000);
	}
}