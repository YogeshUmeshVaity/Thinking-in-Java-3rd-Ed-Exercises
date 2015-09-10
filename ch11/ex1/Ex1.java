/*	Create an array of double and fill( )
 it using RandDoubleGenerator. Print the results. */
import com.bruceeckel.util.*;
public class Ex1 {
	public static void main(String[] args) {
		double[] d = new double[9];
		Arrays2.fill(d, new Arrays2.RandDoubleGenerator());
		System.out.println(Arrays2.toString(d));
	}
}