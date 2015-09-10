interface Display {
	void turnOnDisplay();
}

class BigDisplay {
	Display createMonitorDisplay(final int  defaultBrightness) {
	  if(defaultBrightness >= 6) {
		class MonitorDisplay implements Display {
			public void turnOnDisplay() {
				System.out.println("Monitor Display is now on");
				adjustBrightness();
			}
			public void adjustBrightness() {
				System.out.println("Brightness adjusted to " + defaultBrightness);
			}
		}
		return new MonitorDisplay();
	  }
	  else {
		  class NoDisplay implements Display {
			  public void turnOnDisplay() {
				  System.out.println("Display cannot be created below 6 brightness value");
			  }
		  }
		  return new NoDisplay();
	  }
	}
}

public class Ex14 {
	public static void main(String[] args) {
		BigDisplay bd = new BigDisplay();
		Display d = bd.createMonitorDisplay(5);
		d.turnOnDisplay();
	}
}