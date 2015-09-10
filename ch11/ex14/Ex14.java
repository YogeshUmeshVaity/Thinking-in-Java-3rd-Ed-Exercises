import com.bruceeckel.util.*;
import java.util.*;

public class Ex14 {
	public static void main(String[] args) {
		byte[] b = new byte[9];
		System.out.println("\nByte Array...");
		Arrays2.fill(b, new Arrays2.RandByteGenerator());
		System.out.println(Arrays2.toString(b));
		char[] c = new char[9];
		System.out.println("\nChar Array...");
		Arrays2.fill(c, new Arrays2.RandCharGenerator());
		System.out.println(Arrays2.toString(c));
		short[] s = new short[9];
		System.out.println("\nShort Array...");
		Arrays2.fill(s, new Arrays2.RandShortGenerator());
		System.out.println(Arrays2.toString(s));
		long[] l = new long[9];
		System.out.println("\nLong Array...");
		Arrays2.fill(l, new Arrays2.RandLongGenerator());
		System.out.println(Arrays2.toString(l));
		int[] i = new int[9];
		System.out.println("\nInt Array...");
		Arrays2.fill(i, new Arrays2.RandIntGenerator());
		System.out.println(Arrays2.toString(i));
		float[] f = new float[9];
		System.out.println("\nFloat Array...");
		Arrays2.fill(f, new Arrays2.RandFloatGenerator());
		System.out.println(Arrays2.toString(f));
		double[] d = new double[9];
		System.out.println("\nDouble Array...");
		Arrays2.fill(d, new Arrays2.RandDoubleGenerator());
		System.out.println(Arrays2.toString(d));
		boolean[] bln = new boolean[9];
		System.out.println("\nBoolean Array...");
		Arrays2.fill(bln, new Arrays2.RandBooleanGenerator());
		System.out.println(Arrays2.toString(bln));
		String[] str = new String[9];
		System.out.println("\nString Array...");
		Arrays2.fill(str, new Arrays2.RandStringGenerator(6));
		System.out.println(Arrays2.toString(str));
	}
}