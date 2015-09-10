/* Create an example where you use a flag to control
 whether cleanup code is called, as described in the
 second paragraph after the heading “Constructors.*/
import java.util.*;

class WaterSystem {
	boolean flag = true;
	WaterSystem() throws Exception {
		try {
			waterOn();
		} catch(Exception e) {
			flag = false;
		} finally {
			if(flag == false) {
				waterOff(); // call clean-up method.
				throw new Exception();
			}
		}
		System.out.println("Water system has been created successfully.");
	}
	void waterOn() throws Exception {
		Random rnd = new Random();
		System.out.println("Water turned On!");
		if(rnd.nextInt(5) == 4) // Randomly produces exception
		throw new Exception();
	}
	void waterOff() { // clean-up method
		System.out.println("Water turned Off");
	}
}

public class Ex15 {
	public static void main(String[] args) throws Exception{
		WaterSystem wtr = new WaterSystem();
	}
}