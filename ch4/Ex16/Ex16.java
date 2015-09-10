class StringInitDemo {
	String s = "Good";
	StringInitDemo() {
		String s = "Programer";
		System.out.println(s);
	}
}

public class Ex16 {
	public static void main(String[] args) {
		StringInitDemo sid = new StringInitDemo();
		/** The initialization in constructor is executed first
		*i.e. it is initialized before it is used */
		System.out.println(sid.s);
	}
}