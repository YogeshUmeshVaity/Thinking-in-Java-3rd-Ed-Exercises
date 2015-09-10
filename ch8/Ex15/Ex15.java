interface Display {
	void turnOnDisplay();
}

class BigDisplay {
	Display createMonitorDisplay() {
		return new Display() {
			public void turnOnDisplay() {
				System.out.println("Monitor Display is now on");
				adjustBrightness();
			}
			public void adjustBrightness() {
				System.out.println("Brightness adjusted");
			}
		};
	}
}

public class Ex15 {
	public static void main(String[] args) {
		BigDisplay bd = new BigDisplay();
		Display d = bd.createMonitorDisplay();
		d.turnOnDisplay();
	}
}