package ex30.comm;
import ex30.comm.*;
import ex30.comm.controller.*;

public class GreenhouseMistController {
	public static void main(String[] args) {
		GreenhouseMist gm = new GreenhouseMist();
		gm.addEvent(gm.new WaterMistGeneratorOn(900));
		gm.addEvent(gm.new WaterMistGeneratorOff(1800));
		gm.run();
	}
}