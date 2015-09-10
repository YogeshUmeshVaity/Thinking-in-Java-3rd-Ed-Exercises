class GoodProgramer {
	void showMessage() {
		System.out.println("Ola");
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		GoodProgramer gp = new GoodProgramer();
		gp.showMessage();
	}
}
// Even though there is not default constructor provided for GoodProgrammer,
// The compiler creates the default contructor and completes compilation 
// object is created successfully and message is displayed.