import java.util.*;
class ThisTest {
	String s1;
	ThisTest method2(String s) {
		s1 = s;
		System.out.println("Method2 is called " + s1);
		return this;
	}
	
	void method1() {
		method2("Without using This");
		this.method2("Using This");
	}
}

public class Ex9 {
	public static void main(String[] args ) {
	ThisTest tt = new ThisTest();
	tt.method1();
	}
}