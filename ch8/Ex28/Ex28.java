interface U {
	void u1();
	void u2();
	void u3();
}

class A {
	U getU() {
		return new U() {
			public void u1(){ System.out.println("u1()"); }
			public void u2(){ System.out.println("u2()"); }
			public void u3(){ System.out.println("u3()"); }
		};
	}
}

class B {
	U[] uArray = new U[6];
	int i = 0;
	void acceptU(U u) {
		uArray[i++] = u;
	}
	void setNull(int uArraryLocation) {
		uArray[uArraryLocation] = null;
	}
	void moveThrough() {
		for(int i = 0; i < uArray.length; i++){
			if(uArray[i] != null) {
				System.out.println("uArrary[" + i + "]");
				uArray[i].u1();
				uArray[i].u2();
				uArray[i].u3();
				System.out.println();
			}
		}
	}
}

public class Ex28 {
	public static void main(String[] args) {
		B b1 = new B();
		A[] a = new A[6];
		// Fill the B with U references 
		for(int i = 0; i < a.length; i++) {
			a[i] = new A();
			// Use B to callback into A objects
			b1.acceptU(a[i].getU());
		}
		// Test uArray before removal of U references
		System.out.println("uArray before removal");
		b1.moveThrough();
		// Remove some of the U references from B
		b1.setNull(2);
		b1.setNull(4);
		// Test uArrary after removal of U references
		System.out.println("uArray after removal");
		b1.moveThrough();
		
	}
}