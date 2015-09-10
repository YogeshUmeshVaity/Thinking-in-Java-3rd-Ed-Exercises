class Ex10 {
	char[] c = {'a', 'b', 'c'};
	void checkArray() {
		Class o = c.getClass();
		if(o.isPrimitive())
			System.out.println("char array c is primitive");
		else
			System.out.println("char array c is true object");
	}
	public static void main(String[] args) {
		Ex10 ex = new Ex10();
		ex.checkArray();
	}
}

// All arrays in Java are objects, even arrays for primitive types