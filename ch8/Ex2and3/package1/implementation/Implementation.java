package package1.implementation;
import package1.interface1.*;

public class Implementation implements Interface1 {
	// Error : attempting to assign weaker access privileges; was public
	// proves that all the methods in interface are public
	// also the methods are accessible by importing from another package
	// proves that the methods in interface are public
	/*! private void a() {
		System.out.println("a()");
	}
	protected void b() {
		System.out.println("b()");
	}
	void c() {
		System.out.println("c()");
	} */
	
	public void a() {
		System.out.println("a()");
	}
	public void b() {
		System.out.println("b()");
	}
	public void c() {
		System.out.println("c()");
	}
	
	public static void main(String[] args) {
		Implementation imp = new Implementation();
		imp.a();
		imp.b();
		imp.c();
	}
}