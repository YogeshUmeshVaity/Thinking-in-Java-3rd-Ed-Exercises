import com.bruceeckel.util.*;
import java.util.*;

class IntContainer {
	private int[] intArray = new int[5000000];
	private int index = 0;
	public void add(int i) {
		if(index < (intArray.length - 1)) {
			intArray[index] = i;
			index++;
		}
		else {
			//System.out.println("...");
			int[] tmp = new int[intArray.length + 1];
			for(int x = 0; x < intArray.length; x++) {
				tmp[x] = intArray[x];
			}
			intArray = new int[tmp.length];
			for(int x = 0; x < tmp.length; x++) {
				intArray[x] = tmp[x];
			}
			intArray[index] = i;
			index++;
		}
	}
	public int get(int idx) {
		return intArray[idx];
	}
	public void increment() {
		for(int x = 0; x < intArray.length; x++) {
			intArray[x] = intArray[x] + 1;
		}
	}
}

public class Ex13 {
	public static void main(String[] args) {
		int reps = 5000000;
		IntContainer ic = new IntContainer();
		// add to IntContainer
		System.out.println("\nAdding to IntContainer...");
		long t1 = System.currentTimeMillis();
		for(int j = 0; j < reps; j++) {
			ic.add((new Arrays2.RandIntGenerator()).next());
		}
		long t2 = System.currentTimeMillis();
		// get from IntContainer
		System.out.println("\nGetting from IntContainer...");
		long t3 = System.currentTimeMillis();
		for(int j = 0; j < reps; j++) {
			ic.get(j);
		}
		long t4 = System.currentTimeMillis();
		// increment IntContainer
		System.out.println("\nIncrementing IntContainer...");
		long t9 = System.currentTimeMillis();
		ic.increment();
		long t10 = System.currentTimeMillis();
		
		
		// ArrayList
		ArrayList al = new ArrayList();
		// add to ArrayList
		System.out.println("\nAdding to ArrayList...");
		long t5 = System.currentTimeMillis();
		for(int j = 0; j < reps; j++) {
			al.add((new Arrays2.RandIntGenerator()).next());
		}
		long t6 = System.currentTimeMillis();
		// get from ArrayList
		System.out.println("\nGetting from ArrayList...");
		long t7 = System.currentTimeMillis();
		for(int j = 0; j < reps; j++) {
			al.get(j);
		}
		long t8 = System.currentTimeMillis();
		// Increment ArrayList
		System.out.println("\nIncrementing ArrayList...");
		long t11 = System.currentTimeMillis();
		for(int j = 0; j < reps; j++) {
			int temp = (Integer)al.get(j);
			al.set(j, temp + 1);
		}
		long t12 = System.currentTimeMillis();
		System.out.println("\nIntContainer add : " + (t2 - t1));
		System.out.println("\nIntContainer get : " + (t4 - t3));
		System.out.println("\nIntContainer increment : " + (t10 - t9));
		System.out.println("\nArrayList add : " + (t6 - t5));
		System.out.println("\nArrayList get : " + (t8 - t7));
		System.out.println("\nArrayList increment : " + (t12 - t11));
		
		/* for(int j = 0; j < reps; j++) {
			System.out.println(ic.get(j));
		}
		ic.increment();
		for(int j = 0; j < reps; j++) {
			System.out.println(ic.get(j));
		} */
	}
}