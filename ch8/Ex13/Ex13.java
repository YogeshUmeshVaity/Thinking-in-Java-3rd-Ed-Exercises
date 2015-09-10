interface Display {
	void turnOnDisplay();
}

class BigDisplay {
	Display createMonitorDisplay() {
		class MonitorDisplay implements Display {
			public void turnOnDisplay() {
				System.out.println("Monitor Display is now on");
				adjustBrightness();
			}
			public void adjustBrightness() {
				System.out.println("Brightness adjusted");
			}
		}
		return new MonitorDisplay();
	}
}

public class Ex13 {
	public static void main(String[] args) {
		BigDisplay bd = new BigDisplay();
		Display d = bd.createMonitorDisplay();
		d.turnOnDisplay();
	}
}