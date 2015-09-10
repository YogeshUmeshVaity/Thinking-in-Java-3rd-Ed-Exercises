abstract class AlertStatus {
	abstract void showStatus();
}

class OperationalStatus extends AlertStatus {
	void showStatus() {
		System.out.println("Status : Operational");
	}
}

class NotOperationalStatus extends AlertStatus {
	void showStatus() {
		System.out.println("Status : Not Operational");
	}
}

class SleepModeStatus extends AlertStatus {
	void showStatus() {
		System.out.println("Status : Sleep Mode");
	}
}

class Starship {
	AlertStatus status = new NotOperationalStatus();
	/* void changeStatus() {
		status = new OperationalStatus();
	} */
	void callStatus() {
		status.showStatus();
	}
	void changeStatus(int i) {
		switch(i) {
			default:
			case 0 : status = new NotOperationalStatus(); break;
			case 2 : status = new OperationalStatus(); break;
			case 1 : status = new SleepModeStatus(); break;
		}
	}
}

public class Ex13 {
	public static void main(String[] args) {
		Starship s = new Starship();
		s.callStatus();
		s.changeStatus(1);
		s.callStatus();
		s.changeStatus(2);
		s.callStatus();
	}
}
// Status : Operational, Not Operational, SleepMode