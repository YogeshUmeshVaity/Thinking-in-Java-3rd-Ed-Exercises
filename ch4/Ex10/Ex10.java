class ThisConstructors {
	ThisConstructors(String name) {
	this(33);
	System.out.println("You entered name.");
	}
	ThisConstructors(int rollno) {
		System.out.println("Roll no. is " + rollno);
	}
}

public class Ex10 {
	public static void main(String[] args) {
		new ThisConstructors("Good Programer");
		//new ThisConstructors(45);
	}
}