package Ex11;

public class Week {
	private String name;
	private Week(String nm) {
		name = nm;
	}
	public static final Week
		MON = new Week("Monday"),
		TUE = new Week("Tuesday"),
		WED = new Week("Wednesday"),
		THU = new Week("Thursday"),
		FRI = new Week("Friday"),
		SAT = new Week("Saturday"),
		SUN = new Week("Sunday");
	public static final Week[] week = {
		MON, TUE, WED, THU, FRI, SAT, SUN
	};
	public static Week number(int num) {
		return week[num - 1];
	}
	public String toString() {return name;}
	public static void main(String[] args) {
		Week w = Week.MON;
		System.out.println(w);
		System.out.println(w == Week.MON);
		w = Week.number(3);
		System.out.println(w);
		System.out.println(w.equals(Week.MON));
		System.out.println(Week.week[1]);
	}
}