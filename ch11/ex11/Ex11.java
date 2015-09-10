import java.util.*;
import com.bruceeckel.util.*;

class SingleContainer extends ArrayList {
	private ArrayList al = new ArrayList();
	private Class c;
	public boolean add(Object o) {
		if(c == null) {
			c = o.getClass();
		}
		if(o.getClass() == c) {
			al.add(o);
			return true;
		}
		else {
			System.out.println("Given object doesn't match with the first object's type");
			return false;
		}
		
	}
	public String toString() {
		return al + "";
	}
}

public class Ex11 {
	public static void main(String[] args) {
		List sc = new SingleContainer();
		sc.add("Good Programmer");
		sc.add(new Cat(1));
		sc.add(new Object());
		sc.add(new Cat(2));
		System.out.println(sc);
	}
}
// Test type
class Cat {
	int catNumber = 0;
	Cat(int i) {
		catNumber = i;
	}
	public String toString() { return "Cat " + catNumber; }
}