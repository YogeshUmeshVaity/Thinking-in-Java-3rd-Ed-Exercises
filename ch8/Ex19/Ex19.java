class Bulb {
	private double price = 3.99;
	boolean state = true;
	private void statusBulb() {
		if(state) { System.out.println("Bulb is on");}
		else { System.out.println("Bulb is off");}
	}
	private class PowerSavingBulb {
		private void changePriceAndShowStatus() {
			// Inner class can even access 
			// private elements of its enclosing class
			price = 6.99; 
			statusBulb();
		}
	}
	void createPowerSavingBulb() {
		// Enclosing class can even access it's
		// inner class' private elements
		PowerSavingBulb psb = new PowerSavingBulb();
		psb.changePriceAndShowStatus();
	}
}

public class Ex19 {
	public static void main(String[] args) {
		Bulb b = new Bulb();
		b.createPowerSavingBulb();
	}
}