class TestPreIncrement {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		for(i = 0; i < 6; ++i) {
			System.out.println(i);
		}
		System.out.println("Now i = " + i);
		System.out.println("\n \n");
		for(j = 0; j < 6; j++) {
			System.out.println(j);
		}
		System.out.println("Now j = " + j);
	}
}