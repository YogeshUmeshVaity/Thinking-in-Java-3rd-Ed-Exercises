import java.lang.reflect.*;
class LivingObject {
	String color = "red";
	int sizeFt = 3;
}

class Animal extends LivingObject {
	double heightInches = 24.3;
	int legs = 4;
}

class Cat extends Animal {
	boolean healthy = true;
	int age = 7;
}

public class Ex6 {
	static void printHierarchy(Object o) {
		Class c = o.getClass();
		// print current class first
		System.out.println(c);
		showFields(c);
		while(c != null) {
				Class superClass = c.getSuperclass();
				if(superClass != null) {
					System.out.println(superClass);
					showFields(superClass);
				}
				c = superClass;
		}
	}
	static void showFields(Class c) {
		Field[] f = c.getDeclaredFields();
		System.out.println("Fields : ");
		for(int i = 0; i < f.length; i++) {
			System.out.println("\t" + f[i].getName());
		}
	}
	public static void main(String[] args) {
		Cat cat = new Cat();
		try {
			printHierarchy(cat);
		} catch (NullPointerException e) {
			System.out.println("End of hierarchy");
		}
	}
}