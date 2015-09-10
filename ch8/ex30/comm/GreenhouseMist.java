package ex30.comm;
import ex30.comm.*;
import ex30.comm.controller.*;
public class GreenhouseMist extends GreenhouseControls {
	private boolean waterGenerator = false;
	public class WaterMistGeneratorOn extends Event {
		WaterMistGeneratorOn(long delayTime) { super(delayTime); }
		public void action() {
			// Hardware control code to turn on generator here...
			waterGenerator = true;
		}
		public String toString() { return "Water mist generator is on"; }
	}
	public class WaterMistGeneratorOff extends Event {
		WaterMistGeneratorOff(long delayTime) { super(delayTime); }
		public void action() {
			//Hardware control code to turn on generator here...
			waterGenerator = false;
		}
		public String toString() { return "Water mist generator is off"; }
	}
}