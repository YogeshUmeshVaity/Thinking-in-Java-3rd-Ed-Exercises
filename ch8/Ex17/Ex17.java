interface Bulb {
	void turnOn();
	void turnOff();
}

class PowerSavingBulb {
	private class CFLBulb implements Bulb {
		int brightness = 90;
		public void turnOn() {
			System.out.println("CFL has been turned on");
		}
		public void turnOff() {
			System.out.println("CFL has been turned off");
		}
		public String toString() { return "CFLBulb Object"; }
	}
	CFLBulb createCFL() {
		return new CFLBulb();
	}
}

public class Ex17 {
	public static void main(String[] args) {
		PowerSavingBulb psb = new PowerSavingBulb();
		Bulb b = psb.createCFL(); // Downcast
		System.out.println(b);
		// Since CFLBulb is private it's name cannot be accessed.
		// Hence, the inner class is completely hidden.
		//!PowerSavingBulb.CFLBulb cfl = (PowerSavingBulb.CFLBulb) b;
		//!System.out.println("Brightness of CFL is " + cfl.brightness);
	}
}