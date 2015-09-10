interface Vehicle {
	class GroundVehicle {
		public String toString() {
			return "GroundVehicle";
		}
	}
}

class Car implements Vehicle {
	GroundVehicle gv = new GroundVehicle();
}

public class Ex22 {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(c.gv);
	}
}