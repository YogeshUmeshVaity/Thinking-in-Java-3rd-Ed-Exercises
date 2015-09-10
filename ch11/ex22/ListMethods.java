import java.util.*;

class MyClass {
	int a;
	MyClass(int a) {
		this.a = a;
	}
	public String toString() {
		return "" + a;
	}
}

public class ListMethods {
	public static void main(String[] args) {
		MyClass[] mc = {
			new MyClass(3),
			new MyClass(6),
			new MyClass(15),
			new MyClass(9),
			new MyClass(12),
			new MyClass(18)
			};
		List list = new ArrayList();
		for(int i = 0; i < mc.length; i++) {
			list.add(mc[i]);
		}
		System.out.println("\nlist : \n" + list);
		List subList = list.subList(3, 6);
		System.out.println("\nsbuList : \n" + subList);
		list.removeAll(subList);
		System.out.println("\nlist.removeAll(subList) : " + list);
	}
}