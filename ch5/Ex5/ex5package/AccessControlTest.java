package ex5package;
public class AccessControlTest {
	public double dd = 5.4;
	private double dd2 = 6.3;
	protected double dd3 = 9.3;
	double dd4 = 12.6;
	public void publicMethod() {System.out.println("publicMethod accessible.");}
	private void privateMethod() {System.out.println("privateMethod accessible");}
	protected void protectedMethod() {System.out.println("protectedMethod accessible");}
	void packageAccessMethod() {System.out.println("packageAccessMethod accessible");}
}

/* public class Ex5 {
	public static void main(String[] args) {
		AccessControlTest act = new AccessControlTest();
		System.out.println("dd = " + act.dd);
		//System.out.println("dd = " + act.dd2);
		System.out.println("dd = " + act.dd3);
		System.out.println("dd = " + act.dd4);
		act.publicMethod();
		//act.privateMethod();
		act.protectedMethod();
		act.packageAccessMethod();
	}
} */