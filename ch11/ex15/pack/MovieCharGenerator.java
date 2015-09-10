package pack;
import pack.*;
import java.util.*;

public class MovieCharGenerator {
	public static void fill(Collection c, int size) {
		MovieGenerator mg = new MovieGenerator();
		for(int i = 0; i < size; i++) {
			c.add(mg.next());
		}
	}
	public static void fill(Object[] o) {
		MovieGenerator mg = new MovieGenerator();
		for(int i = 0; i < o.length; i++) {
			o[i] = mg.next();
		}
	}
}