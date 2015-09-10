class LightSource {
	void changePriceAndShowStatus() {}
}
class Bulb {
	private double price = 3.99;
	boolean state = true;
	private void statusBulb() {
		if(state) { System.out.println("Bulb is on");}
		else { System.out.println("Bulb is off");}
	}
	void createPowerSavingBulb() {
		// Enclosing class can even access it's
		// local class' elements
		LightSource ls = new LightSource() {
			void changePriceAndShowStatus() {
				// local class can even access 
				// private elements of its enclosing class
				price = 6.99; 
				statusBulb();
			}			
		};
		ls.changePriceAndShowStatus();
	}
}

public class Ex20 {
	public static void main(String[] args) {
		Bulb b = new Bulb();
		b.createPowerSavingBulb();
	}
}