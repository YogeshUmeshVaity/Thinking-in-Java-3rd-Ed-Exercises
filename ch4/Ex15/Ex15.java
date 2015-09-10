class StringInitDemo {
	String s;
}

public class Ex15 {
	public static void main(String[] args) {
		StringInitDemo sid = new StringInitDemo();
		//Displays the value 'null' which is the reference initialized by Java on Strings.
		System.out.println(sid.s);
	}
}