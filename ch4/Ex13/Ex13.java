class Tank {
	boolean tankState = false;
	Tank(boolean state) {
		tankState = state;
	}
	void emptyTank() {
		tankState = false;
	}
	public void finalize() {
		if(tankState == false)
			System.out.println("Error : the tank is filled.");
	}
}

public class Ex13 {
	public static void main(String[] args) {
		Tank t = new Tank(false);
		//emptying the tank t safely.
		t.emptyTank();
		//forgetting to empty the tank.
		new Tank(false);
		System.gc();
	}
}