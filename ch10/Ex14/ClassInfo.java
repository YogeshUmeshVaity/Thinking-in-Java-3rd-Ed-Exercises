import java.lang.reflect.*;
import java.lang.annotation.*;
public class ClassInfo {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName(args[0]);
		System.out.print("getAnnotations() : ");
		System.out.println(c.getAnnotations());
		System.out.print("getSuperclass() : ");
		System.out.println(c.getSuperclass());
		System.out.print("getCanonicalName() : ");
		System.out.println(c.getCanonicalName());
		System.out.print("getClasses() : \n");
		Class[] classes = c.getClasses();
		for(int i = 0; i < classes.length; i++) {
			System.out.println(classes[i].toString());
		}
		System.out.print("getClassLoader() : ");
		System.out.println(c.getClassLoader());
		System.out.print("getComponentType() : ");
		System.out.println(c.getComponentType());
		System.out.print("getConstructor() : ");
		System.out.println(c.getConstructor());
		System.out.print("getDeclaredAnnotations() : ");
		Annotation[] ano = c.getDeclaredAnnotations();
		for(int i = 0; i < ano.length; i++) {
			System.out.println(ano[i]);
		}
		System.out.print("getModifiers() : ");
		System.out.println(c.getModifiers());
		System.out.print("getPackage() : ");
		System.out.println(c.getPackage());
		System.out.print("getSimpleName() : ");
		System.out.println(c.getSimpleName());
		System.out.println("isArray() : " + c.isArray());
	}
}