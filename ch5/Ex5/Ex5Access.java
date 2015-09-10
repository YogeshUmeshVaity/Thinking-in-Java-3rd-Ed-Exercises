import ex5package.*;
/* class Extended extends AccessControlTest {
} */
public class Ex5Access extends AccessControlTest {
	public static void main(String[] args) {
		Ex5Access act = new Ex5Access();
		System.out.println("dd = " + act.dd);
		//System.out.println("dd = " + act.dd2);
		System.out.println("dd = " + act.dd3);
		//System.out.println("dd = " + act.dd4);
		act.publicMethod();
		//act.privateMethod();
		act.protectedMethod();
		//act.packageAccessMethod();
	}
}